package me.tankgame.network;

import java.awt.Color;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Hashtable;

import com.esotericsoftware.kryo.Kryo;

import me.tankgame.components.Friend;
import me.tankgame.components.FriendStatus;
import me.tankgame.game.lobby.GameMode;
import me.tankgame.game.lobby.Lobby;
import me.tankgame.game.lobby.LobbyState;
import me.tankgame.game.lobby.LocalTimeSerializer;
import me.tankgame.game.lobby.Player;
import me.tankgame.network.paquet.database.*;
import me.tankgame.network.paquet.lobby.CreateLobbyRequest;
import me.tankgame.network.paquet.lobby.JoinLobbyRequest;
import me.tankgame.network.paquet.lobby.PaquetGetLobbies;
import me.tankgame.network.paquet.lobby.PaquetJoinLobby;
import me.tankgame.network.paquet.lobby.PaquetMessage;

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
		k.register(RefreshFriendListUpdate.class);
		k.register(Player.class);
		k.register(Color.class);
		k.register(CreateLobbyRequest.class);
		k.register(PaquetJoinLobby.class);
		k.register(Lobby.class);
		k.register(GameMode.class);
		k.register(LobbyState.class);
		k.register(Hashtable.class);
		k.register(PaquetGetLobbies.class);
		k.register(LocalTime.class, new LocalTimeSerializer());
		k.register(PaquetMessage.class);
		k.register(JoinLobbyRequest.class);
	}
}
