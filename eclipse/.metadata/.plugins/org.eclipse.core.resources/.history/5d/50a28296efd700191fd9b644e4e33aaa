/*    */ package fr.telozia.login.polymia;
/*    */ 
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiTextField;
/*    */ 
/*    */ public class GuiPasswordField
/*    */   extends GuiTextField
/*    */ {
private boolean field_146213_1;
/*    */   public GuiPasswordField(FontRenderer par1FontRenderer, int par2, int par3, int par4, int par5)
/*    */   {
/* 12 */     super(par1FontRenderer, par2, par3, par4, par5);
/*    */   }
/*    */   
/*    */   public void drawTextBox()
/*    */   {
/* 17 */     if (func_146176_q())
/*    */     {
/* 19 */       if (func_146181_i())
/*    */       {
/* 21 */         drawRect(this.field_146209_f - 1, this.field_146210_g - 1, this.field_146209_f + this.field_146218_h + 1, this.field_146210_g + this.field_146219_i + 1, -6250336);
/* 22 */         drawRect(this.field_146209_f, this.field_146210_g, this.field_146209_f + this.field_146218_h, this.field_146210_g + this.field_146219_i, -16777216);
/*    */       }
/* 24 */       int var1 = this.field_146226_p ? this.field_146222_t : this.field_146221_u;
/* 25 */       int var2 = this.field_146224_r - this.field_146225_q;
/* 26 */       int var3 = this.field_146223_s - this.field_146225_q;
/* 27 */       String var4 = this.field_146211_a.trimStringToWidth(this.field_146216_j.substring(this.field_146225_q), func_146200_o());
/* 28 */       boolean var5 = (var2 >= 0) && (var2 <= var4.length());
/* 29 */       boolean var6 = (this.field_146213_1) && (this.field_146214_l / 6 % 2 == 0) && (var5);
/* 30 */       int var7 = this.field_146215_m ? this.field_146209_f + 4 : this.field_146209_f;
/* 31 */       int var8 = this.field_146215_m ? this.field_146210_g + (this.field_146219_i - 8) / 2 : this.field_146210_g;
/* 32 */       int var9 = var7;
/*    */       
/* 34 */       var4 = var4.replaceAll(".", "*");
/* 35 */       if (var3 > var4.length()) {
/* 36 */         var3 = var4.length();
/*    */       }
/* 38 */       if (var4.length() > 0)
/*    */       {
/* 40 */         String var10 = var5 ? var4.substring(0, var2) : var4;
/* 41 */         var9 = this.field_146211_a.drawStringWithShadow(var10, var7, var8, var1);
/*    */       }
/* 43 */       boolean var13 = (this.field_146224_r < this.field_146216_j.length()) || (this.field_146216_j.length() >= func_146208_g());
/* 44 */       int var11 = var9;
/* 45 */       if (!var5)
/*    */       {
/* 47 */         var11 = var2 > 0 ? var7 + this.field_146218_h : var7;
/*    */       }
/* 49 */       else if (var13)
/*    */       {
/* 51 */         var11 = var9 - 1;
/* 52 */         var9--;
/*    */       }
/* 54 */       if ((var4.length() > 0) && (var5) && (var2 < var4.length())) {
/* 55 */         this.field_146211_a.drawStringWithShadow(var4.substring(var2), var9, var8, var1);
/*    */       }
/* 57 */       if (var6) {
/* 58 */         if (var13) {
/* 59 */           Gui.drawRect(var11, var8 - 1, var11 + 1, var8 + 1 + this.field_146211_a.FONT_HEIGHT, -3092272);
/*    */         } else {
/* 61 */           this.field_146211_a.drawStringWithShadow("_", var11, var8, var1);
/*    */         }
/*    */       }
/* 64 */       if (var3 != var2)
/*    */       {
/* 66 */         int var12 = var7 + this.field_146211_a.getStringWidth(var4.substring(0, var3));
/* 67 */         func_146188_c(var11, var8 - 1, var12 - 1, var8 + 1 + this.field_146211_a.FONT_HEIGHT);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\menzo\Desktop\minecraft Nexodia.jar!\com\nexodia\authentification\GuiPasswordField.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */