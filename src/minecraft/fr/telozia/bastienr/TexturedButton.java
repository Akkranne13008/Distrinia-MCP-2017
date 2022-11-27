package fr.telozia.bastienr;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TexturedButton
extends GuiButton {
    ResourceLocation img;
    ResourceLocation img2;
    private static final String __OBFID = "CL_00002104";

    public TexturedButton(int id, int pX, int pY, int w, int h, String displayStr, String texture, String texture2) {
        super(id, pX, pY, w, h, displayStr);
        this.img = new ResourceLocation("minecraft", "textures/gui/hdv/" + texture);
        this.img2 = new ResourceLocation("minecraft", "textures/gui/hdv/" + texture2);
    }

    @Override
    public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
        boolean flag = par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g;
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        if (flag) {
            par1Minecraft.getTextureManager().bindTexture(this.img2);
            this.drawImage(this.field_146128_h, this.field_146129_i, 0, 0, this.field_146120_f, this.field_146121_g);
        } else {
            par1Minecraft.getTextureManager().bindTexture(this.img);
            this.drawImage(this.field_146128_h, this.field_146129_i, 0, 0, this.field_146120_f, this.field_146121_g);
        }
    }

    public void drawImage(int x, int y, int u, int v, int width, int height) {
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

