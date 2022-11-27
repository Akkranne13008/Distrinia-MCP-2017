package fr.maxlego08.zauction.gui;

import java.awt.Color;

import fr.maxlego08.zauction.gui.buttons.GuiButtonAuctionBack;
import fr.maxlego08.zauction.gui.buttons.GuiButtonAuctionBack.BackType;
import fr.maxlego08.zauction.gui.buttons.GuiDefaultButton;
import fr.maxlego08.zauction.packet.PacketServerHDV;
import fr.maxlego08.zauction.util.AuctionItem;
import fr.maxlego08.zauction.util.Colors;
import fr.maxlego08.zauction.util.AuctionAction;
import fr.maxlego08.zauction.util.Lang;
import fr.maxlego08.zauction.util.ZGui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;

public class GuiAuctionBuy extends ZGui {

	private AuctionItem item;
	private GuiScreen lastGui;

	public GuiAuctionBuy(AuctionItem itemHDV, GuiScreen lastGui) {

		this.item = itemHDV;
		this.lastGui = lastGui;
	}

	public void initGui() {
		this.buttonList.clear();
		this.buttonList.add(new GuiDefaultButton(50, this.width - this.width / 6 - 25, this.height / 5, 20, 20, "X",
				new Color(173, 26, 26), new Color(216, 56, 56)));

		this.buttonList.add(new GuiButtonAuctionBack(2, this.width / 2 - 50, this.height / 2 + 70, 100, 20, Lang.buy,
				BackType.MIDDLE));
	}

	protected void actionPerformed(GuiButton button) {

		if (button.id == 2) {

			this.mc.thePlayer.sendQueue.addToSendQueue(new PacketServerHDV(AuctionAction.BUYITEM, this.item));

			this.mc.displayGuiScreen(null);
			this.mc.setIngameFocus();
		}

		if (button.id == 50) this.mc.displayGuiScreen(this.lastGui);
		
	}

	public void drawScreen(int mouseX, int mouseY, float partialTick) {

		this.drawAuctionBuyItem(Lang.guiAuctionBuy);

		drawCenteredString(mc.fontRenderer, Lang.offer.replace("%player%", this.item.getPlayerName()), this.width / 2,
				this.height / 2 - 10, Color.WHITE.getRGB());
		drawCenteredString(mc.fontRenderer, Lang.price.replace("%price%", this.item.getPrice() + ""), this.width / 2,
				this.height / 2, Color.WHITE.getRGB());

		drawCenteredString(mc.fontRenderer, "   §f" + this.item.getItem().stackSize, this.width / 2 + 8,
				this.height / 2 - 20, 1);
		
		
		RenderHelper.enableStandardItemLighting();
		drawItemInToScreen(this.item.getItem(), this.width / 2 - 10, this.height / 2 - 30, 1, false);
		RenderHelper.disableStandardItemLighting();

		super.drawScreen(mouseX, mouseY, partialTick);
		
		if (mouseX > this.width / 2 - 20 && mouseX < this.width / 2 + 20 && mouseY > this.height / 2 - 50
				&& mouseY < this.height / 2 - 10)
			func_146285_a(this.item.getItem(), mouseX, mouseY, item);
	}

}
