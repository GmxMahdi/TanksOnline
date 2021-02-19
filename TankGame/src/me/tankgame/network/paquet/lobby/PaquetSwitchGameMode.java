package me.tankgame.network.paquet.lobby;

import me.tankgame.game.lobby.GameMode;

public class PaquetSwitchGameMode {

	public int lobbyId;
	public GameMode gamemode;
	
	public PaquetSwitchGameMode() {}
	
	public PaquetSwitchGameMode(int lobbyId, GameMode gamemode) {
		this.lobbyId = lobbyId;
		this.gamemode = gamemode;
	}
}
