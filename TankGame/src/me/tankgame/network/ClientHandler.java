package me.tankgame.network;

import java.io.IOException;


import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import me.tankgame.network.paquet.database.*;
import me.tankgame.ui.Gui;

public class ClientHandler extends Listener {
	static Client client;
	static int udpPort = 54555, tcpPort = 54777;
	
	// Will be changed when server is setup online
	public static String serverIp = "127.0.0.1";
	
	public static void start() {
		try {
			client = new Client();
			Register.register(client.getKryo());
			client.start();
			client.connect(5000, serverIp, tcpPort, udpPort);
			client.addListener(new ClientHandler());
			NetManager.setIsServerRunning(true);
		} catch (IOException e) {
			Gui.ShowWarning("The server is not running. You cannot play online.");
		}
	}
	
	public static void send(Object o) {
		client.sendTCP(o);
//		if (o instanceof LoginRequest) {
//			LoginRequest re = (LoginRequest)o;
//			client.sendTCP(re);
//		}
//		else if (o instanceof FriendListRequest) {
//			FriendListRequest flr = (FriendListRequest)o;
//			client.sendTCP(flr);
//		}
//		else if (o instanceof AddFriendRequest) {
//			AddFriendRequest adr = (AddFriendRequest)o;
//			client.sendTCP(adr);
//		}
//		else if (o instanceof RemoveFriendRequest) {
//			RemoveFriendRequest rfr = (RemoveFriendRequest)o;
//			client.sendTCP(rfr);
//		}
	}
	
	public void received(Connection c, Object o) {
		Gui.ReceiveNetworkResponse(o);
	}
	
	public static void close() {
		
	}
	
}
