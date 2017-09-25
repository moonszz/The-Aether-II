package com.gildedgames.aether.common.world.aether;

import com.gildedgames.aether.client.util.NOOPRenderHandler;
import com.gildedgames.aether.common.blocks.BlocksAether;
import com.gildedgames.aether.common.registry.content.DimensionsAether;
import com.gildedgames.aether.common.world.aether.biomes.BiomeProviderAether;
import com.gildedgames.aether.common.world.aether.island.ChunkGeneratorAether;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderAether extends WorldProviderSurface
{

	private final float[] sunriseSunsetColors = new float[4];

	public WorldProviderAether()
	{
		this.hasNoSky = false;

		if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
		{
			this.setupClientRenderer();
		}
	}

	@SideOnly(Side.CLIENT)
	private void setupClientRenderer()
	{
		this.setCloudRenderer(new NOOPRenderHandler());
	}

	@Override
	protected void init()
	{
		this.hasSkyLight = true;
		this.biomeProvider = new BiomeProviderAether(this.world);
	}

	@Override
	public Biome getBiomeForCoords(final BlockPos pos)
	{
		return this.biomeProvider.getBiome(pos);
	}

	@Override
	public IChunkGenerator createChunkGenerator()
	{
		return new ChunkGeneratorAether(this.world, this.world.getSeed());
	}

	public BlockPos getTopBlockPos(final BlockPos pos)
	{
		BlockPos.MutableBlockPos testPos = new BlockPos.MutableBlockPos(pos.getX(), 0, pos.getZ());

		while (!this.world.isAirBlock(testPos.up()))
		{
			testPos = testPos.move(EnumFacing.UP);
		}

		return testPos;
	}

	@Override
	public void calculateInitialWeather()
	{

	}

	@Override
	public void updateWeather()
	{

	}

	@Override
	public boolean canSnowAt(final BlockPos pos, final boolean checkLight)
	{
		return false;
	}

	@Override
	public boolean canDoLightning(final net.minecraft.world.chunk.Chunk chunk)
	{
		return false;
	}

	@Override
	public boolean canDoRainSnowIce(final net.minecraft.world.chunk.Chunk chunk)
	{
		return false;
	}

	@Override
	public int getRespawnDimension(final EntityPlayerMP player)
	{
		return 0;
	}

	@Override
	public boolean canCoordinateBeSpawn(final int x, final int z)
	{
		final BlockPos top = this.getTopBlockPos(new BlockPos(x, 0, z));

		return !this.world.isAirBlock(top) && this.world.getBlockState(top) == BlocksAether.aether_grass.getDefaultState();
	}

	@Override
	public boolean canRespawnHere()
	{
		return true;
	}

	@Override
	public boolean isSurfaceWorld()
	{
		return true;
	}

	@Override
	public String getSaveFolder()
	{
		return "AETHER";
	}

	@Override
	public String getWelcomeMessage()
	{
		return "Ascending to the Aether";
	}

	@Override
	public String getDepartMessage()
	{
		return "Descending from the Aether";
	}

	@Override
	public double getHorizon()
	{
		return 0.0;
	}

	@Override
	public DimensionType getDimensionType()
	{
		return DimensionsAether.AETHER;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Vec3d getFogColor(final float angle, final float partialTicks)
	{
		final int color = 0x8080a0;

		float cos = MathHelper.cos(angle * 3.141593F * 2.0F) * 2.0F + 0.5F;

		if (cos < 0.0F)
		{
			cos = 0.0F;
		}
		else if (cos > 1.0F)
		{
			cos = 1.0F;
		}

		float red = (color >> 16 & 0xff) / 255F;
		float green = (color >> 8 & 0xff) / 255F;
		float blue = (color & 0xff) / 255F;

		red *= cos * 0.94F + 0.06F;
		green *= cos * 0.94F + 0.06F;
		blue *= cos * 0.91F + 0.09F;

		return new Vec3d(red, green, blue);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float[] calcSunriseSunsetColors(final float angle, final float partialTicks)
	{
		final float f2 = 0.4F;
		final float cos = MathHelper.cos(angle * 3.141593F * 2.0F) - 0.0F;
		final float f4 = -0F;

		if (cos >= f4 - f2 && cos <= f4 + f2)
		{
			final float f5 = (cos - f4) / f2 * 0.5F + 0.5F;
			float f6 = 1.0F - (1.0F - MathHelper.sin(f5 * 3.141593F)) * 0.99F;
			f6 *= f6;

			this.sunriseSunsetColors[0] = f5 * 0.3F + 0.1F;
			this.sunriseSunsetColors[1] = f5 * f5 * 0.7F + 0.2F;
			this.sunriseSunsetColors[2] = f5 * f5 * 0.7F + 0.2F;
			this.sunriseSunsetColors[3] = f6;

			return this.sunriseSunsetColors;
		}
		else
		{
			return null;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public double getVoidFogYFactor()
	{
		return 0.03125D;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getCloudHeight()
	{
		return -128;
	}

	@Override
	public boolean canDropChunk(final int x, final int z)
	{
		return true;
	}
}