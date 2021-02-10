package me.tankgame.network.paquet.database;

import me.tankgame.game.lobby.Player;

public class LoginResponse {

	public boolean isLoginValid;
	public Player player;

	public LoginResponse() {}
	public LoginResponse(boolean isLoginValid, Player player) {
		this.isLoginValid = isLoginValid;
		this.player = player;
	}
}
