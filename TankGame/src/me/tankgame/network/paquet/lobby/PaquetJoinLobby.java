package me.tankgame.network.paquet.lobby;

import me.tankgame.game.lobby.Lobby;

public class PaquetJoinLobby {

	public Lobby lobby;
	
	public PaquetJoinLobby() {}
	
	public PaquetJoinLobby(Lobby lobby) {
		this.lobby = lobby;
	}
}
