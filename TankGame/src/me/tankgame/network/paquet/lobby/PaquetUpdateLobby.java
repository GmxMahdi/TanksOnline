package me.tankgame.network.paquet.lobby;

import me.tankgame.game.lobby.Lobby;

public class PaquetUpdateLobby {

	public Lobby lobby;
	
	public PaquetUpdateLobby() {}
	public PaquetUpdateLobby(Lobby lobby) {
		this.lobby = lobby;
	}
}
