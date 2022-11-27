package fr.maxlego08.shop.guis;

import fr.maxlego08.Lang;
import fr.maxlego08.shop.ShopCategory;
import fr.maxlego08.shop.ZGui;
import fr.maxlego08.shop.buttons.GuiButtonShopCategory;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiYesNoCallback;

public class GuiShopMain extends ZGui implements GuiYesNoCallback{
	
	private ShopCategory[] z = new ShopCategory[ShopCategory.values().length];
	
	@Override
	public void initGui() {
		this.buttonList.clear();
		
		int posX = this.width / 7;
		int posY = this.height / 5;
		
		int sizeX = (this.width / 9) + 3;
		int sizeY = (this.height / 6);
		int a = 0;
		int d = 0;
		for(ShopCategory c : ShopCategory.values()){
			if (a == 4){
				a = 0;
				posY += this.height/5 + this.height/41;
				posX = this.width / 7;
			}
			this.buttonList.add(new GuiButtonShopCategory(d, posX + this.width/20, posY + this.height/20, sizeX+this.width/28, sizeY, c.getItem(), c.getName(), 0)); 
			posX += this.width / 6 - this.width / 109;
			z[d] = c;a++;d++;
			
		}
		
		
		super.initGui();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		this.drawShop(Lang.guiShopMain);
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		
		int id = button.id;
		
		if (id >= 0 && id <= z.length){	
			this.mc.displayGuiScreen(new GuiShopDisplayCategory(z[id]));
		}
		
		super.actionPerformed(button);
	}
}