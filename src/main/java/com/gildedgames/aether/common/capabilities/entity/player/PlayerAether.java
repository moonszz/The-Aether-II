package com.gildedgames.aether.common.capabilities.entity.player;

import com.gildedgames.aether.api.AetherCapabilities;
import com.gildedgames.aether.api.dialog.IDialogController;
import com.gildedgames.aether.api.player.IPlayerAether;
import com.gildedgames.aether.common.AetherCore;
import com.gildedgames.aether.common.capabilities.entity.player.modules.*;
import com.gildedgames.aether.common.network.NetworkingAether;
import com.gildedgames.aether.common.network.packets.PacketEquipment;
import com.gildedgames.aether.common.network.packets.PacketMarkPlayerDeath;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.ArrayList;
import java.util.Collection;

public class PlayerAether implements IPlayerAether
{
	private final PlayerAetherModule[] modules;

	private final EntityPlayer entity;

	private final PlayerAbilitiesModule abilitiesModule;

	private final PlayerBlockLevitateModule gravititeAbilityModule;

	private final PlayerPortalModule teleportingModule;

	private final PlayerParachuteModule parachuteModule;

	private final PlayerEquipmentModule equipmentModule;

	private final PlayerDialogModule dialogModule;

	private boolean hasDiedInAetherBefore;

	public PlayerAether(EntityPlayer entity)
	{
		this.entity = entity;

		this.abilitiesModule = new PlayerAbilitiesModule(this);
		this.gravititeAbilityModule = new PlayerBlockLevitateModule(this);
		this.teleportingModule = new PlayerPortalModule(this);
		this.parachuteModule = new PlayerParachuteModule(this);
		this.equipmentModule = new PlayerEquipmentModule(this);
		this.dialogModule = new PlayerDialogModule(this);

		Collection<PlayerAetherModule> modules = new ArrayList<>();
		modules.add(this.abilitiesModule);
		modules.add(this.gravititeAbilityModule);
		modules.add(this.teleportingModule);
		modules.add(this.parachuteModule);
		modules.add(this.equipmentModule);
		modules.add(this.dialogModule);

		this.modules = modules.toArray(new PlayerAetherModule[modules.size()]);
	}

	public static PlayerAether getPlayer(Entity player)
	{
		if (!PlayerAether.hasCapability(player))
		{
			return null;
		}

		return (PlayerAether) player.getCapability(AetherCapabilities.PLAYER_DATA, null);
	}

	public static boolean hasCapability(Entity entity)
	{
		return entity.hasCapability(AetherCapabilities.PLAYER_DATA, null);
	}

	public boolean hasDiedInAetherBefore()
	{
		return this.hasDiedInAetherBefore;
	}

	public void setHasDiedInAetherBefore(boolean flag)
	{
		this.hasDiedInAetherBefore = flag;
	}

	/**
	 * Syncs the client and watching entities completely.
	 */
	public void sendFullUpdate()
	{
		NetworkingAether.sendPacketToPlayer(new PacketMarkPlayerDeath(this.hasDiedInAetherBefore()), (EntityPlayerMP) this.getEntity());
	}

	public void onUpdate(LivingUpdateEvent event)
	{
		for (PlayerAetherModule module : this.modules)
		{
			module.onUpdate();
		}
	}

	public void onRespawn(PlayerEvent.PlayerRespawnEvent event)
	{
		this.sendFullUpdate();
	}

	public void onPlaceBlock(BlockEvent.PlaceEvent event)
	{

	}

	public void onDeath(LivingDeathEvent event)
	{
		this.gravititeAbilityModule.onDeath(event);
	}

	public void onDrops(PlayerDropsEvent event)
	{
		if (!this.getEntity().world.isRemote && !this.getEntity().world.getGameRules().getBoolean("keepInventory"))
		{
			for (int i = 0; i < this.getEquipmentModule().getInventory().getSizeInventory(); i++)
			{
				ItemStack stack = this.getEquipmentModule().getInventory().removeStackFromSlot(i);

				if (!stack.isEmpty())
				{
					this.getEntity().dropItem(stack, true, true);
				}
			}
		}
	}

	public void onHurt(LivingHurtEvent event)
	{
		PlayerAether aePlayer = PlayerAether.getPlayer(event.getEntity());

		if (aePlayer != null)
		{
			if (aePlayer.getEquipmentModule().getEffectPool(new ResourceLocation(AetherCore.MOD_ID, "fire_immunity")).isPresent())
			{
				if (event.getSource() == DamageSource.ON_FIRE || event.getSource() == DamageSource.IN_FIRE || event.getSource() == DamageSource.LAVA)
				{
					event.setCanceled(true);
				}
			}
		}
	}

	public void onFall(LivingFallEvent event)
	{
		this.abilitiesModule.onFall(event);
	}

	public void onTeleport(PlayerEvent.PlayerChangedDimensionEvent event)
	{
		this.sendFullUpdate();

		this.equipmentModule.onTeleport();
	}

	public void onPlayerBeginWatching(IPlayerAether other)
	{
		NetworkingAether.sendPacketToPlayer(new PacketEquipment(this), (EntityPlayerMP) other.getEntity());
	}

	@Override
	public IDialogController getDialogController()
	{
		return this.dialogModule;
	}

	@Override
	public float getMiningSpeedMultiplier()
	{
		if (this.getEntity().getAir() == 300 && this.getEntity().isPotionActive(MobEffects.WATER_BREATHING))
		{
			if (!EnchantmentHelper.getAquaAffinityModifier(this.entity) &&
					this.entity.isInsideOfMaterial(Material.WATER))
			{
				return 5.0f;
			}
		}

		return 1.0f;
	}

	@Override
	public void write(NBTTagCompound tag)
	{
		NBTTagCompound modules = new NBTTagCompound();

		for (PlayerAetherModule module : this.modules)
		{
			module.write(modules);
		}

		tag.setTag("Modules", modules);
		tag.setBoolean("HasDiedInAether", this.hasDiedInAetherBefore);
	}

	@Override
	public void read(NBTTagCompound tag)
	{
		NBTTagCompound modules = tag.getCompoundTag("Modules");

		for (PlayerAetherModule module : this.modules)
		{
			module.read(modules);
		}

		this.hasDiedInAetherBefore = tag.getBoolean("HasDiedInAether");
	}

	@Override
	public EntityPlayer getEntity()
	{
		return this.entity;
	}

	public PlayerBlockLevitateModule getGravititeAbility()
	{
		return this.gravititeAbilityModule;
	}

	public PlayerPortalModule getTeleportingModule()
	{
		return this.teleportingModule;
	}

	public PlayerParachuteModule getParachuteModule()
	{
		return this.parachuteModule;
	}

	public PlayerAbilitiesModule getAbilitiesModule()
	{
		return this.abilitiesModule;
	}

	@Override
	public PlayerEquipmentModule getEquipmentModule()
	{
		return this.equipmentModule;
	}

	public static class Storage implements IStorage<IPlayerAether>
	{
		@Override
		public NBTBase writeNBT(Capability<IPlayerAether> capability, IPlayerAether instance, EnumFacing side)
		{
			NBTTagCompound compound = new NBTTagCompound();
			instance.write(compound);

			return compound;
		}

		@Override
		public void readNBT(Capability<IPlayerAether> capability, IPlayerAether instance, EnumFacing side, NBTBase nbt)
		{
			NBTTagCompound compound = (NBTTagCompound) nbt;

			instance.read(compound);
		}
	}
}