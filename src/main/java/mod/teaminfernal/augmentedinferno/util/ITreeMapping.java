package mod.teaminfernal.augmentedinferno.util;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ITreeMapping {

	
	public void placeLeaves(World world, BlockPos pos);

	void placeLog(World world, BlockPos pos, EnumFacing.Axis axis);
}
