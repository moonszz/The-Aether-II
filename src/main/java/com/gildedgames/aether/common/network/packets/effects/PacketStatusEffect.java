package com.gildedgames.aether.common.network.packets.effects;

import com.gildedgames.aether.api.entity.effects.IAetherStatusEffectPool;
import com.gildedgames.aether.api.entity.effects.IAetherStatusEffects;
import com.gildedgames.aether.api.registrar.CapabilitiesAether;
import com.gildedgames.aether.common.AetherCore;
import com.gildedgames.aether.common.network.MessageHandlerClient;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

import java.util.ArrayList;
import java.util.HashMap;

public class PacketStatusEffect implements IMessage
{

	private ArrayList<StatusEffectData> statusEffectData;
	private int entityID;
	private int numberOfDirtyEffects;

	public PacketStatusEffect()
	{

	}

	public PacketStatusEffect(final Entity entity)
	{
		this.entityID = entity.getEntityId();

		HashMap<String, IAetherStatusEffects> map =  entity.getCapability(CapabilitiesAether.STATUS_EFFECT_POOL, null).getPool();
		this.statusEffectData = new ArrayList<>();

		for (IAetherStatusEffects effect : map.values())
		{
			if (effect.isDirty())
			{
				this.statusEffectData.add(new StatusEffectData(effect.getEffectType().numericValue, effect.getBuildup(), effect.getIsEffectApplied(), effect.calculateResistances()));
				this.numberOfDirtyEffects++;
			}
		}
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.numberOfDirtyEffects = buf.readByte();
		this.entityID = buf.readInt();

		if (this.statusEffectData == null)
		{
			this.statusEffectData = new ArrayList<>();
		}
		for (int i = 0; i < this.numberOfDirtyEffects; i++)
		{
			int effectId = buf.readByte();
			int effectBuildup = buf.readByte();
			boolean isEffectApplied = buf.readBoolean();
			double resistance = buf.readDouble();

			this.statusEffectData.add(new StatusEffectData(effectId,effectBuildup,isEffectApplied, resistance));
		}
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeByte(this.numberOfDirtyEffects);
		buf.writeInt(this.entityID);

		for (StatusEffectData data : this.statusEffectData)
		{
			buf.writeByte(data.effectId);
			buf.writeByte(data.buildup);
			buf.writeBoolean(data.isApplied);
			buf.writeDouble(data.resistance);
		}
	}

	private class StatusEffectData
	{
		private final int effectId;
		private final int buildup;
		private final boolean isApplied;
		private final double resistance;

		StatusEffectData(int effectTypeId, int buildup, boolean isApplied, double resistance)
		{
			this.effectId = effectTypeId;
			this.buildup = buildup;
			this.isApplied = isApplied;
			this.resistance = resistance;
		}
	}

	/**
	 * Only should be used for small doubles with only 1 decimal place.
	 * Has not been tested for values outside of the bounds 0.0 - 2.0
	 */
	public static class SmallDoubleByteConverter
	{
		public static byte convertDoubleToByte(double d)
		{
			int returnByte;
			int base, decimal;

			base = MathHelper.floor(d);
			decimal = (int)((d - base) * 10);

			returnByte = decimal;
			returnByte = (returnByte << 4);
			returnByte = returnByte | base;

			return (byte)returnByte;
		}

		public static double convertByteToDouble(byte b)
		{
			int base, decimal;
			double retVal;

			base = b;
			base = base & 0xf;

			decimal = b;
			decimal = decimal >> 4;
			decimal = decimal & 0xf;

			retVal = (decimal * 0.1);
			retVal += base;

			return retVal;
		}
	}

	public static class HandlerClient extends MessageHandlerClient<PacketStatusEffect, IMessage>
	{

		@Override
		public IMessage onMessage(PacketStatusEffect message, EntityPlayer player)
		{
			if (player == null || player.world == null)
			{
				return null;
			}

			final Entity entity = player.world.getEntityByID(message.entityID);

			if (!(entity instanceof EntityLivingBase))
			{
				AetherCore.LOGGER.warn("Tried to set effects for non-living entity with ID " + message.entityID);

				return null;
			}

			final EntityLivingBase entityLiving = (EntityLivingBase) entity;

			IAetherStatusEffectPool map = entityLiving.getCapability(CapabilitiesAether.STATUS_EFFECT_POOL, null);

			if (map != null)
			{
				if (message.statusEffectData != null)
				{
					for (StatusEffectData data : message.statusEffectData)
					{
						IAetherStatusEffects effect = map.createEffect(IAetherStatusEffects.effectTypes.getEffectFromNumericValue(data.effectId).name, entityLiving);
						effect.setBuildup(data.buildup);
						effect.setApplied(data.isApplied);
					}
				}
			}

			return null;
		}

	}
}
