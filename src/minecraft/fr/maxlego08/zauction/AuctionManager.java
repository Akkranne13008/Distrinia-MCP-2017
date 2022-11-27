package fr.maxlego08.zauction;

import java.util.ArrayList;
import java.util.List;

import fr.maxlego08.zauction.util.AuctionItem;

public class AuctionManager {

	public static List<AuctionItem> items = new ArrayList<AuctionItem>();
	
	public static void clearItems() { 
		items.clear();
	}
	
	private static  boolean alreadyRegister = false;
	public synchronized static void addItem(AuctionItem item) {
		
		items.forEach(items -> {
			if (item.getId() == items.getId()) alreadyRegister = true;
		});
		if(!alreadyRegister){
			items.add(item);
		}
	}
}