package me.tankgame.network;

import me.tankgame.game.lobby.Player;

public class NetManager {

	private static boolean isServerRunning = false;
	private static boolean isInGame = false;
	private static Player player = new Player();
	
	public static Player getPlayer() {
		return player;
	}
	
	public static void setPlayer(Player player) {
		NetManager.player = player;
	}
	
	public static boolean isServerRunning() {
		return isServerRunning;
	}
	
	public static void setIsServerRunning(boolean value) {
		isServerRunning = value;
	}
}
