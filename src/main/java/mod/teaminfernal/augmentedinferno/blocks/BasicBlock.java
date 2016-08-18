package mod.teaminfernal.augmentedinferno.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BasicBlock extends Block {

	public BasicBlock(String name, Material material) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		//this.setCreativeTab(tab);
		this.setSoundType(SoundType.GROUND);
	}
	
	public BasicBlock(String name) {
		this(name, Material.ROCK);
	}
}
