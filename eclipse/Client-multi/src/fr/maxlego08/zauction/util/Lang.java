package fr.maxlego08.zauction.util;

import java.util.ArrayList;
import java.util.List;

public class Lang {

	public static String sellError = "§eVous devez choisir une heure d'expiration pour votre article.";
	public static String priceError = "§eVous devez mettre un numéro dans le prix";
	
	public static String guiAuction = "§6HDV §a↕ §1Télozia";
	public static String guiAuctionItem = "§6Mes ventes";
	public static String guiAuctionPage = "§fPage %page% / %maxpage%";
	public static String guiAuctionBuy = "§6Achat";
	public static String guiAuctionSell = "§6Vente";
	
	public static String back = "§fRetour";
	public static String sells = "Mes Ventes";
	public static String refresh = "Rafraîchir"; 
	public static String previous = "<<"; 
	public static String next = ">>"; 
	public static String sell = "Vente";
	public static String buy = "Achat";
	public static String price = "§7Prix§8: §2%price%$";
	public static String offer = "§7Offre de§8: §2%player%";
	
	public static List<String> lore = new ArrayList<>();
	
	public static String loreInfoPlayer = "Cliquez pour récupérer un article";
	public static String loreInfoBuy = "Cliquez pour acheter cet article";
	
	public static String format = "%02dh %02dm %02ds";
	
	static{
		lore.add("§7§m------------------------------");
		lore.add("§8[§6!§8] §e%info%");
		lore.add(" ");
		lore.add("  §6* §eVendeur§7: §6%seller%");
		lore.add("  §6* §ePrix§7: §6%price%$");
		lore.add("  §6* §eExpiré§7: §6%expired%");
		lore.add("§7§m------------------------------");
	}
	
}
