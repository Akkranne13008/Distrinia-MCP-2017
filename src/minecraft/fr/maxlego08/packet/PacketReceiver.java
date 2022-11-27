package fr.maxlego08.packet;

import java.util.Map;

import com.google.common.base.Charsets;

import fr.maxlego08.shop.ShopManager;
import fr.maxlego08.shop.guis.GuiShopMain;
import net.minecraft.client.Minecraft;

public class PacketReceiver {

	public static void receivePacket(String channel, byte[] bytes){		
    	
    	if (channel.equals("zShop|Shop")){
    		
    		PacketDecoder packetDecoder = PacketDecoder.getInstance();
    		packetDecoder.setContent((Map<String, Object>) (packetDecoder.getGson().fromJson(new String(bytes, Charsets.UTF_8), packetDecoder.getMapType())));
    		Minecraft.getMinecraft().displayGuiScreen(new GuiShopMain());
    		
    	}else if (channel.equals("zShop|Money")){
    		
    		PacketDecoder packetDecoder = PacketDecoder.getInstance();
    		packetDecoder.setContent((Map<String, Object>) (packetDecoder.getGson().fromJson(new String(bytes, Charsets.UTF_8), packetDecoder.getMapType())));
    		
    		try{
    			double d = Double.parseDouble((String) packetDecoder.getDescriptions().get("money"));
    			ShopManager.setMoney(d);
    		}catch (Exception e) {
				e.printStackTrace();
			}
    	}
		
	}
	
}
