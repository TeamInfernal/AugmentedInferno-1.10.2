package mod.teaminfernal.augmentedinferno.world.trees;

import mod.teaminfernal.augmentedinferno.util.ITreeMapping;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TreeDarkOak implements ITreeMapping {

	@Override
	public void placeLog(World world, BlockPos pos, EnumFacing.Axis axis) {
		BlockLog.EnumAxis newAxis =  BlockLog.EnumAxis.valueOf(axis.getName());
		world.setBlockState(pos, Blocks.LOG.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK).withProperty(BlockLog.LOG_AXIS, newAxis));
	}

	@Override
	public void placeLeaves(World world, BlockPos pos) {
		world.setBlockState(pos, Blocks.LEAVES.getDefaultState().withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.DARK_OAK).withProperty(BlockNewLeaf.DECAYABLE, true).withProperty(BlockNewLeaf.CHECK_DECAY, false));
	}

}
