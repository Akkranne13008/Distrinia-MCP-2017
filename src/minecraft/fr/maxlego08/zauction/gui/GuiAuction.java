package fr.maxlego08.zauction.gui;

import java.util.ArrayList;
import java.util.List;

import fr.maxlego08.zauction.AuctionManager;
import fr.maxlego08.zauction.gui.buttons.GuiAuctionButton;
import fr.maxlego08.zauction.gui.buttons.GuiButtonAuctionBack;
import fr.maxlego08.zauction.gui.buttons.GuiButtonAuctionBack.BackType;
import fr.maxlego08.zauction.packet.PacketServerHDV;
import fr.maxlego08.zauction.util.AuctionAction;
import fr.maxlego08.zauction.util.AuctionItem;
import fr.maxlego08.zauction.util.Lang;
import fr.maxlego08.zauction.util.ZGui;
import fr.telozia.bastienr.TexturedButton;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;

public class GuiAuction extends ZGui {

	private List<AuctionItem> items = new ArrayList<>();
	private int page;
	private String lastText;

	private GuiTextField search;

	public GuiAuction(List<AuctionItem> items, int page, String lastText) {
		items.forEach(item -> {
			if (!isExpired(item)) this.items.add(item);
		});
		this.page = page;
		this.lastText = lastText;
	}

	public void initGui() {

		this.buttonList.clear();

		int xCount = 0;
		int yCount = 0;
		int count = 0;

		int idStart = items.size() - 1 - ((page - 1) * 9);
		int idEnd = idStart - 9;
		if (idEnd < items.size() - 9 && items.size() < 9 * page)
			idEnd = -1;
		int slot = 0;
		for (int a = idStart; a != idEnd; a--) {
			this.buttonList.add(new GuiAuctionButton(0, this.width / 2 - this.width / 3 + xCount,
					this.height / 2 - this.height / 4 + yCount, (this.width / 5 + this.width / 72), this.height / 8, "",
					items.get(a)));
			xCount += (this.width / 4 - this.width / 62);
			if (xCount == ((this.width / 4 - this.width / 62) * 3)) {
				xCount = 0;
				yCount += this.height / 6;
			}
		}
		
		

		int posX = this.width / 9;
		int posY = this.height / 5;

		int sizeX = (this.width / 10) - 2;
		int sizeY = (this.height / 12);
		this.search = new GuiTextField(this.mc.fontRenderer, this.width / 2 - this.width / 10,
				this.height / 2 + (this.height / 3 - this.height / 42), this.width / 5, this.height / 19);
		this.search.func_146185_a(true);
		this.search.setText(this.lastText);
		this.search.setFocused(true);

	

		this.buttonList.add(new GuiButtonAuctionBack(1, this.width / 2 - (this.width / 4 + this.width / 43),
				this.height / 2 + (this.height / 3 - this.height / 22), this.width / 7, this.height / 12, Lang.sells,
				BackType.MIDDLE));
		
		
		// bouton de droit
		 this.buttonList.add(new TexturedButton(101, this.width - this.width / 5, this.height - this.height / 5,
					sizeX, sizeY, Lang.next, "button_right.png", "button_right.png"));

		//bouton de gauche
		 this.buttonList.add(new TexturedButton(100, posX - this.width / 146, this.height - this.height / 5, sizeX,
					sizeY, Lang.previous, "button_left.png", "button_left.png"));
		 
		 
// bOUTON DE REFRESH
	        this.buttonList.add(new TexturedButton(2, this.width / 2 + this.width / 8,
					this.height / 2 + (this.height / 3 - this.height / 22), this.width / 7, this.height / 12, Lang.refresh, "button_refresh.png", "button_refresh.png"));
		
	        // BOUTON DE FERMER

        this.buttonList.add(new TexturedButton(50, this.width - this.width / 10 - 25, this.height / 5, 20, 20, "", "fermer1.png", "fermerhover.png"));
        
        
        
	}

	private boolean isExpired(AuctionItem item){
		return (item.getExpiration() * 3600000 + item.getTime()) < System.currentTimeMillis();
	}
	
	protected void actionPerformed(GuiButton button) {
		if (button.id == 0) {
			GuiAuctionButton clickedButton = (GuiAuctionButton) button;
			AuctionItem item = clickedButton.getItem();
			if (item.getPlayerName().equals(this.mc.getSession().getUsername())) {
				this.mc.thePlayer.sendQueue.addToSendQueue(new PacketServerHDV(AuctionAction.RECUPITEM, item));
				this.mc.displayGuiScreen(null);
				this.mc.setIngameFocus();
			} else
				this.mc.displayGuiScreen(new GuiAuctionBuy(item, this));
		}
		if (button.id == 1) {
			List<AuctionItem> items = new ArrayList<AuctionItem>();
			this.items.forEach(item -> {
				if (item.getPlayerName().equals(this.mc.getSession().getUsername()))
					items.add(item);
			});
			this.mc.displayGuiScreen(new GuiAuctionItem(items, 1));

		}
		if (button.id == 2){
			this.mc.thePlayer.sendChatMessage("/hdv");
		}else if (button.id == 50) {
			this.mc.displayGuiScreen(null);
			this.mc.setIngameFocus();
		} else if (button.id == 100) {
			if (this.page != 1)
				this.mc.displayGuiScreen(new GuiAuction(this.items, this.page - 1, ""));
		} else if (button.id == 101) {
			if (this.page * 9 < this.items.size()){
				this.mc.displayGuiScreen(new GuiAuction(this.items, this.page + 1, ""));
			}

		}
	}

	public void drawScreen(int mouseX, int mouseY, float partialTick) {

		this.drawDefaultBackground();

		this.drawAuction(Lang.guiAuction, Lang.guiAuctionPage.replace("%page%", String.valueOf(page))
				.replace("%maxpage%", String.valueOf(getMaxPage())));

		if (this.search != null)
			this.search.drawTextBox();

		super.drawScreen(mouseX, mouseY, partialTick);

		this.buttonList.forEach(button -> {
			if (button instanceof GuiAuctionButton)
				((GuiAuctionButton) button).drawHoverDescription(mouseX, mouseY);
		});

	}

	private int getMaxPage() {
		if (items.isEmpty())
			return 1;
		return (items.size() / 9) + 1;
	}

	public void updateScreen() {
		if (this.search != null)
			this.search.updateCursorCounter();
	}

	protected void keyTyped(char p_73869_1_, int p_73869_2_) {

		if (this.search != null) {
			if (this.search.isFocused()) {

				this.search.textboxKeyTyped(p_73869_1_, p_73869_2_);
				if (p_73869_2_ != 14) {

					List<AuctionItem> items = new ArrayList<AuctionItem>();

					AuctionManager.items.forEach(item -> {
						if (this.search.getText().length() != 0)
							if (item.getItem().getDisplayName().toLowerCase().contains(this.search.getText()))
								items.add(item);
					});

					this.mc.displayGuiScreen(new GuiAuction(items, this.page, this.search.getText().trim()));

				} else

					this.mc.displayGuiScreen(
							new GuiAuction(AuctionManager.items, this.page, this.search.getText().trim()));
			}
		}
	}



	protected void mouseClicked(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
		super.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
		if (this.search != null)
			this.search.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
	}
}
