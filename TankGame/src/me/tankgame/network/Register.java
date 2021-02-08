package me.tankgame.network;

import java.util.ArrayList;

import com.esotericsoftware.kryo.Kryo;

import me.tankgame.components.Friend;
import me.tankgame.components.FriendStatus;
import me.tankgame.network.paquet.database.*;

public class Register {

	public static void register(Kryo k) {
		k.register(LoginRequest.class);
		k.register(LoginResponse.class);
		k.register(Friend.class);
		k.register(FriendStatus.class);
		k.register(FriendListRequest.class);
		k.register(FriendListResponse.class);
		k.register(ArrayList.class);
		k.register(AddFriendRequest.class);
		k.register(AddFriendResponse.class);
		k.register(RemoveFriendRequest.class);
		k.register(RemoveFriendResponse.class);
		k.register(ReplyFriendRequest.class);
		k.register(ReplyFriendResponse.class);
	}
}
