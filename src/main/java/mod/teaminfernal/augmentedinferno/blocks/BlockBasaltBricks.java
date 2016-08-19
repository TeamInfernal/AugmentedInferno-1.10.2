package mod.teaminfernal.augmentedinferno.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBasaltBricks extends BasicBlock {

	public BlockBasaltBricks() {
		super("basalt_bricks", Material.ROCK);
		this.setLightLevel(9.0f);
		this.setSoundType(SoundType.STONE);
	}

}
