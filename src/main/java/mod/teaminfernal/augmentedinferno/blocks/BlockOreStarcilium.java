package mod.teaminfernal.augmentedinferno.blocks;

import java.util.Random;

import mod.teaminfernal.augmentedinferno.init.InfernalItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockOreStarcilium extends BasicBlock {

	public BlockOreStarcilium() {
		super("starcilium_ore", Material.ROCK);
		this.setHardness(6.0f);
		this.setHarvestLevel("pickaxe", 3);
		this.setSoundType(SoundType.STONE);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return InfernalItems.STARCILIUM;
	}
}

