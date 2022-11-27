package net.minecraft.client.gui.inventory;


import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import fr.telozia.bastienr.GuiQuest;
import fr.telozia.bastienr.GuiWiki;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;



public class GuiInventory extends InventoryEffectRenderer {
   private float field_147048_u;
   private float field_147047_v;
   private static final String __OBFID1 = "CL_00000761";
   private int decay;
   private int maxDecay;
   private boolean showArmorStats;
   private boolean statsSelected;
   private static final String __OBFID = "CL_00000761";

   public GuiInventory(EntityPlayer par1EntityPlayer) {
      super(par1EntityPlayer.inventoryContainer);
      this.field_146291_p = true;
   }

   public void updateScreen() {
      if(mc.playerController.isInCreativeMode()) {
         mc.displayGuiScreen(new GuiContainerCreative(mc.thePlayer));
      }

      if(this.field_147003_i > 0 && this.field_147003_i != this.maxDecay) {
         this.maxDecay = this.field_147003_i;
      }

      if(this.decay > 0 && this.showArmorStats) {
         this.decay -= this.maxDecay / 10;
      }

      if(this.decay < this.maxDecay && !this.showArmorStats) {
         this.decay += this.maxDecay / 10;
      }

      this.decay = this.decay < 0?0:(this.decay > this.maxDecay?this.maxDecay:this.decay);
   }

   public void initGui() {
      this.buttonList.clear();
      this.buttonList.clear();
      if(mc.theWorld.isClient) {
         if(!mc.thePlayer.getActivePotionEffects().isEmpty()) {
             this.buttonList.add(new GuiButton(4, this.width / 2 + 150, this.height / 2 - 40, 40, 20, "Wiki"));
             this.buttonList.add(new GuiButton(2, this.width / 2 + 150, this.height / 2 - 70, 40, 20, "Shop"));
             this.buttonList.add(new GuiButton(6, this.width / 2 + 150, this.height / 2 - 10, 40, 20, "HDV"));
             this.buttonList.add(new GuiButton(3, this.width / 2 + 150, this.height / 2  +20, 40, 20, "Macro"));

         } else {
            this.buttonList.add(new GuiButton(4, this.width / 2 + 90, this.height / 2 - 40, 40, 20, "Wiki"));

            this.buttonList.add(new GuiButton(2, this.width / 2 + 90, this.height / 2 - 70, 40, 20, "Shop"));
            this.buttonList.add(new GuiButton(6, this.width / 2 + 90, this.height / 2 - 10, 40, 20, "HDV"));
            this.buttonList.add(new GuiButton(3, this.width / 2 + 90, this.height / 2 + 20, 40, 20, "Macro"));


         }

      if(mc.playerController.isInCreativeMode()) {
         mc.displayGuiScreen(new GuiContainerCreative(mc.thePlayer));
      } else {
         super.initGui();
      }

      this.decay = this.maxDecay = this.field_147003_i;
      }
   }

   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
      this.fontRendererObj.drawString(I18n.format("container.crafting", new Object[0]), 86, 16, 4210752);
   }

   public void drawScreen(int par1, int par2, float par3) {
      super.drawScreen(par1, par2, par3);
      this.field_147048_u = (float)par1;
      this.field_147047_v = (float)par2;
   }

   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      mc.getTextureManager().bindTexture(field_147001_a);
      int var4 = this.field_147003_i;
      int var5 = this.field_147009_r;
      this.drawTexturedModalRect(var4, var5, 0, 0, this.field_146999_f, this.field_147000_g);
      func_147046_a(var4 + 51, var5 + 75, 30, (float)(var4 + 51) - this.field_147048_u, (float)(var5 + 75 - 50) - this.field_147047_v, mc.thePlayer);
   }

   public static void func_147046_a(int p_147046_0_, int p_147046_1_, int p_147046_2_, float p_147046_3_, float p_147046_4_, EntityLivingBase p_147046_5_) {
      GL11.glEnable(GL11.GL_COLOR_MATERIAL);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_147046_0_, (float)p_147046_1_, 50.0F);
      GL11.glScalef((float)(-p_147046_2_), (float)p_147046_2_, (float)p_147046_2_);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      float var6 = p_147046_5_.renderYawOffset;
      float var7 = p_147046_5_.rotationYaw;
      float var8 = p_147046_5_.rotationPitch;
      float var9 = p_147046_5_.prevRotationYawHead;
      float var10 = p_147046_5_.rotationYawHead;
      GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.enableStandardItemLighting();
      GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-((float)Math.atan((double)(p_147046_4_ / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
      p_147046_5_.renderYawOffset = (float)Math.atan((double)(p_147046_3_ / 40.0F)) * 20.0F;
      p_147046_5_.rotationYaw = (float)Math.atan((double)(p_147046_3_ / 40.0F)) * 40.0F;
      p_147046_5_.rotationPitch = -((float)Math.atan((double)(p_147046_4_ / 40.0F))) * 20.0F;
      p_147046_5_.rotationYawHead = p_147046_5_.rotationYaw;
      p_147046_5_.prevRotationYawHead = p_147046_5_.rotationYaw;
      GL11.glTranslatef(0.0F, p_147046_5_.yOffset, 0.0F);
      RenderManager.instance.playerViewY = 180.0F;
      RenderManager.instance.func_147940_a(p_147046_5_, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
      p_147046_5_.renderYawOffset = var6;
      p_147046_5_.rotationYaw = var7;
      p_147046_5_.rotationPitch = var8;
      p_147046_5_.prevRotationYawHead = var9;
      p_147046_5_.rotationYawHead = var10;
      GL11.glPopMatrix();
      RenderHelper.disableStandardItemLighting();
      GL11.glDisable(GL12.GL_RESCALE_NORMAL);
      OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GL11.glDisable(GL11.GL_TEXTURE_2D);
      OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }

   public void handleMouseInput() {
      int x = Mouse.getEventX() * this.width / mc.displayWidth;
      int y = this.height - Mouse.getEventY() * this.height / mc.displayHeight - 1;
      this.statsSelected = false;
      if(x >= this.decay && x <= 20 + this.decay && y >= this.field_147009_r - 10 && y <= this.field_147009_r + 1) {
         this.statsSelected = true;
      }

      super.handleMouseInput();
   }

   public void mouseClicked(int x, int y, int k) {
      if(this.statsSelected) {
         this.showArmorStats = !this.showArmorStats;
      }

      super.mouseClicked(x, y, k);
   }

   protected void actionPerformed(GuiButton p_146284_1_) {
      if(p_146284_1_.id == 8) {

      }

      if(p_146284_1_.id == 1) {
         mc.displayGuiScreen(new GuiStats(this, mc.thePlayer.func_146107_m()));
      }
      if(p_146284_1_.id == 6) {
    	  mc.displayGuiScreen(new GuiQuest());
       }
      if(p_146284_1_.id == 4) {
          mc.displayGuiScreen(new GuiWiki(mc.thePlayer));
       }


   }
  
  }

