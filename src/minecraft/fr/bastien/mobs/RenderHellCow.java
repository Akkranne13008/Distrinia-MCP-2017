package fr.bastien.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHellCow extends RenderLiving {
   private static final ResourceLocation cowTextures = new ResourceLocation("textures/entity/chevre/Chevre.png");
   protected ModelHellCow model;

   public RenderHellCow(ModelBase p_i1253_1_, float p_i1253_2_) {
      super(p_i1253_1_, p_i1253_2_);
      this.setRenderPassModel(new ModelHellCow());
   }

   protected ResourceLocation getEntityTexture(EntityHellCow p_110775_1_) {
      return cowTextures;
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
      return this.getEntityTexture((EntityHellCow)p_110775_1_);
   }
}
