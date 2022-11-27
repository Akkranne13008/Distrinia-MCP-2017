package fr.maxlego08.zauction.gui;

import java.awt.Color;

import org.apache.commons.lang3.StringUtils;
import org.lwjgl.opengl.GL11;

import fr.maxlego08.zauction.gui.buttons.GuiButtonAuctionBack;
import fr.maxlego08.zauction.gui.buttons.GuiButtonAuctionBack.BackType;
import fr.maxlego08.zauction.gui.buttons.GuiDefaultButton;
import fr.maxlego08.zauction.packet.PacketServerHDV;
import fr.maxlego08.zauction.util.Colors;
import fr.maxlego08.zauction.util.AuctionAction;
import fr.maxlego08.zauction.util.Lang;
import fr.maxlego08.zauction.util.ZGui;
import fr.maxlego08.zauction.util.AuctionItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;

public class GuiAuctionSell extends ZGui {

	private AuctionItem item;
	private int expiration;

	private String messageError = "";

	private long messageErrorTime = 0;
	private GuiTextField textField;

	public GuiAuctionSell(AuctionItem item) {

		this.item = item;
		this.expiration = 3;
	}

	public void initGui() {

		this.buttonList.clear();

		this.textField = new GuiTextField(this.mc.fontRenderer, this.width / 2 - 40, this.height / 2 - 6, 80, 15);
		this.textField.setFocused(true);
		this.textField.func_146185_a(true);

		this.buttonList.add(new GuiDefaultButton(3, this.width / 2 - 100, this.height / 2 + 15, 50, 20, "3h"));
		this.buttonList.add(new GuiDefaultButton(6, this.width / 2 - 25, this.height / 2 + 15, 50, 20, "6h"));
		this.buttonList.add(new GuiDefaultButton(12, this.width / 2 + 50, this.height / 2 + 15, 50, 20, "12h"));

		this.buttonList.add(new GuiButtonAuctionBack(0, this.width / 2 - 50, this.height / 2 + 70, 100, 20, Lang.sell, BackType.MIDDLE));
		
		this.buttonList.add(new GuiDefaultButton(50, this.width - this.width/6 - 25, this.height / 5, 20, 20, "§4X",
				new Color(173, 26, 26), new Color(216, 56, 56)));
	}

	protected void actionPerformed(GuiButton button) {

		if (button.id == 50) {
			this.mc.thePlayer.sendChatMessage("/hdv");
		}

		if (button.id >= 1 && button.id <= 12) {
			this.expiration = button.id;

		}

		if (button.id == 0) {

			if (this.expiration == 0) {

				messageError = Lang.sellError;
				messageErrorTime = System.currentTimeMillis();
				return;

			}

			if (StringUtils.isNumeric(this.textField.getText())) {

				this.item = new AuctionItem(this.item.getItem(), this.item.getPlayerName(), this.item.getQuantity(),
						Integer.valueOf(this.textField.getText()), this.item.getId(), this.expiration,
						System.currentTimeMillis());
				this.mc.thePlayer.sendQueue.addToSendQueue(new PacketServerHDV(AuctionAction.ADDITEM, this.item));

			} else {

				messageError = Lang.priceError;
				messageErrorTime = System.currentTimeMillis();
				return;

			}

			this.mc.displayGuiScreen(null);
		}
	}

	public void drawScreen(int mouseX, int mouseY, float partialTick) {

		this.drawAuctionBuyItem(Lang.guiAuctionSell);

		this.textField.drawTextBox();

		drawCenteredString(mc.fontRenderer, messageError, this.width / 2 + 30, this.height / 2 + 50, 1);

		if (messageErrorTime != 0 && Math.abs(System.currentTimeMillis() - messageErrorTime) >= 5000) {

			messageError = "";
			messageErrorTime = 0;

		}
		
		drawCenteredString(mc.fontRenderer, "       §f" + this.item.getItem().stackSize, this.width / 2 + 10,
				this.height / 2 - 20, 1);
		
		RenderHelper.enableStandardItemLighting();
		drawItemInToScreen(this.item.getItem(), this.width / 2 - 10, this.height / 2 - 30, 1, false);
		RenderHelper.disableStandardItemLighting();
		
		d(expiration == 3 ? -100 : expiration == 6 ? -25 : 50);
		
		super.drawScreen(mouseX, mouseY, partialTick);
		
		if (mouseX > this.width / 2 - 20 && mouseX < this.width / 2 + 20 && mouseY > this.height / 2 - 50
				&& mouseY < this.height / 2 - 10)
			func_146285_a(this.item.getItem(), mouseX, mouseY, item);
	}

	private void d(int z) {
		drawRectangle(this.width / 2 + z, this.height / 2 + 15, this.width / 2 + z + 50, this.height / 2 + 15 + 20,
				new Color(255, 180, 0).getRGB());
	}

	public void updateScreen() {

		if (this.textField != null)
			this.textField.updateCursorCounter();
	}

	private final char[] chars = { 'a', 'z', 'r', 'e', 't', 'y', 'u', 'i', 'o', 'p', 'q', 's', 'd', 'f', 'g', 'h', 'j',
			'k', 'l', 'm', 'w', 'c', 'v', 'b', 'n', 'x' };

	private boolean c(char d) {
		for (char c : chars)
			if (c == d)
				return true;
		return false;
	}

	protected void keyTyped(char p_73869_1_, int p_73869_2_) {

		if (this.textField != null) {

			if (c(p_73869_1_))
				return;

			int how = 0;
			try {
				how = Integer.valueOf(this.textField.getText());
			} catch (NumberFormatException e) {
			}

			if (how > 1000000)
				this.textField.setText(1000000 + "");
			else if (this.textField.isFocused())
				this.textField.textboxKeyTyped(p_73869_1_, p_73869_2_);

		}
	}

	protected void mouseClicked(int p_73864_1_, int p_73864_2_, int p_73864_3_) {

		super.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);

		if (this.textField != null)
			this.textField.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
	}
}
