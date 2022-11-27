package fr.maxlego08.shop.guis;

import java.util.ArrayList;
import java.util.List;

import fr.maxlego08.Colors;
import fr.maxlego08.Lang;
import fr.maxlego08.shop.ShopCategory;
import fr.maxlego08.shop.ShopManager;
import fr.maxlego08.shop.ZGui;
import fr.maxlego08.shop.buttons.GuiButtonShopBack;
import fr.maxlego08.shop.buttons.GuiButtonShopBack.BackType;
import fr.maxlego08.shop.buttons.GuiButtonShopItem;
import fr.maxlego08.shop.datas.ShopData;
import fr.telozia.bastienr.TexturedButton;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiYesNoCallback;

public class GuiShopDisplayCategory extends ZGui implements GuiYesNoCallback{

	private final ShopCategory shopCategory;
	private final int page;
	
	private List<ShopData> items = new ArrayList();
	
	public GuiShopDisplayCategory(ShopCategory shopCategory, int page) {
		this.shopCategory = shopCategory;
		this.page = page;
	}
	
	public GuiShopDisplayCategory(ShopCategory shopCategory) {
		this.shopCategory = shopCategory;
		this.page = 1;
	}
	
	@Override
	public void initGui() {
		this.buttonList.clear();
		
		this.drawDefaultButton();
		
		this.drawItem();
		
		super.initGui();
	}
    
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		this.drawShop(Lang.guiShopDiplayCategory.replace("%name%", shopCategory.getName()));	
				
		this.drawCenteredString(mc.fontRenderer, Lang.page.replace("%currentPage%", page+"").replace("%maxPage%", ShopManager.getMaxPage(shopCategory)+""),
				width / 2, this.height - this.height/4, Colors.getWhite().getRGB());
		
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	private void drawDefaultButton(){
		
		int posX = this.width / 9;
		int posY = this.height / 5;
		
		int sizeX = (this.width / 10)-2;
		int sizeY = (this.height / 12);
		
		this.buttonList.add(new TexturedButton(30, this.width-this.width/5, this.height - this.height/5, sizeX, sizeY, Lang.right,"button_right.png", "button_right.png")); 
		
		
	
		
		 this.buttonList.add(new TexturedButton(31, posX - this.width / 146, this.height - this.height / 5, sizeX,
					sizeY, Lang.left, "button_left.png", "button_left.png"));
		
		this.buttonList.add(new TexturedButton(33, this.width / 2 - this.width / 10, this.height - this.height/5, sizeX+this.width/10, sizeY, Lang.back,"retour.png", "retour.png"));
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		int id = button.id;
		
		if (id == 33){
			this.mc.displayGuiScreen(new GuiShopMain());
		}
		
		if (id == 30){
			if (ShopManager.getMaxPage(shopCategory) != page){
				this.mc.displayGuiScreen(new GuiShopDisplayCategory(shopCategory, page+1));
			}
		}

		if (id == 31){
			if (page != 1){
				this.mc.displayGuiScreen(new GuiShopDisplayCategory(shopCategory, page-1));
			}
		}
		
		if (id >= 0 && id <= 12){
			ShopManager.buyItem(this.items.get(id), shopCategory, page);		
		}
		
		
		super.actionPerformed(button);
	}
	
	
	private void drawItem(){
		try{
			
			this.items.clear();
			
			int posX = this.width / 9 + this.width / 50;
			int posY = this.height / 5;
		
			int sizeX = (this.width / 9) + 3;
			int sizeY = (this.height / 6);
		
			int how = 0;
		
			int max = 12;
			int start = (page-1)*12; 
			
			if (ShopManager.getItems(shopCategory).size() >= page*12){
				
			}else{
				max = ShopManager.getItems(shopCategory).size();
			}
			
			for(int a = start; a != max; a++){
				ShopData data = ShopManager.getItems(shopCategory).get(a);
				this.items.add(data);
				this.buttonList.add(new GuiButtonShopItem(how, posX, posY + this.height/20, sizeX, sizeY, data.getItem(), Lang.buy, 0));
				posX += this.width / 8;
				how++;
				if (how > 14){
					continue;
				}
				if (how == 6){
					posY += this.height/5 + this.height/41;
					posX = this.width / 9 + this.width / 50;
				}
				
				
			}
		}catch (Exception e) { }
		
		
	}
}
