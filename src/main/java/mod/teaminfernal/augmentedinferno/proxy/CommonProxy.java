package mod.teaminfernal.augmentedinferno.proxy;

import mod.teaminfernal.augmentedinferno.init.InfernalBlocks;
import mod.teaminfernal.augmentedinferno.init.InfernalItems;
import mod.teaminfernal.augmentedinferno.init.InfernalMisc;
import mod.teaminfernal.augmentedinferno.init.ModConfig;
import mod.teaminfernal.augmentedinferno.util.UpdateEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		ModConfig.init(event);
		InfernalBlocks.init();
		InfernalItems.init();
		InfernalMisc.init();
	}
	
	public void init(FMLInitializationEvent event) {
		UpdateEvent.init();
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}
