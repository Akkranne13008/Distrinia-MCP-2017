package fr.maxlego08.zauction.gui.buttons;

import java.awt.Color;
import java.util.List;

import org.lwjgl.opengl.GL11;

import fr.maxlego08.zauction.util.AuctionItem;
import fr.maxlego08.zauction.util.Colors;
import fr.maxlego08.zauction.util.Lang;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Timer;

public class GuiAuctionButton extends GuiButton {

	private Minecraft mc = Minecraft.getMinecraft();
	private AuctionItem item;

	public GuiAuctionButton(int id, int x, int y, int w, int h, String s, AuctionItem itemHDV) {

		super(id, x, y, w, h, s);
		this.item = itemHDV;
	}

	public void drawRectangle(int posX, int posY, int maxPosX, int maxPosY, int color) {
		this.drawHorizontalLine(posX, maxPosX, posY, color);
		this.drawHorizontalLine(posX, maxPosX, maxPosY, color);
		this.drawVerticalLine(posX, posY, maxPosY, color);
		this.drawVerticalLine(maxPosX, posY, maxPosY, color);
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {

		if (this.enabled) {

			this.field_146123_n = (mouseX >= this.field_146128_h && mouseY >= this.field_146129_i
					&& mouseX < this.field_146128_h + this.field_146120_f
					&& mouseY < this.field_146129_i + this.field_146121_g);

			drawRect(this.field_146128_h, this.field_146129_i, this.field_146128_h + this.field_146120_f,
					this.field_146129_i + this.field_146121_g,
					this.item.getPlayerName().equals(this.mc.getSession().getUsername())
							? new Color(60, 250, 60, 50).getRGB() : new Color(140, 105, 60, 130).getRGB());

			drawRectangle(this.field_146128_h, this.field_146129_i, this.field_146128_h + this.field_146120_f,
					this.field_146129_i + this.field_146121_g, Colors.getAuctionOrange());

			drawCenteredString(mc.fontRenderer, "§6" + this.item.getPrice() + "$",
					this.field_146128_h + this.field_146120_f / 2 + 5, this.field_146129_i + 10, 1);

			RenderHelper.enableGUIStandardItemLighting();
			drawItemInToScreen(this.item.getItem(), this.field_146128_h + 5, this.field_146129_i + 4, 1,
					this.field_146123_n);
			RenderHelper.disableStandardItemLighting();

			drawCenteredString(mc.fontRenderer, "   §f" + this.item.getItem().stackSize, this.field_146128_h + 23,
					this.field_146129_i + 14, 1);
		}
	}

	public AuctionItem getItem() {

		return this.item;
	}

	public void drawHoverDescription(int mouseX, int mouseY) {
		if (this.field_146123_n)
			func_146285_a(this.getItem().getItem(), mouseX, mouseY);
	}

	public void func_146285_a(ItemStack i, int x, int y) {
		List list = i.getTooltip(this.mc.thePlayer, this.mc.gameSettings.advancedItemTooltips);

		Lang.lore.forEach(lore -> {
			list.add(lore
				.replace("%info%", this.getItem().getPlayerName().equals(this.mc.getSession().getUsername()) ? Lang.loreInfoPlayer : Lang.loreInfoBuy)
				.replace("%seller%", getItem().getPlayerName())
				.replace("%price%", getItem().getPrice()+"")
				.replace("%amount%", getItem().getItem().stackSize+"")
				.replace("%expired%", getFormatLongHoursSimple(Math.abs(System.currentTimeMillis() - (getItem().getExpiration() * 3600000 + item.getTime()))))
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
	
	protected void drawItemInToScreen(ItemStack is, int x, int y, float par3, boolean overlay) {

		if (is != null) {

			float an = (float) is.animationsToGo - par3;

			if (an > 0.0F) {

				GL11.glPushMatrix();
				float dec = 1.0F + an / 5.0F;
				GL11.glTranslatef((float) (x + 8), (float) (y + 12), 0.0F);
				GL11.glScalef(1.0F / dec, (dec + 1.0F) / 2.0F, 1.0F);
				GL11.glTranslatef((float) (-(x + 8)), (float) (-(y + 12)), 0.0F);
			}

			RenderHelper.disableStandardItemLighting();

			new RenderItem().renderItemAndEffectIntoGUI(Minecraft.getMinecraft().fontRenderer,
					Minecraft.getMinecraft().getTextureManager(), is, x, y);

			RenderHelper.enableGUIStandardItemLighting();

			if (an > 0.0F)
				GL11.glPopMatrix();
		}
	}

}
