package me.tankgame.network;

public class User {
	

	private static boolean isConnected = false;
	private static String username;
	
	public User() {
		username = "";
	}
	
	
	public static String getUsername() {
		return username;
	}
	
	public static boolean isConnected() {
		return isConnected;
	}
	


	public static void setConnected(boolean isConnected) {
		User.isConnected = isConnected;
	}

	public static void setUsername(String username) {
		User.username = username;
	}

}
