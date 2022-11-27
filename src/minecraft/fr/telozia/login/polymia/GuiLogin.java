/*    */ package fr.telozia.login.polymia;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiMainMenu;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.util.StringTranslate;
/*    */ 
/*    */ public class GuiLogin
/*    */   extends GuiScreen
/*    */ {
/* 16 */   String screenTitle = "Connexion";
/*    */   GuiPasswordField field;
/*    */   private String label;
/*    */   private GuiButton btnLogin;



/*    */   public GuiLogin(Minecraft minecraft, String label)
/*    */   {
/* 23 */     this.mc = minecraft;
/* 24 */     this.label = label;


}
/*    */   
/*    */   
/*    */   public void initGui()
/*    */   {
/* 29 */     StringTranslate stringtranslate = StringTranslate.getInstance();
/* 30 */     this.screenTitle = stringtranslate.translateKey("Connexion");
/* 31 */     this.field = new GuiPasswordField(this.fontRendererObj, this.width / 2 - 100, this.height / 2 - 15, 200, 18);
/* 32 */     this.btnLogin = new GuiButton(16, this.width / 2 - 50, this.height / 2 + 15, 100, 20, stringtranslate.translateKey("Connexion"));
/* 33 */     this.btnLogin.enabled = false;
/* 34 */     this.buttonList.add(this.btnLogin);
/* 35 */     this.buttonList.add(new GuiButton(15, this.width / 2 - 50, this.height / 2 + 50, 100, 20, stringtranslate.translateKey("Se d�connecter")));
/* 36 */     this.field.setFocused(true);



}
/*    */   
/*    */   
/*    */   public void drawScreen(int i, int j, float f)
/*    */   {
/* 41 */     drawDefaultBackground();
/* 42 */     this.field.drawTextBox();
/* 43 */     this.fontRendererObj.drawString(this.label, this.width / 2 - 100, this.height / 2 - 35, 0);
/* 44 */     super.drawScreen(i, j, f);
/*    */   }
/*    */   
/*    */   public void keyTyped(char par1, int par2)
/*    */   {
/* 49 */     super.keyTyped(par1, par2);
/* 50 */     if (this.field.isFocused()) {
/* 51 */       this.field.textboxKeyTyped(par1, par2);
/*    */     }
/* 53 */     if (this.field.getText().isEmpty()) {
/* 54 */       this.btnLogin.enabled = false;
/*    */     }
/* 56 */     if (!this.field.getText().isEmpty()) {
/* 57 */       this.btnLogin.enabled = true;
/*    */     }
/* 59 */     if ((par2 == 28) && (!this.field.getText().isEmpty()))
/*    */     {
/* 61 */       this.mc.thePlayer.sendChatMessage("/login " + this.field.getText());
/* 62 */       this.mc.setIngameFocus();
/*    */     }
/*    */   }
/*    */   




/*    */   protected void actionPerformed(GuiButton guibutton)
/*    */   {
/* 68 */     if (!guibutton.enabled) {
/* 69 */       return;
/*    */     }
/* 71 */     switch (guibutton.id)
/*    */     {
/*    */     case 15: 
/* 74 */       this.mc.theWorld.sendQuittingDisconnectingPacket();
/* 75 */       this.mc.loadWorld(null);
/* 76 */       this.mc.displayGuiScreen(new GuiMainMenu());
/* 77 */       break;
/*    */     case 16: 
/* 79 */       if (!this.field.getText().isEmpty())
/*    */       {
/* 81 */         this.mc.thePlayer.sendChatMessage("/login " + this.field.getText());
/* 82 */         this.mc.setIngameFocus();
/*    */       }
/*    */       break;
/*    */     }
/*    */   }
/*    */ }