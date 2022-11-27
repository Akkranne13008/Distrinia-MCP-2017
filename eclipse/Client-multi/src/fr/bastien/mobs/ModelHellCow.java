// Date: 31/07/2019 23:15:28
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package fr.bastien.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHellCow extends ModelBase
{
  //fields
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer Shape1;
    ModelRenderer Shape3;
    ModelRenderer Shape8;
    ModelRenderer Shape22;
    ModelRenderer Shape455;
    ModelRenderer Shape255;
  
  public ModelHellCow()
  {
    textureWidth = 1007;
    textureHeight = 617;
    
      body = new ModelRenderer(this, 28, 8);
      body.addBox(-5F, -10F, -7F, 8, 16, 6);
      body.setRotationPoint(0F, 11F, 3F);
      body.setTextureSize(1007, 617);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(-2F, 0F, -2F, 2, 6, 2);
      leg1.setRotationPoint(-3F, 18F, 7F);
      leg1.setTextureSize(1007, 617);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 16);
      leg2.addBox(-2F, 0F, -2F, 2, 6, 2);
      leg2.setRotationPoint(3F, 18F, 7F);
      leg2.setTextureSize(1007, 617);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 16);
      leg3.addBox(-2F, 18F, -2F, 2, 6, 2);
      leg3.setRotationPoint(-3F, 0F, -5F);
      leg3.setTextureSize(1007, 617);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 16);
      leg4.addBox(-2F, 0F, -2F, 2, 6, 2);
      leg4.setRotationPoint(3F, 18F, -5F);
      leg4.setTextureSize(1007, 617);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 4, 4, 2);
      Shape1.setRotationPoint(-3F, 9F, 8F);
      Shape1.setTextureSize(1007, 617);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(0F, 0F, 0F, 4, 3, 6);
      Shape3.setRotationPoint(-3F, 8F, -10F);
      Shape3.setTextureSize(1007, 617);
      Shape3.mirror = true;
      setRotation(Shape3, -0.5585054F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 0);
      Shape8.addBox(0F, 0F, 0F, 6, 7, 4);
      Shape8.setRotationPoint(-4F, 6F, -13F);
      Shape8.setTextureSize(1007, 617);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape22 = new ModelRenderer(this, 0, 0);
      Shape22.addBox(0F, 0F, 0F, 6, 5, 6);
      Shape22.setRotationPoint(-4F, 7F, -18F);
      Shape22.setTextureSize(1007, 617);
      Shape22.mirror = true;
      setRotation(Shape22, 0F, 0F, 0F);
      Shape455 = new ModelRenderer(this, 0, 0);
      Shape455.addBox(0F, 0F, 0F, 2, 2, 1);
      Shape455.setRotationPoint(-5F, 5F, -10F);
      Shape455.setTextureSize(1007, 617);
      Shape455.mirror = true;
      setRotation(Shape455, 0F, 0F, 0F);
      Shape255 = new ModelRenderer(this, 0, 0);
      Shape255.addBox(0F, 0F, 0F, 2, 2, 1);
      Shape255.setRotationPoint(1F, 5F, -11F);
      Shape255.setTextureSize(1007, 617);
      Shape255.mirror = true;
      setRotation(Shape255, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    body.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    Shape1.render(f5);
    Shape3.render(f5);
    Shape8.render(f5);
    Shape22.render(f5);
    Shape455.render(f5);
    Shape255.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
