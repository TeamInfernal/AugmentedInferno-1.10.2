package mod.teaminfernal.augmentedinferno.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockStorage extends BasicBlock {

	public BlockStorage(String name) {
		super(name + "_block", Material.IRON);
		this.setSoundType(SoundType.METAL);
	}
}
