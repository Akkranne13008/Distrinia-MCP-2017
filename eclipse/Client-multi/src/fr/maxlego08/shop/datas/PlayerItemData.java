package fr.maxlego08.shop.datas;

import net.minecraft.item.Item;

public class PlayerItemData {

	private final Item item;
	private final int data;
	private int how;
	private double sellPrice;
	private double buyPrice;
	
	
	public PlayerItemData(Item item, int data, int how,double sellPrice, double buyPrice) {
		super();
		this.item = item;
		this.data = data;
		this.how = how;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
	}

	public Item getItem() {
		return item;
	}


	public int getHow() {
		return how;
	}


	public double getSellPrice() {
		return sellPrice;
	}


	public void setHow(int how) {
		this.how = how;
	}


	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}


	public double getBuyPrice() {
		return buyPrice;
	}

	public int getData() {
		return data;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	
}
