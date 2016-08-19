package mod.teaminfernal.augmentedinferno.world.trees;

import mod.teaminfernal.augmentedinferno.blocks.BasicLeaves;
import mod.teaminfernal.augmentedinferno.blocks.BasicLog;
import mod.teaminfernal.augmentedinferno.init.InfernalBlocks;
import mod.teaminfernal.augmentedinferno.util.ITreeMapping;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TreeHellbark implements ITreeMapping {

	@Override
	public void placeLog(World world, BlockPos pos, EnumFacing.Axis axis) {
		world.setBlockState(pos, InfernalBlocks.HELLBARK_LOG.getDefaultState().withProperty(BasicLog.AXIS, axis));
	}

	@Override
	public void placeLeaves(World world, BlockPos pos) {
		world.setBlockState(pos, InfernalBlocks.HELLBARK_LEAVES.getDefaultState().withProperty(BasicLeaves.CHECK_DECAY, false).withProperty(BasicLeaves.DECAYABLE, true));
	}

}
