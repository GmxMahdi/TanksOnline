package me.tankgame.network.paquet.database;

import java.util.ArrayList;

import me.tankgame.components.Friend;

public class RefreshFriendListUpdate {
	
	public ArrayList<Friend> friendList;
	
	public RefreshFriendListUpdate() {}
	
	public RefreshFriendListUpdate(ArrayList<Friend> friendList) {
		this.friendList = friendList;
	}
}
