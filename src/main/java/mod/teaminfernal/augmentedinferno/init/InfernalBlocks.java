package mod.teaminfernal.augmentedinferno.init;

import mod.teaminfernal.augmentedinferno.blocks.BasicBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InfernalBlocks {

	public static Block TEST = new BasicBlock("Test");
	
	public static void init() {
		register(TEST);
	}

	public static void registerRenders() {
		registerRender(TEST);
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
