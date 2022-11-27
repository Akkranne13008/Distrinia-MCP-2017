/*     */ package fr.telozia.login.polymia;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiMainMenu;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.util.StringTranslate;
/*     */ 
/*     */ public class GuiRegister
/*     */   extends GuiScreen
/*     */ {
/*  16 */   String screenTitle = "S'inscrire";
/*     */   GuiPasswordField field;
/*     */   GuiPasswordField field2;
/*     */   private String label;
/*     */   private GuiButton btnRegister;
			
/*     */   
/*     */   public GuiRegister(Minecraft minecraft, String label)
/*     */   {
/*  24 */     this.mc = minecraft;
/*  25 */     this.label = label;
/*     */   }
/*     */   
/*     */   public void initGui()
/*     */   {
/*  30 */     StringTranslate stringtranslate = StringTranslate.getInstance();
/*  31 */     this.screenTitle = stringtranslate.translateKey("S'inscrire");
/*  32 */     this.field = new GuiPasswordField(this.fontRendererObj, this.width / 2 - 100, this.height / 2 - 25, 200, 18);
/*  33 */     this.field2 = new GuiPasswordField(this.fontRendererObj, this.width / 2 - 100, this.height / 2 + 10, 200, 18);
/*  34 */     this.btnRegister = new GuiButton(16, this.width / 2 - 100, this.height / 2 + 40, 95, 20, stringtranslate.translateKey("S'inscrire"));
/*  35 */     this.btnRegister.enabled = false;
/*  36 */     this.buttonList.add(this.btnRegister);
/*  37 */     this.buttonList.add(new GuiButton(15, this.width / 2 + 5, this.height / 2 + 40, 95, 20, stringtranslate.translateKey("Se d�connecter")));
/*  38 */     this.field.setFocused(true);
/*     */   }
/*     */   
/*     */   public void drawScreen(int i, int j, float f)
/*     */   {
/*  43 */     drawDefaultBackground();
/*  44 */     this.field.drawTextBox();
/*  45 */     this.field2.drawTextBox();
/*  46 */     this.fontRendererObj.drawString(this.label, this.width / 2 - 100, this.height / 2 - 55, 0);
/*  47 */     this.fontRendererObj.drawString("�fMot de passe:", this.width / 2 - 100, this.height / 2 - 35, 0);
/*  48 */     this.fontRendererObj.drawString("�fConfirmer:", this.width / 2 - 100, this.height / 2, 0);
/*  49 */     super.drawScreen(i, j, f);
/*     */   }
/*     */   
/*     */   public void keyTyped(char par1, int par2)
/*     */   {
/*  54 */     super.keyTyped(par1, par2);
/*  55 */     if (this.field.isFocused()) {
/*  56 */       this.field.textboxKeyTyped(par1, par2);
/*  57 */     } else if (this.field2.isFocused()) {
/*  58 */       this.field2.textboxKeyTyped(par1, par2);
/*     */     }
/*  60 */     if ((this.field.getText().isEmpty()) || (this.field2.getText().isEmpty())) {
/*  61 */       this.btnRegister.enabled = false;
/*     */     }
/*  63 */     if ((!this.field.getText().isEmpty()) && (!this.field2.getText().isEmpty())) {
/*  64 */       this.btnRegister.enabled = true;
/*     */     }
/*  66 */     if ((par2 == 28) && (!this.field.getText().isEmpty()) && (!this.field2.getText().isEmpty())) {
/*  67 */       if (this.field.getText().equals(this.field2.getText()))
/*     */       {
/*  69 */         this.mc.thePlayer.sendChatMessage("/register " + this.field.getText() + " " + this.field.getText());
/*  70 */         this.mc.setIngameFocus();
/*     */       }
/*     */       else
/*     */       {
/*  74 */         this.label = "�cMots de passes diff�rents !";
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void mouseClicked(int i, int j, int k)
/*     */   {
/*  81 */     super.mouseClicked(i, j, k);
/*     */     
/*  83 */     this.field.mouseClicked(i, j, k);
/*  84 */     this.field2.mouseClicked(i, j, k);
/*     */   }
/*     */   
/*     */   protected void actionPerformed(GuiButton guibutton)
/*     */   {
/*  89 */     if (!guibutton.enabled) {
/*  90 */       return;
/*     */     }
/*  92 */     switch (guibutton.id)
/*     */     {
/*     */     case 15: 
/*  95 */       this.mc.theWorld.sendQuittingDisconnectingPacket();
/*  96 */       this.mc.loadWorld(null);
/*  97 */       this.mc.displayGuiScreen(new GuiMainMenu());
/*  98 */       break;
/*     */     case 16: 
/* 100 */       if ((!this.field.getText().isEmpty()) && (!this.field2.getText().isEmpty())) {
/* 101 */         if (this.field.getText().equals(this.field2.getText()))
/*     */         {
/* 103 */           this.mc.thePlayer.sendChatMessage("/register " + this.field.getText() + " " + this.field.getText());
/* 104 */           this.mc.setIngameFocus();
/*     */         }
/*     */         else
/*     */         {
/* 108 */           this.label = "�cMots de passes diff�rents !";
/*     */         }
/*     */       }
/*     */       break;
/*     */     }
/*     */   }
/*     */ }