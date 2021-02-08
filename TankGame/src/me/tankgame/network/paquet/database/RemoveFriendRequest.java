package me.tankgame.network.paquet.database;

public class RemoveFriendRequest {

	public String userA;
	public String userB;
	
	
	public RemoveFriendRequest() {}
	
	public RemoveFriendRequest(String userA, String userB) {
		this.userA = userA;
		this.userB = userB;
	}
}
