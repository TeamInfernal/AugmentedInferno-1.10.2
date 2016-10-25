package mod.teaminfernal.augmentedinferno.world.trees;

import mod.teaminfernal.augmentedinferno.init.InfernalBlocks;
import mod.teaminfernal.augmentedinferno.util.ITreeMapping;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TreeBlood implements ITreeMapping {

	@Override
	public void placeLeaves(World world, BlockPos pos) {
		world.setBlockState(pos, InfernalBlocks.BLOOD_ROCK_ORE.getDefaultState());
	}

	@Override
	public void placeLog(World world, BlockPos pos, Axis axis) {
		world.setBlockState(pos, InfernalBlocks.BLOOD_ROCK_BLOCK.getDefaultState());
	}

}
