package me.tankgame.network;

public class User {
	

	private static boolean isConnected = false;
	private static String username;
	
	public User() {
		username = "";
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public boolean isConnected() {
		return isConnected;
	}
	


	public void setConnected(boolean isConnected) {
		User.isConnected = isConnected;
	}

	public void setUsername(String username) {
		User.username = username;
	}

}
