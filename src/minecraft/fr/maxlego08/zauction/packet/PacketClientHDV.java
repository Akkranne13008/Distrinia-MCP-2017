package fr.maxlego08.zauction.packet;

import java.io.IOException;

import fr.maxlego08.zauction.AuctionManager;
import fr.maxlego08.zauction.gui.GuiAuction;
import fr.maxlego08.zauction.gui.GuiAuctionSell;
import fr.maxlego08.zauction.util.AuctionAction;
import fr.maxlego08.zauction.util.AuctionItem;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;

public class PacketClientHDV extends Packet {

	private AuctionAction action;
	private AuctionItem item;
	
	@Override
	public void readPacketData(PacketBuffer reader) throws IOException {
		
		this.action = AuctionAction.get(reader.readInt());
		
		if(this.action.equals(AuctionAction.REGISTERITEM) || this.action.equals(AuctionAction.ADDITEM)) {
			
			ItemStack item = reader.readItemStackFromBuffer();
			String playerName = reader.readStringFromBuffer(32767);
			int price = reader.readInt();
			int id = reader.readInt();
			int expiration = reader.readInt();
			long time = reader.readLong();
			
			this.item = new AuctionItem(item, playerName, 1, price, id, expiration, time);
		}
	}

	@Override
	public void writePacketData(PacketBuffer reader) throws IOException {
		
	}
	
	@Override
	public void processPacket(INetHandler handler) {
		
		switch(this.action) {
		
			case OPEN:
				Minecraft.getMinecraft().displayGuiScreen(new GuiAuction(AuctionManager.items, 1, ""));
				break;
				
			case CLEARITEMS:
				AuctionManager.clearItems();
				break;
		
			case REGISTERITEM:
				AuctionManager.addItem(this.item);
				break;
				
			case ADDITEM:
				Minecraft.getMinecraft().displayGuiScreen(new GuiAuctionSell(this.item));
	
			default:
				break;
		}
	}	
}
