package mod.teaminfernal.augmentedinferno.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldHelper {

	/** 
	 * find a grass or dirt block to place the bush on
	 * original method from sky_01, see http://www.minecraftforum.net/forums/mapping-and-modding/mapping-and-modding-tutorials/2666351
	 * 
	 * modified by UpcraftLP.
	 * 
	 * @param world
	 * @param x
	 * @param z
	 * @return the y-value at ground level
	 */
	public static int getGroundFromAbove(World world, int x, int z, List<Block> soil)
	{
		int y = 255;
		boolean foundGround = false;
			while(!foundGround && y-- >= 0)
		{
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = soil.contains(blockAt);
		}

		return y;
	}
	
	/** 
	 * find a grass or dirt block to place the bush on
	 * original method from sky_01, see http://www.minecraftforum.net/forums/mapping-and-modding/mapping-and-modding-tutorials/2666351
	 * 
	 * modified by UpcraftLP.
	 * 
	 * @param world
	 * @param pos
	 * @return the y-value at ground level
	 */
	public static int getGroundFromAbove(World world, BlockPos pos, List<Block> soil) {
		return getGroundFromAbove(world, pos.getX(), pos.getZ(), soil);
	}
	
	/**
	 * A helper method for generating randomized trees in different shapes
	 * 
	 * @param world
	 * @param startPos
	 * @param log
	 * @param leaves
	 * @param treeType
	 */
	public static void generateTree(World world, BlockPos startPos, ITreeMapping tree, TreeTypes treeType)
	{
		//TODO: Trees!
		Random random = new Random();
		List<BlockPos> logsY = new ArrayList<BlockPos>();
		List<BlockPos> leaves = new ArrayList<BlockPos>();
		switch(treeType) {
		
		case NORMAL:
			if(random.nextInt(20) == 0) {
				generateTree(world, startPos, tree, TreeTypes.LARGE);
				break;
			}
			logsY.add(startPos);
			logsY.add(startPos.up());
			logsY.add(startPos.up(2));
			logsY.add(startPos.up(3));
			logsY.add(startPos.up(4));
			if(random.nextBoolean()) {
				logsY.add(startPos.up(5));
				startPos = startPos.up(5);
			}
			else
			{
				startPos = startPos.up(4);
			}
			for(int k = 0; k < 2; k++) {
				for(int i = -1; i < 2; i++)  {
					for(int j = -2; j < 3; j++) {
						leaves.add(new BlockPos(startPos.getX() + i, startPos.getY() - k, startPos.getZ() + j));
					}
					leaves.add(new BlockPos(startPos.getX() - 2, startPos.getY() - k, startPos.getZ() + 1));
					leaves.add(new BlockPos(startPos.getX() - 2, startPos.getY() - k, startPos.getZ()));
					leaves.add(new BlockPos(startPos.getX() - 2, startPos.getY() - k, startPos.getZ() - 1));
					leaves.add(new BlockPos(startPos.getX() + 2, startPos.getY() - k, startPos.getZ() + 1));
					leaves.add(new BlockPos(startPos.getX() + 2, startPos.getY() - k, startPos.getZ()));
					leaves.add(new BlockPos(startPos.getX() + 2, startPos.getY() - k, startPos.getZ() - 1));
					if(random.nextBoolean()) leaves.add(new BlockPos(startPos.getX() - 2, startPos.getY() - k, startPos.getZ() + 2));
					if(random.nextBoolean()) leaves.add(new BlockPos(startPos.getX() - 2, startPos.getY() - k, startPos.getZ() - 2));
					if(random.nextBoolean()) leaves.add(new BlockPos(startPos.getX() + 2, startPos.getY() - k, startPos.getZ() + 2));
					if(random.nextBoolean()) leaves.add(new BlockPos(startPos.getX() + 2, startPos.getY() - k, startPos.getZ() - 2));
				}
			}
			startPos = startPos.up();
			leaves.add(startPos);
			leaves.add(startPos.up());
			leaves.add(startPos.offset(EnumFacing.NORTH));
			leaves.add(startPos.offset(EnumFacing.NORTH).up());
			leaves.add(startPos.offset(EnumFacing.EAST));
			leaves.add(startPos.offset(EnumFacing.EAST).up());
			leaves.add(startPos.offset(EnumFacing.SOUTH));
			leaves.add(startPos.offset(EnumFacing.SOUTH).up());
			leaves.add(startPos.offset(EnumFacing.WEST));
			leaves.add(startPos.offset(EnumFacing.WEST).up());
			if(random.nextInt(2) == 0) leaves.add(startPos.offset(EnumFacing.NORTH).offset(EnumFacing.EAST));
			if(random.nextInt(2) == 0) leaves.add(startPos.offset(EnumFacing.NORTH).offset(EnumFacing.WEST));
			if(random.nextInt(2) == 0) leaves.add(startPos.offset(EnumFacing.SOUTH).offset(EnumFacing.EAST));
			if(random.nextInt(2) == 0) leaves.add(startPos.offset(EnumFacing.SOUTH).offset(EnumFacing.EAST));
			 
			break;
		
		case LARGE:
			break;
			
		case PALM:
			break;
			
		case BUSH:
			break;
			
		case BIG:
			break;
			
		case EXTRA_BIG:
			break;
			
		case HOUSE:
			break;
			
		default:
			break;
		
		}
		
		for (BlockPos blockPos : logsY) {
			tree.placeLog(world, blockPos, Axis.Y);
		}
		for (BlockPos blockPos : leaves) {
			if(world.getBlockState(blockPos).getBlock().isReplaceable(world, blockPos)) tree.placeLeaves(world, blockPos);
		}
	}
	
	public enum TreeTypes {
		NORMAL,
		LARGE,
		PALM,
		BUSH,
		BIG,
		EXTRA_BIG,
		HOUSE;
	}
	
}
