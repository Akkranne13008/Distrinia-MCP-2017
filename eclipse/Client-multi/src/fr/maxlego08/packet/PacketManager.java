package fr.maxlego08.packet;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.maxlego08.shop.datas.PlayerItemData;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C17PacketCustomPayload;

public class PacketManager {

	
    public static void sendShopBuyPacket(PlayerItemData data) {
        
    	Gson gson = new GsonBuilder().create();
    	Packet packet;
    	
    	
	    Map<String, String> informations = new HashMap<String, String>();
	        
	    informations.put("itemId", Item.getIdFromItem(data.getItem())+"");
	    informations.put("itemData", data.getData()+"");
	    informations.put("how", data.getHow()+"");
	    informations.put("defaultPrice", data.getBuyPrice()+"");
	        
	    packet = (Packet)new C17PacketCustomPayload("zShop|ShopBuy", gson.toJson((Object)informations).getBytes(Charsets.UTF_8));
	    Minecraft.getMinecraft().getNetHandler().addToSendQueue(packet);
    }
    
    public static void sendShopSellPacket(PlayerItemData data) {
    	
    	Gson gson = new GsonBuilder().create();
    	Packet packet;
    	
    	Map<String, String> informations = new HashMap<String, String>();
    	
    	informations.put("itemId", Item.getIdFromItem(data.getItem())+"");
    	informations.put("defaultPrice", data.getSellPrice()+"");
    	informations.put("itemData", data.getData()+"");
    	
    	packet = (Packet)new C17PacketCustomPayload("zShop|ShopSell", gson.toJson((Object)informations).getBytes(Charsets.UTF_8));
    	Minecraft.getMinecraft().getNetHandler().addToSendQueue(packet);
    }
	
}
