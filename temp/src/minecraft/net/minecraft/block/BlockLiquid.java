package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockLiquid extends Block {

   private IIcon[] field_149806_a;
   private static final String __OBFID = "CL_00000265";


   protected BlockLiquid(Material p_i45413_1_) {
      super(p_i45413_1_);
      float var2 = 0.0F;
      float var3 = 0.0F;
      this.func_149676_a(0.0F + var3, 0.0F + var2, 0.0F + var3, 1.0F + var3, 1.0F + var2, 1.0F + var3);
      this.func_149675_a(true);
   }

   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
      return this.field_149764_J != Material.field_151587_i;
   }

   public int func_149635_D() {
      return 16777215;
   }

   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
      if(this.field_149764_J != Material.field_151586_h) {
         return 16777215;
      } else {
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;

         for(int var8 = -1; var8 <= 1; ++var8) {
            for(int var9 = -1; var9 <= 1; ++var9) {
               int var10 = p_149720_1_.func_72807_a(p_149720_2_ + var9, p_149720_4_ + var8).field_76759_H;
               var5 += (var10 & 16711680) >> 16;
               var6 += (var10 & '\uff00') >> 8;
               var7 += var10 & 255;
            }
         }

         return (var5 / 9 & 255) << 16 | (var6 / 9 & 255) << 8 | var7 / 9 & 255;
      }
   }

   public static float func_149801_b(int p_149801_0_) {
      if(p_149801_0_ >= 8) {
         p_149801_0_ = 0;
      }

      return (float)(p_149801_0_ + 1) / 9.0F;
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return p_149691_1_ != 0 && p_149691_1_ != 1?this.field_149806_a[1]:this.field_149806_a[0];
   }

   protected int func_149804_e(World p_149804_1_, int p_149804_2_, int p_149804_3_, int p_149804_4_) {
      return p_149804_1_.func_147439_a(p_149804_2_, p_149804_3_, p_149804_4_).func_149688_o() == this.field_149764_J?p_149804_1_.func_72805_g(p_149804_2_, p_149804_3_, p_149804_4_):-1;
   }

   protected int func_149798_e(IBlockAccess p_149798_1_, int p_149798_2_, int p_149798_3_, int p_149798_4_) {
      if(p_149798_1_.func_147439_a(p_149798_2_, p_149798_3_, p_149798_4_).func_149688_o() != this.field_149764_J) {
         return -1;
      } else {
         int var5 = p_149798_1_.func_72805_g(p_149798_2_, p_149798_3_, p_149798_4_);
         if(var5 >= 8) {
            var5 = 0;
         }

         return var5;
      }
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149678_a(int p_149678_1_, boolean p_149678_2_) {
      return p_149678_2_ && p_149678_1_ == 0;
   }

   public boolean func_149747_d(IBlockAccess p_149747_1_, int p_149747_2_, int p_149747_3_, int p_149747_4_, int p_149747_5_) {
      Material var6 = p_149747_1_.func_147439_a(p_149747_2_, p_149747_3_, p_149747_4_).func_149688_o();
      return var6 == this.field_149764_J?false:(p_149747_5_ == 1?true:(var6 == Material.field_151588_w?false:super.func_149747_d(p_149747_1_, p_149747_2_, p_149747_3_, p_149747_4_, p_149747_5_)));
   }

   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
      Material var6 = p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_).func_149688_o();
      return var6 == this.field_149764_J?false:(p_149646_5_ == 1?true:super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_));
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      return null;
   }

   public int func_149645_b() {
      return 4;
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return null;
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   private Vec3 func_149800_f(IBlockAccess p_149800_1_, int p_149800_2_, int p_149800_3_, int p_149800_4_) {
      Vec3 var5 = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
      int var6 = this.func_149798_e(p_149800_1_, p_149800_2_, p_149800_3_, p_149800_4_);

      for(int var7 = 0; var7 < 4; ++var7) {
         int var8 = p_149800_2_;
         int var10 = p_149800_4_;
         if(var7 == 0) {
            var8 = p_149800_2_ - 1;
         }

         if(var7 == 1) {
            var10 = p_149800_4_ - 1;
         }

         if(var7 == 2) {
            ++var8;
         }

         if(var7 == 3) {
            ++var10;
         }

         int var11 = this.func_149798_e(p_149800_1_, var8, p_149800_3_, var10);
         int var12;
         if(var11 < 0) {
            if(!p_149800_1_.func_147439_a(var8, p_149800_3_, var10).func_149688_o().func_76230_c()) {
               var11 = this.func_149798_e(p_149800_1_, var8, p_149800_3_ - 1, var10);
               if(var11 >= 0) {
                  var12 = var11 - (var6 - 8);
                  var5 = var5.func_72441_c((double)((var8 - p_149800_2_) * var12), (double)((p_149800_3_ - p_149800_3_) * var12), (double)((var10 - p_149800_4_) * var12));
               }
            }
         } else if(var11 >= 0) {
            var12 = var11 - var6;
            var5 = var5.func_72441_c((double)((var8 - p_149800_2_) * var12), (double)((p_149800_3_ - p_149800_3_) * var12), (double)((var10 - p_149800_4_) * var12));
         }
      }

      if(p_149800_1_.func_72805_g(p_149800_2_, p_149800_3_, p_149800_4_) >= 8) {
         boolean var13 = false;
         if(var13 || this.func_149747_d(p_149800_1_, p_149800_2_, p_149800_3_, p_149800_4_ - 1, 2)) {
            var13 = true;
         }

         if(var13 || this.func_149747_d(p_149800_1_, p_149800_2_, p_149800_3_, p_149800_4_ + 1, 3)) {
            var13 = true;
         }

         if(var13 || this.func_149747_d(p_149800_1_, p_149800_2_ - 1, p_149800_3_, p_149800_4_, 4)) {
            var13 = true;
         }

         if(var13 || this.func_149747_d(p_149800_1_, p_149800_2_ + 1, p_149800_3_, p_149800_4_, 5)) {
            var13 = true;
         }

         if(var13 || this.func_149747_d(p_149800_1_, p_149800_2_, p_149800_3_ + 1, p_149800_4_ - 1, 2)) {
            var13 = true;
         }

         if(var13 || this.func_149747_d(p_149800_1_, p_149800_2_, p_149800_3_ + 1, p_149800_4_ + 1, 3)) {
            var13 = true;
         }

         if(var13 || this.func_149747_d(p_149800_1_, p_149800_2_ - 1, p_149800_3_ + 1, p_149800_4_, 4)) {
            var13 = true;
         }

         if(var13 || this.func_149747_d(p_149800_1_, p_149800_2_ + 1, p_149800_3_ + 1, p_149800_4_, 5)) {
            var13 = true;
         }

         if(var13) {
            var5 = var5.func_72432_b().func_72441_c(0.0D, -6.0D, 0.0D);
         }
      }

      var5 = var5.func_72432_b();
      return var5;
   }

   public void func_149640_a(World p_149640_1_, int p_149640_2_, int p_149640_3_, int p_149640_4_, Entity p_149640_5_, Vec3 p_149640_6_) {
      Vec3 var7 = this.func_149800_f(p_149640_1_, p_149640_2_, p_149640_3_, p_149640_4_);
      p_149640_6_.field_72450_a += var7.field_72450_a;
      p_149640_6_.field_72448_b += var7.field_72448_b;
      p_149640_6_.field_72449_c += var7.field_72449_c;
   }

   public int func_149738_a(World p_149738_1_) {
      return this.field_149764_J == Material.field_151586_h?5:(this.field_149764_J == Material.field_151587_i?(p_149738_1_.field_73011_w.field_76576_e?10:30):0);
   }

   public int func_149677_c(IBlockAccess p_149677_1_, int p_149677_2_, int p_149677_3_, int p_149677_4_) {
      int var5 = p_149677_1_.func_72802_i(p_149677_2_, p_149677_3_, p_149677_4_, 0);
      int var6 = p_149677_1_.func_72802_i(p_149677_2_, p_149677_3_ + 1, p_149677_4_, 0);
      int var7 = var5 & 255;
      int var8 = var6 & 255;
      int var9 = var5 >> 16 & 255;
      int var10 = var6 >> 16 & 255;
      return (var7 > var8?var7:var8) | (var9 > var10?var9:var10) << 16;
   }

   public int func_149701_w() {
      return this.field_149764_J == Material.field_151586_h?1:0;
   }

   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
      int var6;
      if(this.field_149764_J == Material.field_151586_h) {
         if(p_149734_5_.nextInt(10) == 0) {
            var6 = p_149734_1_.func_72805_g(p_149734_2_, p_149734_3_, p_149734_4_);
            if(var6 <= 0 || var6 >= 8) {
               p_149734_1_.func_72869_a("suspended", (double)((float)p_149734_2_ + p_149734_5_.nextFloat()), (double)((float)p_149734_3_ + p_149734_5_.nextFloat()), (double)((float)p_149734_4_ + p_149734_5_.nextFloat()), 0.0D, 0.0D, 0.0D);
            }
         }

         for(var6 = 0; var6 < 0; ++var6) {
            int var7 = p_149734_5_.nextInt(4);
            int var8 = p_149734_2_;
            int var9 = p_149734_4_;
            if(var7 == 0) {
               var8 = p_149734_2_ - 1;
            }

            if(var7 == 1) {
               ++var8;
            }

            if(var7 == 2) {
               var9 = p_149734_4_ - 1;
            }

            if(var7 == 3) {
               ++var9;
            }

            if(p_149734_1_.func_147439_a(var8, p_149734_3_, var9).func_149688_o() == Material.field_151579_a && (p_149734_1_.func_147439_a(var8, p_149734_3_ - 1, var9).func_149688_o().func_76230_c() || p_149734_1_.func_147439_a(var8, p_149734_3_ - 1, var9).func_149688_o().func_76224_d())) {
               float var10 = 0.0625F;
               double var11 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
               double var13 = (double)((float)p_149734_3_ + p_149734_5_.nextFloat());
               double var15 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
               if(var7 == 0) {
                  var11 = (double)((float)p_149734_2_ - var10);
               }

               if(var7 == 1) {
                  var11 = (double)((float)(p_149734_2_ + 1) + var10);
               }

               if(var7 == 2) {
                  var15 = (double)((float)p_149734_4_ - var10);
               }

               if(var7 == 3) {
                  var15 = (double)((float)(p_149734_4_ + 1) + var10);
               }

               double var17 = 0.0D;
               double var19 = 0.0D;
               if(var7 == 0) {
                  var17 = (double)(-var10);
               }

               if(var7 == 1) {
                  var17 = (double)var10;
               }

               if(var7 == 2) {
                  var19 = (double)(-var10);
               }

               if(var7 == 3) {
                  var19 = (double)var10;
               }

               p_149734_1_.func_72869_a("splash", var11, var13, var15, var17, 0.0D, var19);
            }
         }
      }

      if(this.field_149764_J == Material.field_151586_h && p_149734_5_.nextInt(64) == 0) {
         var6 = p_149734_1_.func_72805_g(p_149734_2_, p_149734_3_, p_149734_4_);
         if(var6 > 0 && var6 < 8) {
            p_149734_1_.func_72980_b((double)((float)p_149734_2_ + 0.5F), (double)((float)p_149734_3_ + 0.5F), (double)((float)p_149734_4_ + 0.5F), "liquid.water", p_149734_5_.nextFloat() * 0.25F + 0.75F, p_149734_5_.nextFloat() * 1.0F + 0.5F, false);
         }
      }

      double var21;
      double var22;
      double var23;
      if(this.field_149764_J == Material.field_151587_i && p_149734_1_.func_147439_a(p_149734_2_, p_149734_3_ + 1, p_149734_4_).func_149688_o() == Material.field_151579_a && !p_149734_1_.func_147439_a(p_149734_2_, p_149734_3_ + 1, p_149734_4_).func_149662_c()) {
         if(p_149734_5_.nextInt(100) == 0) {
            var21 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
            var22 = (double)p_149734_3_ + this.field_149756_F;
            var23 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
            p_149734_1_.func_72869_a("lava", var21, var22, var23, 0.0D, 0.0D, 0.0D);
            p_149734_1_.func_72980_b(var21, var22, var23, "liquid.lavapop", 0.2F + p_149734_5_.nextFloat() * 0.2F, 0.9F + p_149734_5_.nextFloat() * 0.15F, false);
         }

         if(p_149734_5_.nextInt(200) == 0) {
            p_149734_1_.func_72980_b((double)p_149734_2_, (double)p_149734_3_, (double)p_149734_4_, "liquid.lava", 0.2F + p_149734_5_.nextFloat() * 0.2F, 0.9F + p_149734_5_.nextFloat() * 0.15F, false);
         }
      }

      if(p_149734_5_.nextInt(10) == 0 && World.func_147466_a(p_149734_1_, p_149734_2_, p_149734_3_ - 1, p_149734_4_) && !p_149734_1_.func_147439_a(p_149734_2_, p_149734_3_ - 2, p_149734_4_).func_149688_o().func_76230_c()) {
         var21 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
         var22 = (double)p_149734_3_ - 1.05D;
         var23 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
         if(this.field_149764_J == Material.field_151586_h) {
            p_149734_1_.func_72869_a("dripWater", var21, var22, var23, 0.0D, 0.0D, 0.0D);
         } else {
            p_149734_1_.func_72869_a("dripLava", var21, var22, var23, 0.0D, 0.0D, 0.0D);
         }
      }

   }

   public static double func_149802_a(IBlockAccess p_149802_0_, int p_149802_1_, int p_149802_2_, int p_149802_3_, Material p_149802_4_) {
      Vec3 var5 = null;
      if(p_149802_4_ == Material.field_151586_h) {
         var5 = Blocks.field_150358_i.func_149800_f(p_149802_0_, p_149802_1_, p_149802_2_, p_149802_3_);
      }

      if(p_149802_4_ == Material.field_151587_i) {
         var5 = Blocks.field_150356_k.func_149800_f(p_149802_0_, p_149802_1_, p_149802_2_, p_149802_3_);
      }

      return var5.field_72450_a == 0.0D && var5.field_72449_c == 0.0D?-1000.0D:Math.atan2(var5.field_72449_c, var5.field_72450_a) - 1.5707963267948966D;
   }

   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
      this.func_149805_n(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      this.func_149805_n(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
   }

   private void func_149805_n(World p_149805_1_, int p_149805_2_, int p_149805_3_, int p_149805_4_) {
      if(p_149805_1_.func_147439_a(p_149805_2_, p_149805_3_, p_149805_4_) == this) {
         if(this.field_149764_J == Material.field_151587_i) {
            boolean var5 = false;
            if(var5 || p_149805_1_.func_147439_a(p_149805_2_, p_149805_3_, p_149805_4_ - 1).func_149688_o() == Material.field_151586_h) {
               var5 = true;
            }

            if(var5 || p_149805_1_.func_147439_a(p_149805_2_, p_149805_3_, p_149805_4_ + 1).func_149688_o() == Material.field_151586_h) {
               var5 = true;
            }

            if(var5 || p_149805_1_.func_147439_a(p_149805_2_ - 1, p_149805_3_, p_149805_4_).func_149688_o() == Material.field_151586_h) {
               var5 = true;
            }

            if(var5 || p_149805_1_.func_147439_a(p_149805_2_ + 1, p_149805_3_, p_149805_4_).func_149688_o() == Material.field_151586_h) {
               var5 = true;
            }

            if(var5 || p_149805_1_.func_147439_a(p_149805_2_, p_149805_3_ + 1, p_149805_4_).func_149688_o() == Material.field_151586_h) {
               var5 = true;
            }

            if(var5) {
               int var6 = p_149805_1_.func_72805_g(p_149805_2_, p_149805_3_, p_149805_4_);
               if(var6 == 0) {
                  p_149805_1_.func_147449_b(p_149805_2_, p_149805_3_, p_149805_4_, Blocks.field_150343_Z);
               } else if(var6 <= 4) {
                  p_149805_1_.func_147449_b(p_149805_2_, p_149805_3_, p_149805_4_, Blocks.field_150347_e);
               }

               this.func_149799_m(p_149805_1_, p_149805_2_, p_149805_3_, p_149805_4_);
            }
         }

      }
   }

   protected void func_149799_m(World p_149799_1_, int p_149799_2_, int p_149799_3_, int p_149799_4_) {
      p_149799_1_.func_72908_a((double)((float)p_149799_2_ + 0.5F), (double)((float)p_149799_3_ + 0.5F), (double)((float)p_149799_4_ + 0.5F), "random.fizz", 0.5F, 2.6F + (p_149799_1_.field_73012_v.nextFloat() - p_149799_1_.field_73012_v.nextFloat()) * 0.8F);

      for(int var5 = 0; var5 < 8; ++var5) {
         p_149799_1_.func_72869_a("largesmoke", (double)p_149799_2_ + Math.random(), (double)p_149799_3_ + 1.2D, (double)p_149799_4_ + Math.random(), 0.0D, 0.0D, 0.0D);
      }

   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      if(this.field_149764_J == Material.field_151587_i) {
         this.field_149806_a = new IIcon[]{p_149651_1_.func_94245_a("lava_still"), p_149651_1_.func_94245_a("lava_flow")};
      } else {
         this.field_149806_a = new IIcon[]{p_149651_1_.func_94245_a("water_still"), p_149651_1_.func_94245_a("water_flow")};
      }

   }

   public static IIcon func_149803_e(String p_149803_0_) {
      return p_149803_0_ == "water_still"?Blocks.field_150358_i.field_149806_a[0]:(p_149803_0_ == "water_flow"?Blocks.field_150358_i.field_149806_a[1]:(p_149803_0_ == "lava_still"?Blocks.field_150356_k.field_149806_a[0]:(p_149803_0_ == "lava_flow"?Blocks.field_150356_k.field_149806_a[1]:null)));
   }
}
