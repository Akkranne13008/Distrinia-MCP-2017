package fr.telozia.bastienr;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

public class GuiQuest
extends GuiScreen {
    private final ResourceLocation background = new ResourceLocation("textures/gui/quete-background.png");

    @Override
    public void initGui() {
        this.buttonList.clear();
        int x = (this.width + -395) / 2;
        int y = (this.height - 120) / 2;
        int x1 = (this.width + -238) / 2;
        int y1 = (this.height - 120) / 2;
        int x2 = (this.width + -70) / 2;
        int y2 = (this.height - 120) / 2;
        int x3 = (this.width + 97) / 2;
        int y3 = (this.height - 120) / 2;
        int x4 = (this.width + 262) / 2;
        int y4 = (this.height - 120) / 2;
        int x5 = (this.width + -395) / 2;
        int y5 = (this.height + 10) / 2;
        int x6 = (this.width + -238) / 2;
        int y6 = (this.height + 10) / 2;
        int x7 = (this.width + -70) / 2;
        int y7 = (this.height + 10) / 2;
        int x8 = (this.width + 97) / 2;
        int y8 = (this.height + 10) / 2;
        int x9 = (this.width + 262) / 2;
        int y9 = (this.height + 10) / 2;
        int x10 = (this.width + -395) / 2;
        int y10 = (this.height + 145) / 2;
        int x11 = (this.width + -238) / 2;
        int y11 = (this.height + 145) / 2;
        int x12 = (this.width + -70) / 2;
        int y12 = (this.height + 145) / 2;
        int x13 = (this.width + 97) / 2;
        int y13 = (this.height + 145) / 2;
        int x14 = (this.width + 262) / 2;
        int y14 = (this.height + 145) / 2;
        this.buttonList.add(new TexturedButton(1, x, y, 66, 17, "", "lancer.png", "lancer_hover.png"));
        this.buttonList.add(new TexturedButton(2, x1, y1, 66, 17, "", "lancer.png", "lancer_hover.png"));
        this.buttonList.add(new TexturedButton(3, x2, y2, 66, 17, "", "lancer.png", "lancer_hover.png"));
        this.buttonList.add(new TexturedButton(4, x3, y3, 66, 17, "", "lancer.png", "lancer_hover.png"));
        this.buttonList.add(new TexturedButton(5, x4, y4, 66, 17, "", "lancer.png", "lancer_hover.png"));
        this.buttonList.add(new TexturedButton(6, x5, y5, 66, 17, "", "lancer.png", "lancer_hover.png"));
        this.buttonList.add(new TexturedButton(7, x6, y6, 66, 17, "", "lancer.png", "lancer_hover.png"));
        this.buttonList.add(new TexturedButton(8, x7, y7, 66, 17, "", "lancer.png", "lancer_hover.png"));
        this.buttonList.add(new TexturedButton(9, x8, y8, 66, 17, "", "lancer.png", "lancer_hover.png"));
        this.buttonList.add(new TexturedButton(10, x9, y9, 66, 17, "", "lancer.png", "lancer_hover.png"));
        this.buttonList.add(new TexturedButton(11, x10, y10, 66, 17, "", "soon.png", "soon_hover.png"));
        this.buttonList.add(new TexturedButton(12, x11, y11, 66, 17, "", "soon.png", "soon_hover.png"));
        this.buttonList.add(new TexturedButton(13, x12, y12, 66, 17, "", "soon.png", "soon_hover.png"));
        this.buttonList.add(new TexturedButton(14, x13, y13, 66, 17, "", "soon.png", "soon_hover.png"));
        this.buttonList.add(new TexturedButton(15, x14, y14, 66, 17, "", "soon.png", "soon_hover.png"));
    }

    @Override
    protected void actionPerformed(GuiButton p_146284_1_) {
        if (p_146284_1_.id == 1) {
            this.mc.thePlayer.sendChatMessage("/quests take Jardinier");
            this.mc.displayGuiScreen(null);
        }
        if (p_146284_1_.id == 2) {
            this.mc.thePlayer.sendChatMessage("/quests take Enchanteur");
            this.mc.displayGuiScreen(null);
        }
        if (p_146284_1_.id == 3) {
            this.mc.thePlayer.sendChatMessage("/quests take Pecheur");
            this.mc.displayGuiScreen(null);
        }
        if (p_146284_1_.id == 4) {
            this.mc.thePlayer.sendChatMessage("/quests take Farmeur");
            this.mc.displayGuiScreen(null);
        }
        if (p_146284_1_.id == 5) {
            this.mc.thePlayer.sendChatMessage("/quests take Tueur");
            this.mc.displayGuiScreen(null);
        }
        if (p_146284_1_.id == 6) {
            this.mc.thePlayer.sendChatMessage("/quests take Mineur");
            this.mc.displayGuiScreen(null);
        }
        if (p_146284_1_.id == 7) {
            this.mc.thePlayer.sendChatMessage("/quests take Terroriste");
            this.mc.displayGuiScreen(null);
        }
        if (p_146284_1_.id == 8) {
            this.mc.thePlayer.sendChatMessage("/quests take Explorateur");
            this.mc.displayGuiScreen(null);
        }
        if (p_146284_1_.id == 9) {
            this.mc.thePlayer.sendChatMessage("/quests take Trolleur");
            this.mc.displayGuiScreen(null);
        }
        if (p_146284_1_.id == 10) {
            this.mc.thePlayer.sendChatMessage("/quests take Coiffeur");
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
        this.drawTexturedModalRectWithOptionnalSize((this.width - 430) / 2, (this.height - 280) / 2, 0, 0, 426, 240);
        this.drawGradientRect(0, 0, this.width, 15, 2130706433, 2130706433);
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

