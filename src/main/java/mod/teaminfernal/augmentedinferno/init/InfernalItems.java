package mod.teaminfernal.augmentedinferno.init;

import mod.teaminfernal.augmentedinferno.items.BasicItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InfernalItems {

	public static Item DEBUG = new BasicItem("debug");
	
	public static void init() {
		register(DEBUG);
	}
	
	public static void registerRenders() {
		registerRender(DEBUG);
	}
	
	public static void register(Item item) {
		GameRegistry.register(item);
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	public static void registerRenderMeta(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName() + "_" + meta, "inventory"));
	}
}
