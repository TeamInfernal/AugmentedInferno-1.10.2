package mod.teaminfernal.augmentedinferno.blocks;

import java.util.Iterator;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BasicLog extends BasicBlock//log class currently broken :(
{
	public static final PropertyEnum<Axis> AXIS = PropertyEnum.create("axis", EnumFacing.Axis.class);

	public BasicLog(String name)
	{
		super(name + "_log", Material.WOOD);
		setHarvestLevel("axe", 0);
		setHardness(2.0F);
		setResistance(5.0F);
		setSoundType(SoundType.WOOD);
		setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Y));
	}
	
	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return true;
	}
	
	public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, int metadata, EntityLivingBase entity)
	{
		return super.onBlockPlaced(world, pos, side, hitX, hitY, hitZ, metadata, entity).withProperty(AXIS, side.getAxis());
	}

	public IBlockState getStateFromMeta(int meta)
	{
		int axis = meta;
		return getDefaultState().withProperty(AXIS, EnumFacing.Axis.values()[axis]);
	}

	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(AXIS).ordinal();
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { AXIS });
	}

	public boolean canSustainLeaves(IBlockAccess world, BlockPos pos) { return true; } 
	public boolean isWood(IBlockAccess world, BlockPos pos) { return true; }


	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		byte b0 = 4;
		int i = b0 + 1;

		if (worldIn.isAreaLoaded(pos.add(-i, -i, -i), pos.add(i, i, i)))
		{
			Iterator<BlockPos> iterator = BlockPos.getAllInBox(pos.add(-b0, -b0, -b0), pos.add(b0, b0, b0)).iterator();

			while (iterator.hasNext())
			{
				BlockPos blockpos1 = iterator.next();
				IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);

				if (iblockstate1.getBlock().isLeaves(iblockstate1, worldIn, blockpos1))
				{
					iblockstate1.getBlock().beginLeavesDecay(iblockstate1, worldIn, blockpos1);
				}
			}
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
