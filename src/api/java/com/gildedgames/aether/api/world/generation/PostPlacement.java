package com.gildedgames.aether.api.world.generation;

import net.minecraft.world.World;

import java.util.Random;

public interface PostPlacement
{

	void postGenerate(World world, Random rand, TemplateLoc loc);

}
