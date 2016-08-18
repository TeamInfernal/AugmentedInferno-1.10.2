package mod.teaminfernal.augmentedinferno.init;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModConfig {

	public static boolean enableUpdateChecker;

	public static void init(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		/** Configuration Start **/
			enableUpdateChecker = config.getBoolean("enableUpdateChecker", Configuration.CATEGORY_GENERAL, true, "enable/disable Update Checker");
		
		
		
		
		
		
		
		
		/** Configuration End **/
		config.save();
	}
}
