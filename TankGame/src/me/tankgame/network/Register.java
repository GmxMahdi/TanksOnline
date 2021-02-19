package me.tankgame.network;

import java.awt.Color;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Hashtable;

import com.esotericsoftware.kryo.Kryo;

import me.tankgame.components.Friend;
import me.tankgame.components.FriendStatus;
import me.tankgame.game.lobby.*;
import me.tankgame.game.models.*;
import me.tankgame.game.player.*;
import me.tankgame.network.paquet.database.*;
import me.tankgame.network.paquet.game.*;
import me.tankgame.network.paquet.lobby.*;

public class Register {

	public static void register(Kryo k) {
		k.register(LoginRequest.class);
		k.register(LoginResponse.class);
		k.register(CreateAccountRequest.class);
		k.register(CreateAccountResponse.class);
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
		k.register(Color.class, new ColorSerializer());
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
		k.register(LeaveLobbyRequest.class);
		k.register(PaquetLeaveLobby.class);
		k.register(DeleteLobbyRequest.class);
		k.register(UpdateLobbyRequest.class);
		k.register(PaquetUpdateLobby.class);
		k.register(PaquetSwitchColor.class);
		k.register(PaquetSwitchGameMode.class);
		k.register(PaquetJoinGame.class);
		k.register(PaquetStartGame.class);
		k.register(PaquetUpdatePlayer.class);
		k.register(Entity.class);
		k.register(MovableEntity.class);
		k.register(Tank.class);
		k.register(Cursor.class);
		k.register(Map.class); // change design because this not suppose to be registered
		k.register(InvisibleBarrier.class);
		k.register(Crate.class);
	}
}
