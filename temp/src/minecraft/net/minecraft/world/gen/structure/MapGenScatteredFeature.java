package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.ComponentScatteredFeaturePieces;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenScatteredFeature extends MapGenStructure {

   private static List field_75061_e = Arrays.asList(new BiomeGenBase[]{BiomeGenBase.field_76769_d, BiomeGenBase.field_76786_s, BiomeGenBase.field_76782_w, BiomeGenBase.field_76792_x, BiomeGenBase.field_76780_h});
   private List field_82668_f;
   private int field_82669_g;
   private int field_82670_h;
   private static final String __OBFID = "CL_00000471";


   public MapGenScatteredFeature() {
      this.field_82668_f = new ArrayList();
      this.field_82669_g = 32;
      this.field_82670_h = 8;
      this.field_82668_f.add(new BiomeGenBase.SpawnListEntry(EntityWitch.class, 1, 1, 1));
   }

   public MapGenScatteredFeature(Map p_i2061_1_) {
      this();
      Iterator var2 = p_i2061_1_.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((String)var3.getKey()).equals("distance")) {
            this.field_82669_g = MathHelper.func_82714_a((String)var3.getValue(), this.field_82669_g, this.field_82670_h + 1);
         }
      }

   }

   public String func_143025_a() {
      return "Temple";
   }

   protected boolean func_75047_a(int p_75047_1_, int p_75047_2_) {
      int var3 = p_75047_1_;
      int var4 = p_75047_2_;
      if(p_75047_1_ < 0) {
         p_75047_1_ -= this.field_82669_g - 1;
      }

      if(p_75047_2_ < 0) {
         p_75047_2_ -= this.field_82669_g - 1;
      }

      int var5 = p_75047_1_ / this.field_82669_g;
      int var6 = p_75047_2_ / this.field_82669_g;
      Random var7 = this.field_75039_c.func_72843_D(var5, var6, 14357617);
      var5 *= this.field_82669_g;
      var6 *= this.field_82669_g;
      var5 += var7.nextInt(this.field_82669_g - this.field_82670_h);
      var6 += var7.nextInt(this.field_82669_g - this.field_82670_h);
      if(var3 == var5 && var4 == var6) {
         BiomeGenBase var8 = this.field_75039_c.func_72959_q().func_76935_a(var3 * 16 + 8, var4 * 16 + 8);
         Iterator var9 = field_75061_e.iterator();

         while(var9.hasNext()) {
            BiomeGenBase var10 = (BiomeGenBase)var9.next();
            if(var8 == var10) {
               return true;
            }
         }
      }

      return false;
   }

   protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_) {
      return new MapGenScatteredFeature.Start(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_);
   }

   public boolean func_143030_a(int p_143030_1_, int p_143030_2_, int p_143030_3_) {
      StructureStart var4 = this.func_143028_c(p_143030_1_, p_143030_2_, p_143030_3_);
      if(var4 != null && var4 instanceof MapGenScatteredFeature.Start && !var4.field_75075_a.isEmpty()) {
         StructureComponent var5 = (StructureComponent)var4.field_75075_a.getFirst();
         return var5 instanceof ComponentScatteredFeaturePieces.SwampHut;
      } else {
         return false;
      }
   }

   public List func_82667_a() {
      return this.field_82668_f;
   }


   public static class Start extends StructureStart {

      private static final String __OBFID = "CL_00000472";


      public Start() {}

      public Start(World p_i2060_1_, Random p_i2060_2_, int p_i2060_3_, int p_i2060_4_) {
         super(p_i2060_3_, p_i2060_4_);
         BiomeGenBase var5 = p_i2060_1_.func_72807_a(p_i2060_3_ * 16 + 8, p_i2060_4_ * 16 + 8);
         if(var5 != BiomeGenBase.field_76782_w && var5 != BiomeGenBase.field_76792_x) {
            if(var5 == BiomeGenBase.field_76780_h) {
               ComponentScatteredFeaturePieces.SwampHut var7 = new ComponentScatteredFeaturePieces.SwampHut(p_i2060_2_, p_i2060_3_ * 16, p_i2060_4_ * 16);
               this.field_75075_a.add(var7);
            } else {
               ComponentScatteredFeaturePieces.DesertPyramid var8 = new ComponentScatteredFeaturePieces.DesertPyramid(p_i2060_2_, p_i2060_3_ * 16, p_i2060_4_ * 16);
               this.field_75075_a.add(var8);
            }
         } else {
            ComponentScatteredFeaturePieces.JunglePyramid var6 = new ComponentScatteredFeaturePieces.JunglePyramid(p_i2060_2_, p_i2060_3_ * 16, p_i2060_4_ * 16);
            this.field_75075_a.add(var6);
         }

         this.func_75072_c();
      }
   }
}
