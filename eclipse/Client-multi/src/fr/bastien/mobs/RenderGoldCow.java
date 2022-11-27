package fr.bastien.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderGoldCow extends RenderLiving {
   private static final ResourceLocation cowTextures = new ResourceLocation("textures/entity/cow/VacheUranium.png");
   protected ModelGoldCow model;

   public RenderGoldCow(ModelBase p_i1253_1_, float p_i1253_2_) {
      super(p_i1253_1_, p_i1253_2_);
      this.setRenderPassModel(new ModelGoldCow());
   }

   protected ResourceLocation getEntityTexture(EntityGoldCow p_110775_1_) {
      return cowTextures;
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
      return this.getEntityTexture((EntityGoldCow)p_110775_1_);
   }

   protected int shouldRenderPass(EntityLivingBase e, int p_77032_2_, float p_77032_3_) {
      if(e instanceof EntityGoldCow) {
         this.bindTexture(cowTextures);
         GL11.glColor3f(0.0F, 5.0F, 1.0F);
         return 31;
      } else {
         return -1;
      }
   }
}
