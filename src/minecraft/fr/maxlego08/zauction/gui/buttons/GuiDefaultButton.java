package fr.maxlego08.zauction.gui.buttons;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.Timer;

public class GuiDefaultButton extends GuiButton {

	private int xMove;
	private Color defaultColor;
	private Color hoverColor;
	private Timer timer = new Timer(30F);
	private String downText;

	public GuiDefaultButton(int id, int x, int y, String s) {
		super(id, x, y, 200, 20, s);
	}

	public GuiDefaultButton(int id, int x, int y, int w, int h, String s) {

		super(id, x, y, w, h, s);
		this.xMove = 0;
		this.defaultColor = new Color(175, 150, 41);
		this.hoverColor = new Color(214, 200, 128);
	}

	public GuiDefaultButton(int id, int x, int y, int w, int h, String s, Color defaultColor, Color hoverColor) {

		super(id, x, y, w, h, s);
		this.xMove = 50;
		this.defaultColor = defaultColor;
		this.hoverColor = hoverColor;
	}

	public GuiDefaultButton(int id, int x, int y, int w, int h, String s, Color defaultColor, Color hoverColor,
			String downText) {

		super(id, x, y, w, h, s);
		this.xMove = 0;
		this.defaultColor = defaultColor;
		this.hoverColor = hoverColor;
		this.downText = downText;
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {

		if (this.enabled) {

			this.field_146123_n = (mouseX >= this.field_146128_h && mouseY >= this.field_146129_i
					&& mouseX < this.field_146128_h + this.field_146120_f
					&& mouseY < this.field_146129_i + this.field_146121_g);

			this.timer.updateTimer();

			for (int j = 0; j < this.timer.elapsedTicks; ++j) {

				if (!this.field_146123_n) {

					if (this.xMove > 0)
						xMove--;

				} else {

					if (this.xMove < this.field_146121_g)
						xMove++;
				}
			}

			drawRect(this.field_146128_h + 4, this.field_146129_i + 3,
					this.field_146128_h + 4 + this.field_146120_f - 6,
					this.field_146129_i + 3 + this.field_146121_g - 5,
					!this.field_146123_n ? this.defaultColor.getRGB() : this.hoverColor.getRGB());

			if (this.downText == null) {

				drawCenteredString(mc.fontRenderer, this.displayString, this.field_146128_h + this.field_146120_f / 2,
						this.field_146129_i + (this.field_146121_g - 8) / 2, new Color(255, 255, 255).getRGB());

			} else {

				drawCenteredString(mc.fontRenderer, this.displayString, this.field_146128_h + this.field_146120_f / 2,
						this.field_146129_i + (this.field_146121_g - 8) / 2 - 2, 1);
				drawCenteredString(mc.fontRenderer, this.downText, (this.field_146128_h + this.field_146120_f / 2) * 2,
						(this.field_146129_i + (this.field_146121_g - 8) / 2) * 2 + 14, 1);
			}
		}
	}

	public void setDownText(String text) {

		this.downText = text;
	}
}