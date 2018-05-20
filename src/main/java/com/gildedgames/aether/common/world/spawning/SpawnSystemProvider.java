package com.gildedgames.aether.common.world.spawning;

import com.gildedgames.aether.api.AetherCapabilities;
import com.gildedgames.aether.api.world.ISpawnSystem;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SpawnSystemProvider implements ICapabilityProvider
{
	private final ISpawnSystem system;

	public SpawnSystemProvider(ISpawnSystem system)
	{
		this.system = system;
	}

	@Override
	public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing)
	{
		return capability == AetherCapabilities.SPAWN_SYSTEM;
	}

	@Nullable
	@Override
	public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing)
	{
		if (this.hasCapability(capability, facing))
		{
			return (T) this.system;
		}

		return null;
	}
}