package com.gildedgames.aether.api.orbis_core.processing;

import com.gildedgames.aether.api.orbis.IRegion;
import com.gildedgames.aether.api.orbis_core.api.BlueprintDefinition;
import com.gildedgames.aether.api.orbis_core.api.ICreationData;
import com.gildedgames.aether.api.orbis_core.api.PlacementCondition;
import com.gildedgames.aether.api.orbis_core.api.util.BlueprintUtil;
import com.gildedgames.aether.api.orbis_core.block.BlockData;
import com.gildedgames.aether.api.orbis_core.block.BlockDataContainer;
import com.gildedgames.aether.api.orbis_core.block.BlockInstance;
import com.gildedgames.aether.api.orbis_core.data.BlueprintData;
import com.gildedgames.aether.api.orbis_core.data.region.Region;
import com.gildedgames.aether.api.orbis_core.util.OrbisTuple;
import com.gildedgames.aether.api.orbis_core.util.RotationHelp;
import com.gildedgames.aether.api.world.generation.IBlockAccessExtended;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class DataPrimer
{

	private final IBlockAccessExtended access;

	public DataPrimer(final IBlockAccessExtended primer)
	{
		this.access = primer;
	}

	@Nullable
	public World getWorld()
	{
		return this.access.getWorld();
	}

	public IBlockAccessExtended getAccess()
	{
		return this.access;
	}

	public void createChunk(final ChunkPos chunk, final World world, final BlueprintData def, final ICreationData data)
	{
		if (def.getBlockDataContainer().getWidth() >= 1 && def.getBlockDataContainer().getHeight() >= 1 && def.getBlockDataContainer().getLength() >= 1)
		{
			final int minX = chunk.chunkXPos * 16;
			final int minY = 0;
			final int minZ = chunk.chunkZPos * 16;

			final int maxX = minX + 15;
			final int maxY = world.getActualHeight();
			final int maxZ = minZ + 15;

			final IRegion chunkBB = new Region(new BlockPos(minX, minY, minZ), new BlockPos(maxX, maxY, maxZ));

			this.create(def.getBlockDataContainer(), data, chunkBB);
		}
	}

	public boolean canGenerate(final BlueprintDefinition def, final ICreationData data)
	{
		final BlockPos pos = data.getPos();

		if (data.getPos().getY() + def.getData().getHeight() > 256)
		{
			return false;
		}

		final BlockDataContainer blocks = def.getData().getBlockDataContainer();

		final int rotAmount = Math.abs(RotationHelp.getRotationAmount(data.getRotation(), Rotation.NONE));

		if (rotAmount != 0)
		{
			final BlockPos min = data.getPos();
			final BlockPos max = new BlockPos(min.getX() + blocks.getWidth() - 1, min.getY() + blocks.getHeight() - 1,
					min.getZ() + blocks.getLength() - 1);

			for (final OrbisTuple<BlockPos, BlockPos> tuple : RotationHelp.getAllInBoxRotated(min, max, data.getRotation()))
			{
				final BlockPos beforeRot = tuple.getFirst();
				final BlockPos rotated = tuple.getSecond();

				final BlockData block = blocks
						.get(beforeRot.getX() - min.getX(), beforeRot.getY() - min.getY(), beforeRot.getZ() - min.getZ());

				for (final PlacementCondition condition : def.getConditions())
				{
					if (!this.access.canAccess(pos) || !condition.canPlace(def.getData(), this.access, pos, block, rotated))
					{
						return false;
					}
				}
			}

			// TODO: Do check for canPlaceCheckAll as well
		}
		else
		{
			int index = 0;

			for (final BlockData block : blocks)
			{
				final int x = def.getData().getBlockDataContainer().getX(index) + pos.getX();
				final int y = def.getData().getBlockDataContainer().getY(index) + pos.getY();
				final int z = def.getData().getBlockDataContainer().getZ(index) + pos.getZ();

				for (final PlacementCondition condition : def.getConditions())
				{
					if (!this.access.canAccess(pos) || !condition.canPlace(def.getData(), this.access, pos, block, new BlockPos(x, y, z)))
					{
						return false;
					}
				}

				index++;
			}

			for (final PlacementCondition condition : def.getConditions())
			{
				if (!condition.canPlaceCheckAll(def.getData(), this.access, pos, blocks))
				{
					return false;
				}
			}
		}

		return true;
	}

	public boolean canGenerate(final World world, final BlueprintDefinition def, final ICreationData data)
	{
		return this.canGenerate(world, def, data, true);
	}

	public boolean canGenerateWithoutAreaCheck(final World world, final BlueprintDefinition def, final ICreationData data)
	{
		return this.canGenerate(world, def, data, false);
	}

	private boolean canGenerate(final World world, final BlueprintDefinition def, final ICreationData data, final boolean checkAreaLoaded)
	{
		final BlockPos pos = data.getPos();

		final IRegion bb = BlueprintUtil.getRegionFromDefinition(def.getData(), data);

		if ((checkAreaLoaded && !world.isAreaLoaded(bb.getMin(), bb.getMax(), true)) || bb.getMax().getY() > world.getActualHeight())
		{
			return false;
		}

		final BlockDataContainer blocks = def.getData().getBlockDataContainer();

		final int rotAmount = Math.abs(RotationHelp.getRotationAmount(data.getRotation(), Rotation.NONE));

		if (rotAmount != 0)
		{
			final BlockPos min = data.getPos();
			final BlockPos max = new BlockPos(min.getX() + blocks.getWidth() - 1, min.getY() + blocks.getHeight() - 1,
					min.getZ() + blocks.getLength() - 1);

			for (final OrbisTuple<BlockPos, BlockPos> tuple : RotationHelp.getAllInBoxRotated(min, max, data.getRotation()))
			{
				final BlockPos beforeRot = tuple.getFirst();
				final BlockPos rotated = tuple.getSecond();

				final BlockData block = blocks
						.get(beforeRot.getX() - min.getX(), beforeRot.getY() - min.getY(), beforeRot.getZ() - min.getZ());

				for (final PlacementCondition condition : def.getConditions())
				{
					if (!this.access.canAccess(pos) || !condition.canPlace(def.getData(), this.access, pos, block, rotated))
					{
						return false;
					}
				}
			}
		}
		else
		{
			int index = 0;

			for (final BlockData block : blocks)
			{
				final int x = def.getData().getBlockDataContainer().getX(index) + pos.getX();
				final int y = def.getData().getBlockDataContainer().getY(index) + pos.getY();
				final int z = def.getData().getBlockDataContainer().getZ(index) + pos.getZ();

				for (final PlacementCondition condition : def.getConditions())
				{
					if (!this.access.canAccess(pos) || !condition.canPlace(def.getData(), this.access, pos, block, new BlockPos(x, y, z)))
					{
						return false;
					}
				}

				index++;
			}

			for (final PlacementCondition condition : def.getConditions())
			{
				if (!condition.canPlaceCheckAll(def.getData(), this.access, pos, blocks))
				{
					return false;
				}
			}
		}

		return true;
	}

	public void create(final BlockInstance instance, final ICreationData data)
	{
		this.create(instance.getBlockData(), instance.getPos(), data);
	}

	public void create(final BlockData blockData, final BlockPos pos, final ICreationData creationData)
	{
		if (!blockData.isVoid())
		{
			final IBlockState rotated = blockData.getRotatedBlockState(creationData.getRotation());

			this.access.setBlockState(pos, rotated);

			if (blockData.getTileEntity() != null && this.access.getWorld() != null)
			{
				blockData.getTileEntity().setWorld(this.access.getWorld());

				this.access.setTileEntity(pos, TileEntity.create(this.access.getWorld(), blockData.getTileEntity().serializeNBT()));
			}
		}

		// TODO: Re-enable event.
		/*final ChangeBlockEvent changeBlockEvent = new ChangeBlockEvent(creationData.getWorld(), pos, creationData.getCreator());
		MinecraftForge.EVENT_BUS.post(changeBlockEvent);*/
	}

	public void create(final BlockDataContainer container, final ICreationData data)
	{
		this.create(container, data, null);
	}

	public void create(final BlockDataContainer container, final ICreationData data, final IRegion insideRegion)
	{
		final boolean xNeg = data.getPos().getX() < 0;
		final boolean yNeg = data.getPos().getY() < 0;
		final boolean zNeg = data.getPos().getZ() < 0;

		final BlockPos min = data.getPos();//new BlockPos(Math.abs(data.getPos().getX()), Math.abs(data.getPos().getY()), Math.abs(data.getPos().getZ()));
		final BlockPos max = new BlockPos(min.getX() + container.getWidth() - 1, min.getY() + container.getHeight() - 1,
				min.getZ() + container.getLength() - 1);

		final int rotAmount = Math.abs(RotationHelp.getRotationAmount(data.getRotation(), Rotation.NONE));

		if (rotAmount != 0)
		{
			for (final OrbisTuple<BlockPos, BlockPos> tuple : RotationHelp.getAllInBoxRotated(min, max, data.getRotation()))
			{
				final BlockPos beforeRot = tuple.getFirst();
				final BlockPos rotated = tuple.getSecond();

				if (insideRegion == null || insideRegion.contains(rotated))
				{
					final BlockData toCreate;

					toCreate = container.get(beforeRot.getX() - min.getX(), beforeRot.getY() - min.getY(), beforeRot.getZ() - min.getZ());

					//this.create(toCreate, new BlockPos(), data);
				}
			}
		}
		else
		{
			final Region region = new Region(new BlockPos(0, 0, 0),
					new BlockPos(container.getWidth() - 1, container.getHeight() - 1, container.getLength() - 1));

			for (final BlockPos.MutableBlockPos iterPos : region.getMutableBlockPosInRegion())
			{
				if (insideRegion == null || insideRegion.contains(iterPos.getX() + min.getX(), iterPos.getY() + min.getY(),
						iterPos.getZ() + min.getZ()))
				{
					final BlockData block = container.get(iterPos.getX(), iterPos.getY(), iterPos.getZ());

					if (block != null)
					{
						this.create(block, iterPos.toImmutable().add(min.getX(), min.getY(), min.getZ()), data);
					}
				}
			}
		}
	}

}