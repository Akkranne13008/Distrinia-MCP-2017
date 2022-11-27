package fr.maxlego08.shop.guis;

import fr.maxlego08.Colors;
import fr.maxlego08.Lang;
import fr.maxlego08.packet.PacketManager;
import fr.maxlego08.shop.ShopCategory;
import fr.maxlego08.shop.ShopManager;
import fr.maxlego08.shop.ZGui;
import fr.maxlego08.shop.buttons.GuiButtonShopBack;
import fr.maxlego08.shop.buttons.GuiButtonShopBack.BackType;
import fr.maxlego08.shop.datas.PlayerItemData;
import fr.telozia.bastienr.TexturedButton;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

public class GuiShopBuyItem extends ZGui implements GuiYesNoCallback{

	private final PlayerItemData data;
	private final ShopCategory c;
	private final int page;
	
	private final String[] field_146327_L = new String[] {"CON", "COM", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"};	   
	
	
	private GuiTextField price;
	private String priceString;
	
	public GuiShopBuyItem(PlayerItemData d, ShopCategory c, int p) {
		this.data = d;
		this.c = c;
		this.page = p;
	}
	
	@Override
	public void initGui() {
		this.buttonList.clear();
		
		int posX = this.width / 9;
		int posY = this.height / 5;
		
		int sizeX = (this.width / 10)-2;
		int sizeY = (this.height / 12);
		
		this.buttonList.add(new TexturedButton(33, this.width / 2 - this.width / 10, this.height - this.height/5, sizeX+this.width/10, sizeY, Lang.back,"retour.png", "retour.png"));
		
		
		this.buttonList.add(new TexturedButton(35, this.width / 4, this.height - this.height/3, sizeX+this.width/10, sizeY, Lang.buy,"BUY.png","BUY.png"));
		this.buttonList.add(new TexturedButton(36, this.width / 2 + this.width/16, this.height - this.height/3, sizeX+this.width/10, sizeY, Lang.allSell,"SELL.png", "SELL.png"));

	
		
		this.price = new GuiTextField(this.fontRendererObj, this.width / 2 - this.width/17, this.height/3 + this.height/50, 50, 20);
		this.price.setText(String.valueOf(data.getHow()));
		
		super.initGui();
	}
	
    public void updateScreen()
    {
    	if (this.price.isFocused()){
    		this.price.updateCursorCounter();
    	}
    }
	
	@Override
	protected void actionPerformed(GuiButton button) {
		int id = button.id;
		
		if (id == 33){
			this.mc.displayGuiScreen(new GuiShopDisplayCategory(c, page));
		}
		
		if (id == 35){
			if (data.getBuyPrice() == 0){
				mc.ingameGUI.getChatGUI().func_146227_a(new ChatComponentText(Lang.canBuy));
				return;				
			}			
			if (data.getHow() > 2304){
				mc.ingameGUI.getChatGUI().func_146227_a(new ChatComponentText(Lang.canBuyMore));
				return;
			}
			PacketManager.sendShopBuyPacket(data);
		}
		if (id == 36){
			if (data.getSellPrice() == 0){
				mc.ingameGUI.getChatGUI().func_146227_a(new ChatComponentText(Lang.canSell));
				return;				
			}			
			PacketManager.sendShopSellPacket(data);
		}
		
		super.actionPerformed(button);
	}
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		this.drawShopBuyItem(Lang.guiShopBuyItem);	
		
		this.drawString(fontRendererObj, data.getBuyPrice() != 0 ? Lang.price.replace("%price%", data.getBuyPrice() * data.getHow()+"") : Lang.canBuyString, data.getBuyPrice() != 0 ? this.width / 4 : this.width/4-this.width/20, this.height/2 + this.height / 8 - this.height/65, Colors.getWhite().getRGB());
		this.drawString(fontRendererObj, data.getSellPrice() != 0 ? Lang.price.replace("%price%", data.getSellPrice()+"") : Lang.canSellString, data.getSellPrice() != 0 ? this.width / 2 + this.width/16 : this.width / 2, this.height/2 + this.height / 8 - this.height/65, Colors.getWhite().getRGB());
				
		this.drawItemInToScreen(new ItemStack(data.getItem(), 1, data.getData()), width / 2 - this.width/54, this.height/3 - this.height / 12, 10, false);
		RenderHelper.disableStandardItemLighting();
		
		this.drawCenteredString(fontRendererObj, Lang.yourMoney.replace("%money%", getPriceDouble(ShopManager.getMoney())), this.width / 2, this.height/2, Colors.getWhite().getRGB());
		
		this.price.drawTextBox();
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
    
	public String getPriceDouble(double price){
		String p = price+"";	
		String[] q = p.split("");
		StringBuilder sb = new StringBuilder();
		int a = 0;
		while(!q[a].equalsIgnoreCase("."))
		{
			sb.append(q[a]);
		    a++;
		}	
		String raison = sb+"."+q[a+1];		
	
		return raison;
	}
	
	
    /* 
     * la souris peux sortir du guitext 
     * */
	
    protected void mouseClicked(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
        this.price.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
        
    }
	
    private char[] intChar = new char[]{'1','2','3','4','5','6','7','8','9','0'};
    
    private boolean isNomber(char c){
    	for(char c2 : intChar){
    		if (c == c2){return true;}
    	}
    	return false;
    }
    
    protected void keyTyped(char chart, int p_73869_2_)
    {
        if (this.price.isFocused() && p_73869_2_ == 14|| isNomber(chart))
        {
            this.price.textboxKeyTyped(chart, p_73869_2_);
            this.priceString = this.price.getText();
            try{
            	data.setHow(Integer.parseInt(priceString));
            	if (data.getHow() > 2304){
                    this.price.setText("2304");
                    this.priceString = this.price.getText();
                    data.setHow(Integer.parseInt(priceString));
            	}
            }catch (NumberFormatException e) { }
            if (this.priceString.length() == 0){            	
            	data.setHow(1);
            }
        }
    }
    
	
}
