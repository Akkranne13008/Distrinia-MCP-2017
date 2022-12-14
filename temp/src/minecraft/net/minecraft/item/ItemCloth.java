package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemCloth extends ItemBlock {

   private static final String __OBFID = "CL_00000075";


   public ItemCloth(Block p_i45358_1_) {
      super(p_i45358_1_);
      this.func_77656_e(0);
      this.func_77627_a(true);
   }

   public IIcon func_77617_a(int p_77617_1_) {
      return this.field_150939_a.func_149735_b(2, BlockColored.func_150032_b(p_77617_1_));
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_;
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      return super.func_77658_a() + "." + ItemDye.field_150923_a[BlockColored.func_150032_b(p_77667_1_.func_77960_j())];
   }
}
