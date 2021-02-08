package me.tankgame.network.paquet.database;

public class AddFriendRequest {

	public String requester;
	public String approver;
	
	public AddFriendRequest() {}
	
	public AddFriendRequest(String requester, String approver) {
		this.requester = requester;
		this.approver = approver;
	}
}
