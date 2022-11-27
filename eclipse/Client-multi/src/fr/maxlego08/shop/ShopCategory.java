package fr.maxlego08.shop;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public enum ShopCategory {

	FARM("Agriculture", Items.melon),
	MINERAL("Minerais", Items.apple),
	RARE("Pillage", Item.getItemFromBlock(Blocks.tnt)),
	INGREDIENT("Ingredients", Items.brewing_stand),
	LOOT("Loots", Items.skull),
	POTION("Potions", Items.potionitem),
	REDSTONE("Redstone", Items.redstone),
	BLOCKS("Blocks", Item.getItemFromBlock(Blocks.obsidian)),
	;
	
	private final String name;
	private final Item item;
	
	private ShopCategory(String name, Item item) {
		this.name = name;
		this.item = item;
	}
	
	public String getName() {
		return name;
	}
	
	public Item getItem() {
		return item;
	}
	
}
