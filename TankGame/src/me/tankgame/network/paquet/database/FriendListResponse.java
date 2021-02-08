package me.tankgame.network.paquet.database;

import java.util.ArrayList;

import me.tankgame.components.Friend;

public class FriendListResponse {

	public ArrayList<Friend> friendList;
	
	public FriendListResponse() {}
	
	public FriendListResponse(ArrayList<Friend> friendList) {
		this.friendList = friendList;
	}
}
