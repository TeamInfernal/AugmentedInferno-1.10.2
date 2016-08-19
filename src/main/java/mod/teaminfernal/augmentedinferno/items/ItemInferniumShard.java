package mod.teaminfernal.augmentedinferno.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemInferniumShard extends BasicItem {

	public ItemInferniumShard() {
		super("infernium_shard");
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(!entityIn.isWet())entityIn.setFire(5); else entityIn.attackEntityFrom(DamageSource.inFire, 0.5f);
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(TextFormatting.DARK_RED + "HOT!");
	}

}
