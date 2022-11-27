package fr.telozia.bastienr;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiLoadingScreen
  extends GuiScreen
{
  private final ResourceLocation backGround = new ResourceLocation("textures/gui/title/chargement.png");
  private int updateCounter = 0;
  String chargementText = "§6Chargement§f de la porte ...";
  String serverName = "§6Faction";
  String texteHaut = "§6Connexion§7 au serveur ! ...";
  String bfsName = "§7Serveur:";
  
  public void initGui()
  {
    this.buttonList.add(new GuiButton(9, this.width - 100, this.height - 30, 60, 20, "Annuler"));
  }
  
  public void updateScreen()
  {
    this.updateCounter += 1;
    if (this.updateCounter == 100) {
      this.mc.displayGuiScreen(new GuiConnecting(this, this.mc, "46.105.208.128", 25565));
    }
    if (this.updateCounter >= 101) {
      this.mc.displayGuiScreen(new GuiMainMenu());
    }
  }
  
  public void drawBack()
  {
    GL11.glViewport(0, 0, 256, 256);
    this.mc.getTextureManager().bindTexture(this.backGround);
    GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
    Tessellator tessellator = Tessellator.instance;
    tessellator.startDrawingQuads();
    GL11.glTexParameteri(3553, 10241, 9729);
    GL11.glTexParameteri(3553, 10240, 9729);
    tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
    int k = this.width;
    int l = this.height;
    tessellator.addVertexWithUV(0.0D, 0.0D, this.zLevel, 0.0D, 0.0D);
    tessellator.addVertexWithUV(0.0D, l, this.zLevel, 0.0D, 1.0D);
    tessellator.addVertexWithUV(k, l, this.zLevel, 1.0D, 1.0D);
    tessellator.addVertexWithUV(k, 0.0D, this.zLevel, 1.0D, 0.0D);
    tessellator.draw();
  }
  
  public void drawScreen(int par1, int par2, float par3)
  {
    drawBack();
    drawHorizontalLine(0, this.width, this.height - 47, 1426063360);
    drawHorizontalLine(0, this.width, this.height - 46, 1426063360);
    drawRect(0, this.height - 45, this.width, this.height, 1426063360);
    drawRect(this.width / 2 - 101, this.height - 28, this.width / 2 + 101, this.height - 15, 489386);
    drawRect(this.width / 2 - 100, this.height - 27, this.width / 2 + 100, this.height - 16, 2013243904);
    drawRect(this.width / 2 - 100, this.height - 27, this.width / 2 - 100 + this.updateCounter * 2, this.height - 16, -1996510720);
    drawCenteredString(this.fontRendererObj, this.chargementText, this.width / 2, this.height - 40, 16777215);
    String percent = this.updateCounter + "§6%";
    drawCenteredString(this.fontRendererObj, percent, this.width / 2, this.height - 10, 16777215);
    drawCenteredString(this.fontRendererObj, this.texteHaut, this.width / 2, 1, -1);
    drawString(this.fontRendererObj, this.bfsName, 10, this.height - 30, -1);
    drawString(this.fontRendererObj, this.serverName, 10, this.height - 19, -1);
    super.drawScreen(par1, par2, par3);
  }
  
  public void actionPerformed(GuiButton button)
  {
    if (button.id == 9) {
      this.mc.displayGuiScreen(new GuiMainMenu());
    }
  }
}