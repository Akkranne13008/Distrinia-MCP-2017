package fr.maxlego08.zauction.util;

import net.minecraft.item.ItemStack;

public class AuctionItem {
	
	private ItemStack item;
	private String playerName;
	private int quantity;
	private int price;
	private int id;
	private int expiration;
	private long time;
	
	public AuctionItem(ItemStack item, String playerName, int quantity, int price, int id, int expiration, long time) {
		
		this.item = item;
		this.playerName = playerName;
		this.quantity = quantity;
		this.price = price;
		this.id = id;
		this.expiration = expiration;
		this.time = time;
	}
	
	public ItemStack getItem() {
		
		return item;
	}

	public String getPlayerName() {
		
		return playerName;
	}

	public int getQuantity() {
		
		return quantity;
	}
	
	public int getPrice() {
		
		return price;
	}
	
	public int getId() {
		
		return id;
	}
	
	public int getExpiration() {
		
		return this.expiration;
	}
	
	public long getTime() {
		
		return this.time;
	}
}
