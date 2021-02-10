package me.tankgame.network.paquet.lobby;

import me.tankgame.game.lobby.Player;

public class CreateLobbyRequest {
	public Player player;
	public String lobbyName;
	
	public CreateLobbyRequest() {}
	
	public CreateLobbyRequest(Player player, String lobbyName) {
		this.player = player;
		this.lobbyName = lobbyName;
	}
}
