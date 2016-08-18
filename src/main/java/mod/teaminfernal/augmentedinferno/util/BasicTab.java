package mod.teaminfernal.augmentedinferno.util;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BasicTab extends CreativeTabs {

	private Item icon;
	
	public BasicTab(String label, Item icon) {
		super(label);
		this.icon = icon;
	}
	
	public BasicTab(String label, Block icon) {
		super(label);
		this.icon = Item.getItemFromBlock(icon);
	}
	
	@Override
	public Item getTabIconItem() {
		return this.icon;
	}

}
