package com.gildedgames.aether.common.network.packets;

import com.gildedgames.aether.common.containers.tiles.ContainerMasonryBench;
import com.gildedgames.aether.common.network.MessageHandlerServer;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MasonryInputCountChangedPacket implements IMessage
{

	private int inputCount;

	public MasonryInputCountChangedPacket()
	{

	}

	public MasonryInputCountChangedPacket(int inputCount)
	{
		this.inputCount = inputCount;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.inputCount = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(this.inputCount);
	}

	public static class HandlerServer extends MessageHandlerServer<MasonryInputCountChangedPacket, IMessage>
	{
		@Override
		public IMessage onMessage(MasonryInputCountChangedPacket message, EntityPlayer player)
		{
			if (player == null || player.world == null)
			{
				return null;
			}

			if (player.openContainer instanceof ContainerMasonryBench)
			{
				ContainerMasonryBench container = (ContainerMasonryBench) player.openContainer;

				container.setInputCount(message.inputCount);
			}

			return null;
		}
	}
}
