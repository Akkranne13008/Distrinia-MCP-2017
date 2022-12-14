package net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiFurnace extends GuiContainer {

   private static final ResourceLocation field_147087_u = new ResourceLocation("textures/gui/container/furnace.png");
   private TileEntityFurnace field_147086_v;
   private static final String __OBFID = "CL_00000758";


   public GuiFurnace(InventoryPlayer p_i1091_1_, TileEntityFurnace p_i1091_2_) {
      super(new ContainerFurnace(p_i1091_1_, p_i1091_2_));
      this.field_147086_v = p_i1091_2_;
   }

   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
      String var3 = this.field_147086_v.func_145818_k_()?this.field_147086_v.func_145825_b():I18n.func_135052_a(this.field_147086_v.func_145825_b(), new Object[0]);
      this.field_146289_q.func_78276_b(var3, this.field_146999_f / 2 - this.field_146289_q.func_78256_a(var3) / 2, 6, 4210752);
      this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory", new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
   }

   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_146297_k.func_110434_K().func_110577_a(field_147087_u);
      int var4 = (this.field_146294_l - this.field_146999_f) / 2;
      int var5 = (this.field_146295_m - this.field_147000_g) / 2;
      this.func_73729_b(var4, var5, 0, 0, this.field_146999_f, this.field_147000_g);
      if(this.field_147086_v.func_145950_i()) {
         int var6 = this.field_147086_v.func_145955_e(13);
         this.func_73729_b(var4 + 56, var5 + 36 + 12 - var6, 176, 12 - var6, 14, var6 + 1);
         var6 = this.field_147086_v.func_145953_d(24);
         this.func_73729_b(var4 + 79, var5 + 34, 176, 14, var6 + 1, 16);
      }

   }

}
