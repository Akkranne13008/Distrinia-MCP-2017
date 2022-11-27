package fr.maxlego08.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.maxlego08.shop.datas.PlayerItemData;
import fr.maxlego08.shop.datas.ShopData;
import fr.maxlego08.shop.guis.GuiShopBuyItem;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class ShopManager {

	private static Map<ShopCategory, List<ShopData>> shops = new HashMap();
	private static PlayerItemData item;
	
	private static double money;
	
	private static final Logger logger = LogManager.getLogger();
	
	public Map<ShopCategory, List<ShopData>> getShops() {
		return shops;
	}
	
	public static List<ShopData> getItems(ShopCategory c){
		return shops.get(c);
	}
	
	public static void registerItems(){
		
		/* 
		 * Constructeur
		 * 
		 * ShopCategory
		 * ShopData
		 *   Item / Block
		 *   Data
		 *   SellPrice -> set 0 for no sell
		 *   BuyPrice -> set 0 fo no buy
		 * 
		 * */
		
		/* Minerais */
		
		addItem(ShopCategory.MINERAL, new ShopData(Items.coal, 0, 55555555555555550.15, 0.5));
		addItem(ShopCategory.MINERAL, new ShopData(Items.dye, 4, 0.50, 5));
		addItem(ShopCategory.MINERAL, new ShopData(Items.iron_ingot, 0, 0.7, 5));
		addItem(ShopCategory.MINERAL, new ShopData(Items.gold_ingot, 0, 0.25, 35));
		addItem(ShopCategory.MINERAL, new ShopData(Items.diamond, 0, 2, 200));
		addItem(ShopCategory.MINERAL, new ShopData(Items.emerald, 0, 5, 500));
		addItem(ShopCategory.MINERAL, new ShopData(Items.emerald, 0, 1, 600));
		addItem(ShopCategory.MINERAL, new ShopData(Items.diamond, 0, 1, 800));
		addItem(ShopCategory.MINERAL, new ShopData(Items.apple, 0, 1, 3000));

		
		/* Farm */
		
		addItem(ShopCategory.FARM, new ShopData(Items.reeds, 50, 0.6, 8));
		addItem(ShopCategory.FARM, new ShopData(Blocks.pumpkin, 0, 2, 20));
		addItem(ShopCategory.FARM, new ShopData(Items.melon, 0, 0.5, 6));
		addItem(ShopCategory.FARM, new ShopData(Items.carrot, 0, 0.25, 1));
		addItem(ShopCategory.FARM, new ShopData(Blocks.cactus, 0, 0.6, 12));
		
		/* Rare */
		
	//	addItem(ShopCategory.RARE, new ShopData(Blocks.sponge, 0, 0, 3000000));
	//	addItem(ShopCategory.RARE, new ShopData(Items.spawn_egg, 50, 0, 30000));
	//	addItem(ShopCategory.RARE, new ShopData(Items.ender_pearl, 0, 0, 300));
		
		/* Ingreditens */
		
		addItem(ShopCategory.INGREDIENT, new ShopData(Items.ghast_tear, 0, 5, 20));
		addItem(ShopCategory.INGREDIENT, new ShopData(Items.glowstone_dust, 0, 0.25, 3));
		addItem(ShopCategory.INGREDIENT, new ShopData(Items.gunpowder, 0, 5, 7.5));
		addItem(ShopCategory.INGREDIENT, new ShopData(Items.nether_wart, 0, 1, 5));
		addItem(ShopCategory.INGREDIENT, new ShopData(Items.spider_eye, 0, 1, 5));
		addItem(ShopCategory.INGREDIENT, new ShopData(Items.fermented_spider_eye, 0, 2.5, 7.5));
		addItem(ShopCategory.INGREDIENT, new ShopData(Items.slime_ball, 0, 0.5, 10));
		addItem(ShopCategory.INGREDIENT, new ShopData(Items.brewing_stand, 0, 0.5, 12));
		addItem(ShopCategory.INGREDIENT, new ShopData(Items.magma_cream, 0, 0, 10));
		addItem(ShopCategory.INGREDIENT, new ShopData(Items.speckled_melon, 0, 0, 10));
		addItem(ShopCategory.INGREDIENT, new ShopData(Items.blaze_powder, 0, 0, 5));
		addItem(ShopCategory.INGREDIENT, new ShopData(Items.blaze_rod, 0, 0, 10));
	
		
		/* Loots */
		
		addItem(ShopCategory.LOOT, new ShopData(Items.arrow, 0, 0.5, 0));
		addItem(ShopCategory.LOOT, new ShopData(Items.bone, 0, 0.5, 0));
		addItem(ShopCategory.LOOT, new ShopData(Items.rotten_flesh, 0, 0.5, 0));
		addItem(ShopCategory.LOOT, new ShopData(Items.string, 0, 0.5, 0));
		
		/* Potions */
		
		addItem(ShopCategory.POTION, new ShopData(Items.potionitem, 16421, 0, 15));
		addItem(ShopCategory.POTION, new ShopData(Items.potionitem, 8259, 0, 15));
		addItem(ShopCategory.POTION, new ShopData(Items.potionitem, 8258, 0, 15));
		addItem(ShopCategory.POTION, new ShopData(Items.potionitem, 8201, 0, 15));
		
		
		/* RedStone SELL BUY*/   
		addItem(ShopCategory.REDSTONE, new ShopData(Items.redstone, 0, 0.02, 0.5));
		addItem(ShopCategory.REDSTONE, new ShopData(Blocks.tripwire_hook, 0, 0.5, 8));
		addItem(ShopCategory.REDSTONE, new ShopData(Blocks.lever, 0, 0.3, 5));
		addItem(ShopCategory.REDSTONE, new ShopData(Blocks.redstone_torch, 0, 0.1, 2));
		addItem(ShopCategory.REDSTONE, new ShopData(Blocks.piston, 0, 2, 10));
		addItem(ShopCategory.REDSTONE, new ShopData(Blocks.sticky_piston, 0, 3, 30));
		addItem(ShopCategory.REDSTONE, new ShopData(Blocks.dropper, 0, 2, 5));
		addItem(ShopCategory.REDSTONE, new ShopData(Blocks.dispenser, 0, 1, 10));
		addItem(ShopCategory.REDSTONE, new ShopData(Blocks.redstone_lamp, 0, 1, 15));
		addItem(ShopCategory.REDSTONE, new ShopData(Blocks.redstone_block, 0, 0.5, 2));
		addItem(ShopCategory.REDSTONE, new ShopData(Items.comparator, 0, 1.5, 5));
		addItem(ShopCategory.REDSTONE, new ShopData(Items.repeater, 0, 1.5, 5));
		
		logger.info("Nombre d'item dans le shop: " + shops.size());
	}
	
	private static void addItem(ShopCategory category, ShopData data){
		List<ShopData> d = new ArrayList();
		if (shops.containsKey(category)){
			d = shops.get(category);
		}
		d.add(data);
		shops.put(category, d);
	}
	
	public static int getMaxPage(ShopCategory category){
		return getItems(category) != null ? (getItems(category).size()/12) + 1 : 1;
	}
	
	public static void buyItem(ShopData data, ShopCategory shopCategory, int page){
		item = new PlayerItemData(data.getItem().getItem(), data.getData(), 1, data.getSellPrice(), data.getBuyPrice());
		Minecraft.getMinecraft().displayGuiScreen(new GuiShopBuyItem(item, shopCategory, page));
	}
	
	public static double getMoney() {
		return money;
	}
	
	public static void setMoney(double monedy) {
		money = monedy;
	}
	
}
