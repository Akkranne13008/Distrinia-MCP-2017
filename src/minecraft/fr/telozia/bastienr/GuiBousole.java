package fr.telozia.bastienr;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

public class GuiBousole
extends GuiScreen {
    private final ResourceLocation background = new ResourceLocation("textures/gui/telozia/test.png");

    @Override
    public void initGui() {
        this.buttonList.clear();

        int x1 = (this.width + -400) / 2;
        int y1 = (this.height - 50) / 2;
        int x2 = (this.width + -130) / 2;
        int y2 = (this.height - 50) / 2;
        int x3 = (this.width + 140) / 2;
        int y3 = (this.height - 50) / 2;
        
        int x4 = (this.width + 360) / 2;
        int y4 = (this.height - 230)/ 2;

       
        
        this.buttonList.add(new TexturedButton(8, x1, y1, 120, 40, "", "faction.png", "faction.png"));
        this.buttonList.add(new TexturedButton(9, x2, y2, 120, 40, "", "training.png", "training.png"));
        this.buttonList.add(new TexturedButton(10, x3, y3, 120, 40, "", "minage.png", "minage.png"));
        this.buttonList.add(new TexturedButton(20, x4, y4, 25, 25, "", "fermer1.png", "fermer1.png"));

    }

    @Override
    protected void actionPerformed(GuiButton p_146284_1_) {
        
        if (p_146284_1_.id == 8) {
            this.mc.thePlayer.sendChatMessage("/server faction");
            this.mc.displayGuiScreen(null);
        }
        if (p_146284_1_.id == 20) {
            this.mc.displayGuiScreen(null);
			this.mc.setIngameFocus();
        }
        if (p_146284_1_.id == 9) {
            this.mc.thePlayer.sendChatMessage("/server training");
            this.mc.displayGuiScreen(null);
        }
        if (p_146284_1_.id == 10) {
            this.mc.thePlayer.sendChatMessage("/server minage");
            this.mc.displayGuiScreen(null);
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
    }

    @Override
    public void drawScreen(int par1, int par2, float par3) {
        this.drawDefaultBackground(par2, par2);
        this.mc.getTextureManager().bindTexture(this.background);
        this.drawTexturedModalRectWithOptionnalSize((this.width - 420) / 2, (this.height - 240) / 2, 0, 0, 426, 240);

        super.drawScreen(par1, par2, par3);
    }

    public void drawDefaultBackground(int par2, int par22) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void drawTexturedModalRectWithOptionnalSize(int x, int y, int u, int v, int width, int height) {
        int uSize = width;
        int vSize = height;
        float scaledX = 1.0f / (float)uSize;
        float scaledY = 1.0f / (float)vSize;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x + 0, y + height, zLevel, (float)(u + 0) * scaledX, (float)(v + height) * scaledY);
        tessellator.addVertexWithUV(x + width, y + height, zLevel, (float)(u + width) * scaledX, (float)(v + height) * scaledY);
        tessellator.addVertexWithUV(x + width, y + 0, zLevel, (float)(u + width) * scaledX, (float)(v + 0) * scaledY);
        tessellator.addVertexWithUV(x + 0, y + 0, zLevel, (float)(u + 0) * scaledX, (float)(v + 0) * scaledY);
        tessellator.draw();
    }
}

