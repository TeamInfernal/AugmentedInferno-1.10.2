package mod.teaminfernal.augmentedinferno.blocks;

import java.util.Random;

import mod.teaminfernal.augmentedinferno.util.WorldHelper;
import mod.teaminfernal.augmentedinferno.util.WorldHelper.TreeTypes;
import mod.teaminfernal.augmentedinferno.world.trees.TreeList;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BasicSapling extends BasicBlock implements IGrowable {

	public static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	
	private String name;
	
	public BasicSapling(String name) {
		super(name  + "_sapling", Material.PLANTS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, 0));
		this.name = name;
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		//TODO: check for biomes
		//TODO FIRST: implement other hell biomes
		if(worldIn.getBlockState(pos.down()).getBlock()  == Blocks.NETHERRACK || worldIn.getBlockState(pos.down()).getBlock() == Blocks.SOUL_SAND) return super.canPlaceBlockAt(worldIn, pos);
		return false;
	}
	
	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return true;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
		return null;
	}
	
	@Override
	public boolean isVisuallyOpaque() {
		return false;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(STAGE).intValue();
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STAGE });
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SAPLING_AABB;
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		if(worldIn.getBlockState(pos.down()).getBlock() == Blocks.NETHERRACK || worldIn.getBlockState(pos.down()).getBlock() == Blocks.SOUL_SAND) return true;
		return false;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return (double)worldIn.rand.nextFloat() < 0.45D;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		if (((Integer)state.getValue(STAGE)).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
		else
		{
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
			WorldHelper.generateTree(worldIn, pos, TreeList.get(this.name), TreeTypes.NORMAL);
		}
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return 0;
	}
	
	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 20;
	}

}
