package me.tankgame.network.paquet.lobby;

import me.tankgame.game.lobby.Player;

public class LeaveLobbyRequest {

	public Player player;
	public int lobbyId;
	
	public LeaveLobbyRequest() {}
	
	public LeaveLobbyRequest(Player player, int lobbyId) {
		this.player = player;
		this.lobbyId = lobbyId;
	}
}
