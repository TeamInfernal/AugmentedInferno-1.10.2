package mod.teaminfernal.augmentedinferno.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBasalt extends BasicBlock{

	public BlockBasalt() {
		super("basalt", Material.ROCK);
		this.setHardness(6.0f);
		this.setSoundType(SoundType.STONE);
	}
}
