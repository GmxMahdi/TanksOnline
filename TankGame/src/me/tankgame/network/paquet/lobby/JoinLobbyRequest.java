package me.tankgame.network.paquet.lobby;

import me.tankgame.game.lobby.Player;

public class JoinLobbyRequest {
	
	public Player player;
	public int lobbyId;
	
	public JoinLobbyRequest() {}
	
	public JoinLobbyRequest(Player player, int lobbyId) {
		this.player = player;
		this.lobbyId = lobbyId;
	}
}
