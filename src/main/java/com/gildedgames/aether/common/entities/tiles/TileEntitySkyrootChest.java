package com.gildedgames.aether.common.entities.tiles;

import com.gildedgames.aether.common.entities.TileEntityTypesAether;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TileEntitySkyrootChest extends ChestTileEntity
{
	public TileEntitySkyrootChest() {
		super(TileEntityTypesAether.SKYROOT_CHEST);
	}

	@Override
	protected ITextComponent getDefaultName()
	{
		return new TranslationTextComponent("container.skyroot_chest");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		return new AxisAlignedBB(this.getPos().add(-1, 0, -1), this.getPos().add(2, 2, 2));
	}
}
