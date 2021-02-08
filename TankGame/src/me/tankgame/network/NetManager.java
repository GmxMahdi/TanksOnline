package me.tankgame.network;

public class NetManager {

	private static boolean isServerRunning = false;
	private static User user = new User();
	
	public static User getUser() {
		return user;
	}
	
	public static boolean isServerRunning() {
		return isServerRunning;
	}
	
	public static void setIsServerRunning(boolean value) {
		isServerRunning = value;
	}
}
