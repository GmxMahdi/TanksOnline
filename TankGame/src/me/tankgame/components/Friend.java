package me.tankgame.components;

public class Friend {

	public String username;
	public FriendStatus status;
	
	public Friend() {
		
	}
	
	public Friend(String username, FriendStatus status) {
		this.username = username;
		this.status = status;
	}
	
	public String toString() {
		String str = username;
		if (status == FriendStatus.PENDING) str += " (PENDING)";
		return str;
	}
}

