package com.gildedgames.aether.common.registry;

import com.gildedgames.aether.common.world.features.*;
import com.gildedgames.aether.common.world.features.placement_conditions.*;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;

public class GenerationAether
{
	
	public static WorldGenTemplate blue_skyroot_tree_1, blue_skyroot_tree_2, blue_skyroot_tree_3;

	public static WorldGenTemplate green_skyroot_tree_1, green_skyroot_tree_2, green_skyroot_tree_3;

	public static WorldGenTemplate green_skyroot_oak_1, green_skyroot_oak_2;

	public static WorldGenTemplate golden_oak_1, golden_oak_2;

	public static WorldGenTemplate green_skyroot_windswept_1, green_skyroot_windswept_2, green_skyroot_windswept_3, green_skyroot_windswept_4, green_skyroot_windswept_5;

	public static WorldGenTemplate large_green_skyroot_pine_1, large_green_skyroot_pine_2, large_green_skyroot_pine_3, large_green_skyroot_pine_4;

	public static WorldGenTemplate green_skyroot_pine_1, green_skyroot_pine_2, green_skyroot_pine_3, green_skyroot_pine_4, green_skyroot_pine_5;

	public static WorldGenTemplate dark_blue_skyroot_tree_1, dark_blue_skyroot_tree_2, dark_blue_skyroot_tree_3;

	public static WorldGenTemplate dark_blue_skyroot_oak_1, dark_blue_skyroot_oak_2;

	public static WorldGenTemplate labyrinth_ruins_1, labyrinth_ruins_2, labyrinth_ruins_3, labyrinth_ruins_4, labyrinth_ruins_5;

	public static WorldGenTemplate skyroot_moa_nest_tree_1, skyroot_moa_nest_1, skyroot_moa_nest_2;

	public static WorldGenTemplate labyrinth_entrance_1, labyrinth_entrance_underground_1;

	public static WorldGenTemplate aether_portal, nether_portal, end_portal;

	public static WorldGenTemplateGroup green_skyroot_windswept, labyrinth_ruins;

	public static WorldGenTemplateGroup large_green_skyroot_pine, green_skyroot_pine;

	public static WorldGenTemplateGroup blue_skyroot_tree, green_skyroot_tree, golden_oak, green_skyroot_oak;

	public static WorldGenTemplateGroup dark_blue_skyroot_tree, dark_blue_skyroot_oak;

	public static WorldGenTemplateGroup skyroot_moa_nest, labyrinth_entrance;

	public static WorldGenAetherTallGrass aether_grass;

	private GenerationAether()
	{

	}

	public static void init()
	{
		blue_skyroot_tree_1 = new WorldGenTemplate(TemplatesAether.blue_skyroot_tree_1, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		blue_skyroot_tree_2 = new WorldGenTemplate(TemplatesAether.blue_skyroot_tree_2, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		blue_skyroot_tree_3 = new WorldGenTemplate(TemplatesAether.blue_skyroot_tree_3, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());

		green_skyroot_tree_1 = new WorldGenTemplate(TemplatesAether.green_skyroot_tree_1, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		green_skyroot_tree_2 = new WorldGenTemplate(TemplatesAether.green_skyroot_tree_2, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		green_skyroot_tree_3 = new WorldGenTemplate(TemplatesAether.green_skyroot_tree_3, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());

		green_skyroot_oak_1 = new WorldGenTemplate(TemplatesAether.green_skyroot_oak_1, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		green_skyroot_oak_2 = new WorldGenTemplate(TemplatesAether.green_skyroot_oak_2, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());

		golden_oak_1 = new WorldGenTemplate(TemplatesAether.golden_oak_1, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		golden_oak_2 = new WorldGenTemplate(TemplatesAether.golden_oak_2, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());

		dark_blue_skyroot_oak_1 = new WorldGenTemplate(TemplatesAether.dark_blue_skyroot_oak_1, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		dark_blue_skyroot_oak_2 = new WorldGenTemplate(TemplatesAether.dark_blue_skyroot_oak_2, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());

		WorldGenTemplate.CenterOffsetProcessor oak_center = new WorldGenTemplate.CenterOffsetProcessor()
		{
			@Override
			public BlockPos getOffset(Rotation rotation)
			{
				if (rotation == Rotation.CLOCKWISE_90)
				{
					return new BlockPos(-1, 0, 0);
				}

				if (rotation == Rotation.COUNTERCLOCKWISE_90)
				{
					return new BlockPos(0, 0, -1);
				}

				if (rotation == Rotation.CLOCKWISE_180)
				{
					return new BlockPos(-1, 0, -1);
				}

				return new BlockPos(0, 0, 0);
			}
		};

		golden_oak_1.setCenterOffsetProcessor(oak_center);
		golden_oak_2.setCenterOffsetProcessor(oak_center);
		green_skyroot_oak_1.setCenterOffsetProcessor(oak_center);
		green_skyroot_oak_2.setCenterOffsetProcessor(oak_center);
		dark_blue_skyroot_oak_1.setCenterOffsetProcessor(oak_center);
		dark_blue_skyroot_oak_2.setCenterOffsetProcessor(oak_center);

		green_skyroot_windswept_1 = new WorldGenTemplate(TemplatesAether.green_skyroot_windswept_1, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		green_skyroot_windswept_2 = new WorldGenTemplate(TemplatesAether.green_skyroot_windswept_2, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		green_skyroot_windswept_3 = new WorldGenTemplate(TemplatesAether.green_skyroot_windswept_3, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		green_skyroot_windswept_4 = new WorldGenTemplate(TemplatesAether.green_skyroot_windswept_4, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		green_skyroot_windswept_5 = new WorldGenTemplate(TemplatesAether.green_skyroot_windswept_5, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());

		large_green_skyroot_pine_1 = new WorldGenTemplate(TemplatesAether.large_green_skyroot_pine_1, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		large_green_skyroot_pine_2 = new WorldGenTemplate(TemplatesAether.large_green_skyroot_pine_2, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		large_green_skyroot_pine_3 = new WorldGenTemplate(TemplatesAether.large_green_skyroot_pine_3, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		large_green_skyroot_pine_4 = new WorldGenTemplate(TemplatesAether.large_green_skyroot_pine_4, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());

		green_skyroot_pine_1 = new WorldGenTemplate(TemplatesAether.green_skyroot_pine_1, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		green_skyroot_pine_2 = new WorldGenTemplate(TemplatesAether.green_skyroot_pine_2, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		green_skyroot_pine_3 = new WorldGenTemplate(TemplatesAether.green_skyroot_pine_3, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		green_skyroot_pine_4 = new WorldGenTemplate(TemplatesAether.green_skyroot_pine_4, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		green_skyroot_pine_5 = new WorldGenTemplate(TemplatesAether.green_skyroot_pine_5, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());

		dark_blue_skyroot_tree_1 = new WorldGenTemplate(TemplatesAether.dark_blue_skyroot_tree_1, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		dark_blue_skyroot_tree_2 = new WorldGenTemplate(TemplatesAether.dark_blue_skyroot_tree_2, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		dark_blue_skyroot_tree_3 = new WorldGenTemplate(TemplatesAether.dark_blue_skyroot_tree_3, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());

		labyrinth_ruins_1 = new WorldGenTemplate(TemplatesAether.labyrinth_ruins_1, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		labyrinth_ruins_2 = new WorldGenTemplate(TemplatesAether.labyrinth_ruins_2, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		labyrinth_ruins_3 = new WorldGenTemplate(TemplatesAether.labyrinth_ruins_3, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		labyrinth_ruins_4 = new WorldGenTemplate(TemplatesAether.labyrinth_ruins_4, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		labyrinth_ruins_5 = new WorldGenTemplate(TemplatesAether.labyrinth_ruins_5, new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());

		labyrinth_entrance_1 = new WorldGenDungeonEntrance(TemplatesAether.labyrinth_entrance_1, new BlockPos(4, 2, 4), new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		labyrinth_entrance_underground_1 = new WorldGenDungeonEntrance(TemplatesAether.labyrinth_entrance_underground_1, new BlockPos(8, 1, 2), new UndergroundEntrancePlacementCondition(), new UndergroundPlacementCondition());

		skyroot_moa_nest_tree_1 = new WorldGenMoaNest(TemplatesAether.skyroot_moa_nest_tree_1, new BlockPos(4, 5, 4), new FlatGroundPlacementCondition(), new ReplaceablePlacementCondition());
		skyroot_moa_nest_1 = new WorldGenMoaNest(TemplatesAether.skyroot_moa_nest_1, new BlockPos(2, 0, 2), new InsideGroundPlacementCondition(), new ReplaceablePlacementCondition());
		skyroot_moa_nest_2 = new WorldGenMoaNest(TemplatesAether.skyroot_moa_nest_2, new BlockPos(3, 0, 3), new InsideGroundPlacementCondition(), new ReplaceablePlacementCondition());
		
		aether_portal = new WorldGenTemplate(TemplatesAether.aether_portal, new ReplaceablePlacementCondition());
		nether_portal = new WorldGenTemplate(TemplatesAether.nether_portal, new ReplaceablePlacementCondition());
		end_portal = new WorldGenTemplate(TemplatesAether.end_portal, new ReplaceablePlacementCondition());

		blue_skyroot_tree = new WorldGenTemplateGroup(blue_skyroot_tree_1, blue_skyroot_tree_2, blue_skyroot_tree_3);
		green_skyroot_tree = new WorldGenTemplateGroup(green_skyroot_tree_1, green_skyroot_tree_2, green_skyroot_tree_3);
		golden_oak = new WorldGenTemplateGroup(golden_oak_1, golden_oak_2);
		green_skyroot_oak = new WorldGenTemplateGroup(green_skyroot_oak_1, green_skyroot_oak_2);
		green_skyroot_windswept = new WorldGenTemplateGroup(green_skyroot_windswept_1, green_skyroot_windswept_2, green_skyroot_windswept_3, green_skyroot_windswept_4, green_skyroot_windswept_5);
		large_green_skyroot_pine = new WorldGenTemplateGroup(large_green_skyroot_pine_1, large_green_skyroot_pine_2, large_green_skyroot_pine_3, large_green_skyroot_pine_4);
		green_skyroot_pine = new WorldGenTemplateGroup(green_skyroot_pine_1, green_skyroot_pine_2, green_skyroot_pine_3, green_skyroot_pine_4, green_skyroot_pine_5);
		dark_blue_skyroot_tree = new WorldGenTemplateGroup(dark_blue_skyroot_tree_1, dark_blue_skyroot_tree_2, dark_blue_skyroot_tree_3);
		dark_blue_skyroot_oak = new WorldGenTemplateGroup(dark_blue_skyroot_oak_1, dark_blue_skyroot_oak_2);
		labyrinth_ruins = new WorldGenTemplateGroup(labyrinth_ruins_1, labyrinth_ruins_2, labyrinth_ruins_3, labyrinth_ruins_4, labyrinth_ruins_5);
		skyroot_moa_nest = new WorldGenTemplateGroup(skyroot_moa_nest_1, skyroot_moa_nest_2);
		labyrinth_entrance = new WorldGenTemplateGroup(labyrinth_entrance_1);

		aether_grass = new WorldGenAetherTallGrass();
	}

}