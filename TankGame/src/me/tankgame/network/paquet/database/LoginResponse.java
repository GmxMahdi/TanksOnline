package me.tankgame.network.paquet.database;

public class LoginResponse {

	public boolean isLoginValid;
	public String username;

	public LoginResponse() {}
	public LoginResponse(boolean isLoginValid, String username) {
		this.isLoginValid = isLoginValid;
		this.username = username;
	}
}
