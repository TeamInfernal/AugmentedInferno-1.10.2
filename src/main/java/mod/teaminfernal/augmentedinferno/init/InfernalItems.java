package mod.teaminfernal.augmentedinferno.init;

import mod.teaminfernal.augmentedinferno.items.ItemBloodRock;
import mod.teaminfernal.augmentedinferno.items.ItemEctoplasm;
import mod.teaminfernal.augmentedinferno.items.ItemInferniumShard;
import mod.teaminfernal.augmentedinferno.items.ItemRune;
import mod.teaminfernal.augmentedinferno.items.ItemStarcilium;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InfernalItems {

	public static Item ECTOPLASM = new ItemEctoplasm();
	public static Item RUNE = new ItemRune();
	public static Item STARCILIUM = new ItemStarcilium();
	public static Item INFERNIUM_SHARD = new ItemInferniumShard();
	public static Item BLOOD_ROCK = new ItemBloodRock();
	
	public static void init() {
		register(INFERNIUM_SHARD);
		register(ECTOPLASM);
		register(RUNE);
		register(STARCILIUM);
		register(BLOOD_ROCK);
	}
	
	public static void registerRenders() {
		registerRender(ECTOPLASM);
		registerRender(RUNE);
		registerRender(STARCILIUM);
		registerRender(INFERNIUM_SHARD);
		registerRender(BLOOD_ROCK);
	}
	
	public static void register(Item item) {
		GameRegistry.register(item);
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		item.setCreativeTab(InfernalTabs.tabInfernal);
	}
	
	public static void registerRenderMeta(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName() + "_" + meta, "inventory"));
	}
}
