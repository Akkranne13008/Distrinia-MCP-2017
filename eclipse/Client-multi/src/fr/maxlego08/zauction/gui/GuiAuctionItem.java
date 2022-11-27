package fr.maxlego08.zauction.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import fr.maxlego08.zauction.AuctionManager;
import fr.maxlego08.zauction.gui.buttons.GuiAuctionButton;
import fr.maxlego08.zauction.gui.buttons.GuiButtonAuctionBack;
import fr.maxlego08.zauction.gui.buttons.GuiDefaultButton;
import fr.maxlego08.zauction.gui.buttons.GuiButtonAuctionBack.BackType;
import fr.maxlego08.zauction.packet.PacketServerHDV;
import fr.maxlego08.zauction.util.AuctionItem;
import fr.maxlego08.zauction.util.AuctionAction;
import fr.maxlego08.zauction.util.Lang;
import fr.maxlego08.zauction.util.ZGui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;

public class GuiAuctionItem extends ZGui{

	private List<AuctionItem> items;
	private int page;
	
	public GuiAuctionItem(List<AuctionItem> items, int page) {
		this.items = items;
		this.page = page;
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

		this.buttonList.add(new GuiButtonAuctionBack(1, this.width / 2 - this.width / 10,
				this.height - this.height / 4, sizeX + this.width / 10, sizeY, Lang.back, BackType.MIDDLE));

		this.buttonList.add(new GuiDefaultButton(50, this.width - this.width / 10 - 25, this.height / 5, 20, 20, "X",
				new Color(173, 26, 26), new Color(216, 56, 56)));
		this.buttonList.add(new GuiButtonAuctionBack(101, this.width - this.width / 5, this.height - this.height / 5,
				sizeX, sizeY, Lang.next, BackType.RIGHT));
		this.buttonList.add(new GuiButtonAuctionBack(100, posX - this.width / 146, this.height - this.height / 5, sizeX,
				sizeY, Lang.previous, BackType.LEFT));
	}

	protected void actionPerformed(GuiButton button) {
		if (button.id == 0) {
			GuiAuctionButton clickedButton = (GuiAuctionButton) button;
			AuctionItem item = clickedButton.getItem();
			this.mc.thePlayer.sendQueue.addToSendQueue(new PacketServerHDV(AuctionAction.RECUPITEM, item));
			this.mc.displayGuiScreen(null);
			this.mc.setIngameFocus();
		}
		if (button.id == 1) 
			this.mc.thePlayer.sendChatMessage("/hdv");
		else if (button.id == 100) {
			if (this.page != 1)
				this.mc.displayGuiScreen(new GuiAuctionItem(this.items, this.page - 1));
		} else if (button.id == 101) {
			if (this.page * 9 < this.items.size())
				this.mc.displayGuiScreen(new GuiAuctionItem(this.items, this.page + 1));

		}
	}

	public void drawScreen(int mouseX, int mouseY, float partialTick) {

		this.drawDefaultBackground();

		this.drawAuction(Lang.guiAuctionItem, Lang.guiAuctionPage
				.replace("%page%", String.valueOf(page)).replace("%maxpage%", String.valueOf(getMaxPage())));

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
}
