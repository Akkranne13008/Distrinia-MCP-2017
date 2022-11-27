package fr.maxlego08.zauction.packet;

import java.io.IOException;

import fr.maxlego08.zauction.util.AuctionAction;
import fr.maxlego08.zauction.util.AuctionItem;
import net.minecraft.client.Minecraft;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;

public class PacketServerHDV extends Packet {

	private AuctionAction action;
	private AuctionItem item;
	
	public PacketServerHDV(AuctionAction action, AuctionItem item) {
		
		this.action = action;
		this.item = item;
	}
	
	@Override
	public void readPacketData(PacketBuffer reader) throws IOException {
		
	}

	@Override
	public void writePacketData(PacketBuffer reader) throws IOException {
		
		reader.writeStringToBuffer(Minecraft.getMinecraft().thePlayer.getCommandSenderName());
		reader.writeInt(this.action.getId());		
				
		reader.writeItemStackToBuffer(this.item.getItem());
		reader.writeStringToBuffer(this.item.getPlayerName());
		reader.writeInt(this.item.getPrice());
		reader.writeInt(this.item.getId());
		reader.writeInt(this.item.getExpiration());
		reader.writeLong(this.item.getTime());
	}

	@Override
	public void processPacket(INetHandler handler) {
		
	}
}