package mod.teaminfernal.augmentedinferno.blocks;

import java.util.Random;

import mod.teaminfernal.augmentedinferno.init.InfernalItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockOreInfernium extends BasicBlock{

	public BlockOreInfernium() {
		super("infernium_ore", Material.ROCK);
		this.setHardness(6.0f);
		this.setHarvestLevel("pickaxe", 3);
		this.setLightLevel(1.0f);
		this.setSoundType(SoundType.STONE);
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		if(new Random().nextInt(5) == 0 && !player.capabilities.isCreativeMode && !worldIn.isRemote) worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 3.5f, true);
		super.onBlockHarvested(worldIn, pos, state, player);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return InfernalItems.INFERNIUM_SHARD;
	}
}