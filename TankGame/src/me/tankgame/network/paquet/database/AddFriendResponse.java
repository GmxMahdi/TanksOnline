package me.tankgame.network.paquet.database;

public class AddFriendResponse {

	public String username;
	public boolean isValid;
	
	public AddFriendResponse() {}
	
	public AddFriendResponse(String username, boolean isValid) {
		this.username = username;
		this.isValid = isValid;
	}
}
