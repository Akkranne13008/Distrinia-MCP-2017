package fr.maxlego08;

import java.awt.Color;

public class Colors {
	
	private Integer[] textTransparent = {100,80,70,60,50,40,30,20,10,0,0,0};
	
	public static Color getRainbow(int time){
		switch (time) {
		case 0:
			return new Color(226, 226, 226);
		case 1:
			return new Color(60, 255, 60);
		case 2:
			return new Color(60, 255, 60);
		case 3:
			return new Color(16, 115, 191);
		case 4:
			return new Color(255, 230, 7);
		case 5:
			return new Color(180, 7, 255);
		}
		return new Color(180, 7, 255);
	}
	
	
	public static Color getRed(){
		return new Color(255, 60, 60);
	}
	
	public static Color getGreen(){
		return new Color(60, 255, 60);
	}
	
	public static Color getGray(){
		return new Color(50, 50, 50);
	}
	
	public static Color getGrayTransprent(){
		return new Color(50, 50, 50, 220);
	}
	
	public static Color getBlock(){
		return new Color(20, 20, 20, 200);
	}
	
	public static Color getWhite()
	{
		return new Color(200, 200, 200);
	}
	  
	public static Color getBlue()
	{
		return new Color(16, 115, 191);
	}
	
	public static Color getEchapColor(){
		return new Color(77, 63, 60);
	}
	
	public static Color getPurple(){
		return new Color(12, 6, 29);
	}
	
	public static Color getPurple2(){
		return new Color(12, 6, 10);
	}
	
	public static Color getSquarePass(){
		return new Color(26, 18, 13);
	}
	
	public static Color getYellow(){
		return new Color(217, 187, 0);
	}
	
	public static Color getOrange(){
		return new Color(217, 115, 0);
	}
	
	public static Color getPassBlue(){
		return new Color(0, 78, 95);
	}
	
	public static Color getPassBlue2(){
		return new Color(0, 81, 165);
	}
	
	public static Color getYellowTranparent(){
		return new Color(225, 228, 0, 200);	
	}
	
	public static Color getProgressBar(){
		return new Color(86, 18, 0);	
	}
	
	public static int getMainButton(){
		return new Color(255, 120, 254, 100).getRGB();
	}
	
	public static int getMainButtonBorder(){
		return new Color(255, 36, 254).getRGB();
	}
	
	public static int getTextColor(){
		return new Color(254, 0, 255).getRGB();
	}
	
	/*
	 * Color shop
	 * */
	
	public static int getBackgroundShop(){
	return new Color(255, 60, 60, 75).getRGB();
	}
	
	public static int getBlack(){	
		return new Color(60, 255, 60).getRGB();
	}
	
	public static int getShopOrange(){
		return new Color(60, 255, 60, 75).getRGB();
	}
	
	public static int getShopItemFont(){
		return new Color(60, 255, 60, 120).getRGB();
	}
	
	
}
