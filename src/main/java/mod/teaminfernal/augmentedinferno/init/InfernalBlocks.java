package mod.teaminfernal.augmentedinferno.init;

import mod.teaminfernal.augmentedinferno.blocks.BasicLeaves;
import mod.teaminfernal.augmentedinferno.blocks.BasicLog;
import mod.teaminfernal.augmentedinferno.blocks.BasicPlanks;
import mod.teaminfernal.augmentedinferno.blocks.BasicSapling;
import mod.teaminfernal.augmentedinferno.blocks.BlockBasalt;
import mod.teaminfernal.augmentedinferno.blocks.BlockBasaltBricks;
import mod.teaminfernal.augmentedinferno.blocks.BlockOreBloodRock;
import mod.teaminfernal.augmentedinferno.blocks.BlockOreInfernium;
import mod.teaminfernal.augmentedinferno.blocks.BlockOreStarcilium;
import mod.teaminfernal.augmentedinferno.blocks.BlockStarcilium;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InfernalBlocks {

	public static Block BASALT = new BlockBasalt();
	public static Block BASALT_BRICKS = new BlockBasaltBricks();
	public static Block EBON_LEAVES = new BasicLeaves("ebon");
	public static Block EBON_LOG = new BasicLog("ebon");
	public static Block EBON_PLANKS = new BasicPlanks("ebon");
	public static Block EBON_SAPLING = new BasicSapling("ebon");
	public static Block HELLBARK_LEAVES = new BasicLeaves("hellbark");
	public static Block HELLBARK_LOG = new BasicLog("hellbark");
	public static Block HELLBARK_PLANKS = new BasicPlanks("hellbark");
	public static Block HELLBARK_SAPLING = new BasicSapling("hellbark");
	//public static Block LAVA_CAP = new BlockLavaCap();
	public static Block INFERNIUM_ORE  = new BlockOreInfernium();
	public static Block STARCILIUM_ORE = new BlockOreStarcilium();
	public static Block BLOOD_ROCK_ORE = new BlockOreBloodRock();
	public static Block STARCILIUM_BLOCK = new BlockStarcilium();
	
	
	public static void init() {
		register(BASALT);
		register(BASALT_BRICKS);
		register(EBON_LEAVES);
		register(EBON_LOG);
		register(EBON_PLANKS);
		register(EBON_SAPLING);
		register(HELLBARK_LEAVES);
		register(HELLBARK_LOG);
		register(HELLBARK_PLANKS);
		register(HELLBARK_SAPLING);
		
		//register(LAVA_CAP);
		register(INFERNIUM_ORE);
		register(STARCILIUM_ORE);
		register(BLOOD_ROCK_ORE);
		register(STARCILIUM_BLOCK);
	}

	public static void registerRenders() {
		registerRender(BASALT);
		registerRender(BASALT_BRICKS);
		registerRender(EBON_LOG);
		registerRender(EBON_PLANKS);
		registerRender(HELLBARK_LOG);
		registerRender(HELLBARK_PLANKS);
		
		//registerRender(LAVA_CAP);
		registerRender(INFERNIUM_ORE);
		registerRender(STARCILIUM_ORE);
		registerRender(BLOOD_ROCK_ORE);
		registerRender(STARCILIUM_BLOCK);
		
		ModelLoader.setCustomStateMapper(HELLBARK_SAPLING, new StateMap.Builder().ignore(new IProperty[]{BasicSapling.STAGE}).build());
		registerRender(HELLBARK_SAPLING);
		ModelLoader.setCustomStateMapper(EBON_SAPLING, new StateMap.Builder().ignore(new IProperty[]{BasicSapling.STAGE}).build());
		registerRender(EBON_SAPLING);
		
		ModelLoader.setCustomStateMapper(EBON_LEAVES, new StateMap.Builder().ignore(new IProperty[]{BasicLeaves.CHECK_DECAY, BasicLeaves.DECAYABLE}).build());
		registerRender(EBON_LEAVES);
		
		ModelLoader.setCustomStateMapper(HELLBARK_LEAVES, new StateMap.Builder().ignore(new IProperty[]{BasicLeaves.CHECK_DECAY, BasicLeaves.DECAYABLE}).build());
		registerRender(HELLBARK_LEAVES);
	}
	
	/**
	 * Registers a Block, also registers an ItemBlock
	 * @param block
	 */
	private static void register(Block block) {
		registerBlock(block);
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		itemBlock.setUnlocalizedName(block.getUnlocalizedName().substring(5));
		GameRegistry.register(itemBlock);
	}
	
	/**
	 * Registers a Block without registering an ItemBlock
	 * @param block
	 */
	private static void registerBlock(Block block) {
		GameRegistry.register(block);
	}
	
	/**
	 * Only call this for blocks that have an existing ItemBlock!
	 * @param block
	 */
	public static void registerRender(Block block) {
		InfernalItems.registerRender(Item.getItemFromBlock(block));
	}
}
