package fr.maxlego08.shop.datas;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ShopData {

	private final ItemStack item;
	private final boolean sell;
	private final boolean buy;
	private final int data;
	private double sellPrice;
	private double buyPrice;
	
	public ShopData(Item item, int data, double sellPrice, double buyPrice) {
		this.item = new ItemStack(item, 1, data);
		this.data = data;
		this.sell = sellPrice != 0;
		this.buy = buyPrice != 0;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
	}
	
	public ShopData(Block block, int data, double sellPrice, double buyPrice) {
		this.item = new ItemStack(Item.getItemFromBlock(block), 1, data);
		this.data = data;

		this.sell = sellPrice != 0;
		this.buy = buyPrice != 0;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
	}

	public ItemStack getItem() {
		return item;
	}

	public boolean isSell() {
		return sell;
	}

	public boolean isBuy() {
		return buy;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public double getBuyPrice() {
		return buyPrice;
	}
	
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	public int getData() {
		return data;
	}
	
}
