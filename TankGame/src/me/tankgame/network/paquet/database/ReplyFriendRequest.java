package me.tankgame.network.paquet.database;

import me.tankgame.components.FriendStatus;

public class ReplyFriendRequest {

	public String userRequester;
	public String userApprover;
	public FriendStatus status;
	
	public ReplyFriendRequest() {
		
	}
	
	public ReplyFriendRequest(String userRequester, String userApprover, FriendStatus status) {
		this.userRequester = userRequester;
		this.userApprover = userApprover;
		this.status = status;
	}
}
