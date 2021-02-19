package me.tankgame.network;

import java.io.IOException;


import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import me.tankgame.ui.Gui;
import me.tankgame.ui.MainMenu;

public class ClientHandler extends Listener {
	static Client client;
	static int udpPort = 54555, tcpPort = 54777;
	

	public static String serverIp = "127.0.0.1"; // local server
	//public static String serverIp = "18.224.20.97"; // online server
	
	public static void start() {
		try {
			client = new Client();
			Register.register(client.getKryo());
			client.start();
			client.connect(5000, serverIp, tcpPort, udpPort);
			client.addListener(new ClientHandler());
			NetManager.setIsServerRunning(true);
		} catch (IOException e) {
			Gui.showMessage("The server is not running. You cannot play online.");
		}
		Gui.SwitchMenu(new MainMenu());
	}
	
	public static void send(Object o) {
		client.sendTCP(o);
	}
	
	public void received(Connection c, Object o) {
		Gui.ReceiveNetworkResponse(o);
	}
	
	public static void close() {
		
	}
	
}
