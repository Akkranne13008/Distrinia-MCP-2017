package fr.maxlego08.zauction.util;

import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public abstract class ZGui extends GuiScreen{

	protected void drawAuction(String title){
		drawAuction(title, null);
	}
    protected void drawAuction(String title, String subTitgle){
		int posX = this.width / 10;
		int posY = this.height / 5;
    	this.drawRect(posX, posY, this.width-this.width/10, this.height-this.height/12, Colors.getBackgroundAuction());    	
    	this.drawRectangle(posX, posY, this.width-this.width/10, this.height-this.height/12, Colors.getBlack());   	
    	this.drawRect(this.width / 3, this.height / 12, this.width-this.width/3, posY+1, Colors.getBackgroundAuction());
    	this.drawRectangleAuction(this.width / 3, this.height / 12, this.width-this.width/3, posY, Colors.getBlack());   	
    	
    	
    	
		this.drawCenteredString(this.fontRendererObj, title, this.width / 2, posY - this.height / 10, Colors.getWhite().getRGB());
		if (subTitgle != null) this.drawCenteredString(this.fontRendererObj, subTitgle, this.width / 2, posY - this.height / 17, Colors.getWhite().getRGB());
    	
    }
	
    protected void drawAuctionBuyItem(String title){
    	int posX = this.width / 6;
    	int posY = this.height / 5;
    	
    	this.drawRect(posX, posY, this.width-posX, this.height-this.height/12, Colors.getBackgroundAuction());    	
    	this.drawRectangle(posX, posY, this.width-posX, this.height-this.height/12, Colors.getBlack());   	
    	
    	this.drawRect(this.width / 3, this.height / 12, this.width-this.width/3, posY+1, Colors.getBackgroundAuction());
    	this.drawRectangleAuction(this.width / 3, this.height / 12, this.width-this.width/3, posY, Colors.getBlack());   	
    	this.drawCenteredString(this.fontRendererObj, title, this.width / 2, posY - this.height / 18, Colors.getWhite().getRGB());
    	
    }
    
    public void drawRectangle(int posX, int posY, int maxPosX, int maxPosY, int color){
    	this.drawHorizontalLine(posX, maxPosX, posY, color);		
    	this.drawHorizontalLine(posX, maxPosX, maxPosY, color);   	
    	this.drawVerticalLine(posX, posY, maxPosY, color);
    	this.drawVerticalLine(maxPosX, posY, maxPosY, color); 
    }
    
    public void drawRectangleAuction(int posX, int posY, int maxPosX, int maxPosY, int color){
    	this.drawHorizontalLine(posX, maxPosX, posY, color);		
    	this.drawVerticalLine(posX, posY, maxPosY, color);
    	this.drawVerticalLine(maxPosX, posY, maxPosY, color); 
    }
    
	public void func_146285_a(ItemStack i, int x, int y, AuctionItem item) {
		List list = i.getTooltip(this.mc.thePlayer, this.mc.gameSettings.advancedItemTooltips);

		Lang.lore.forEach(lore -> {
			list.add(lore
				.replace("%info%", item.getPlayerName().equals(this.mc.getSession().getUsername()) ? Lang.loreInfoPlayer : Lang.loreInfoBuy)
				.replace("%seller%", item.getPlayerName())
				.replace("%price%", item.getPrice()+"")
				.replace("%amount%", item.getItem().stackSize+"")
				.replace("%expired%", getFormatLongHoursSimple(Math.abs(System.currentTimeMillis() - (item.getExpiration() * 3600000 + item.getTime()))))
			);
		});

		for (int var5 = 0; var5 < list.size(); ++var5) {
			if (var5 == 0)
				list.set(var5, i.getRarity().rarityColor + (String) list.get(var5));
			else
				list.set(var5, EnumChatFormatting.GRAY + (String) list.get(var5));

		}

		Minecraft.getMinecraft().currentScreen.func_146283_a(list, x, y);
	}

	public String getFormatLongHoursSimple(long temps) {
		long totalSecs = temps / 1000;
		return String.format(Lang.format, new Object[] { Long.valueOf(totalSecs / 3600L),
				Long.valueOf(totalSecs % 3600L / 60L), Long.valueOf(totalSecs % 60L) });
	}
    
    private final RenderItem itemRenderer = new RenderItem();
    
    public void drawItemInToScreen(ItemStack item, int x, int y, float par3, boolean overlay)  
    {
    	if (item != null)
    	{
    	    float an = (float)item.animationsToGo - par3;
            if (an > 0.0F)
            {
            	GL11.glPushMatrix();
                float dec = 1.0F + an / 5.0F;
                GL11.glTranslatef((float)(x + 8), (float)(y + 12), 0.0F);
                GL11.glScalef(1.0F / dec, (dec + 1.0F) / 2.0F, 1.0F);
                GL11.glTranslatef((float)(-(x + 8)), (float)(-(y + 12)), 0.0F);
            }
            itemRenderer.renderItemAndEffectIntoGUI(this.mc.fontRenderer, this.mc.getTextureManager(), item, x, y);
            if (an > 0.0F)
                GL11.glPopMatrix();
            if (overlay)
            	itemRenderer.renderItemOverlayIntoGUI(this.mc.fontRenderer, this.mc.getTextureManager(), item, y, y);
    	}
    }
    
}
