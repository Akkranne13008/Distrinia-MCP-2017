package fr.maxlego08.zauction.util;

public enum AuctionAction {

	OPEN(0),
	CLEARITEMS(1),
	REGISTERITEM(2),
	RECUPITEM(3),
	BUYITEM(4),
	ADDITEM(5);
	
	private int id;	
	
	AuctionAction(int id) {
		
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public static AuctionAction get(int id) {
		for(AuctionAction a : AuctionAction.values()) if (a.getId() == id) return a;
		return null;
	}
	
}
