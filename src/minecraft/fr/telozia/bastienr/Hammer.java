package fr.telozia.bastienr;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Hammer extends ItemTool{

    private static final Set field_150915_c = Sets.newHashSet(new Block[] {Blocks.cobblestone, Blocks.stone});
    private static final String __OBFID = "CL_00000053";

    public Hammer(Item.ToolMaterial p_i45347_1_)
    {
        super(2.0F, p_i45347_1_, field_150915_c);
    }

    public boolean func_150897_b(Block p_150897_1_)
    {
        return p_150897_1_ == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (p_150897_1_ != Blocks.diamond_block && p_150897_1_ != Blocks.diamond_ore ? (p_150897_1_ != Blocks.emerald_ore && p_150897_1_ != Blocks.emerald_block ? (p_150897_1_ != Blocks.gold_block && p_150897_1_ != Blocks.gold_ore ? (p_150897_1_ != Blocks.iron_block && p_150897_1_ != Blocks.iron_ore ? (p_150897_1_ != Blocks.lapis_block && p_150897_1_ != Blocks.lapis_ore ? (p_150897_1_ != Blocks.redstone_ore && p_150897_1_ != Blocks.lit_redstone_ore ? (p_150897_1_.getMaterial() == Material.rock ? true : (p_150897_1_.getMaterial() == Material.iron ? true : p_150897_1_.getMaterial() == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }

    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return p_150893_2_.getMaterial() != Material.iron && p_150893_2_.getMaterial() != Material.anvil && p_150893_2_.getMaterial() != Material.rock ? super.func_150893_a(p_150893_1_, p_150893_2_) : this.efficiencyOnProperMaterial;
    }
    
    
    
    public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
    	
    	return true;
    }
    
	  public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z,
	            EntityLivingBase living) {
	        if (living instanceof EntityPlayer && !world.isClient) {
	        	
	            switch (determineOrientation(world, x, y, z, living)) {
	            case 0:
	                for (int x1 = -1; x1 < 2; x1++) {
	                    for (int z1 = -1; z1 < 2; z1++) {
	                        if (world.getBlock(x + x1, y, z + z1).getBlockHardness(world, x1, y, z1) >= 0.0F) {
	                        	 if (world.getBlock(x + x1, y, z + z1) == Blocks.stone|| world.getBlock(x + x1, y, z + z1) == Blocks.cobblestone){
	                        		 world.getBlock(x + x1, y, z + z1).harvestBlock(world, (EntityPlayer) living, x + x1, y,
	                                    z + z1, world.getBlockMetadata(x + x1, y, z + z1));
	                        		 world.setBlockToAir(x + x1, y, z + z1);
	                        	}

	                        }
	                    }
	                }
	                break;
	            case 1:
	                for (int y1 = -1; y1 < 2; y1++) {
	                    for (int z1 = -1; z1 < 2; z1++) {
	                        if (world.getBlock(x, y + y1, z + z1).getBlockHardness(world, x, y1, z1) >= 0.0F) {
	                        	 if (world.getBlock(x, y + y1, z + z1) == Blocks.stone|| world.getBlock(x, y + y1, z + z1) == Blocks.cobblestone){
		                            world.getBlock(x, y + y1, z + z1).harvestBlock(world, (EntityPlayer) living, x, y + y1,
		                                    z + z1, world.getBlockMetadata(x, y + y1, z + z1));
		                            world.setBlockToAir(x, y + y1, z + z1);
	                        	 }

	                        }
	                    }
	                }
	                break;
	            case 2:
	                for (int x1 = -1; x1 < 2; x1++) {
	                    for (int y1 = -1; y1 < 2; y1++) {
	                        if (world.getBlock(x + x1, y + y1, z).getBlockHardness(world, x1, y1, z) >= 0.0F) {
	                        	if (world.getBlock(x + x1, y + y1, z) == Blocks.stone|| world.getBlock(x + x1, y + y1, z) == Blocks.cobblestone){
		                            world.getBlock(x + x1, y + y1, z).harvestBlock(world, (EntityPlayer) living, x + x1, y + y1,
		                                    z, world.getBlockMetadata(x + x1, y + y1, z));
		                            world.setBlockToAir(x + x1, y + y1, z);
	                        	}
	                        }
	                    }
	                }
	                break;
	            }
	        }
	        return super.onBlockDestroyed(stack, world, block, x, y, z, living);
	    }
	 
	    public int determineOrientation(World world, int x, int y, int z, EntityLivingBase living) {
	        if (MathHelper.abs((float) living.posX - x) < 2.0F && MathHelper.abs((float) living.posZ - z) < 2.0F) {
	            double d0 = living.posY + 1.82D - (double) living.yOffset;
	 
	            if (d0 - y > 2.0D || y - d0 > 0.0D) {
	                return 0;
	            }
	        }
	        float rotation = MathHelper.abs(living.rotationYaw);
	        return (rotation > 45F && rotation < 135F) || (rotation > 225F && rotation < 315F) ? 1 : 2;
	    }
    
}