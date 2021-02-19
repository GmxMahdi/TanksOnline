package me.tankgame.network.paquet.game;

import me.tankgame.game.player.Tank;

public class PaquetUpdatePlayer {

	public int lobbyId;
	public int userId;
	public Tank tank;
	
	public PaquetUpdatePlayer() {}
	public PaquetUpdatePlayer(int lobbyId, int userId, Tank tank) {
		this.lobbyId = lobbyId;
		this.userId = userId;
		this.tank = tank;
	}
}
