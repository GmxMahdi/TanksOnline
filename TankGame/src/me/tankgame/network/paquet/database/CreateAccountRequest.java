package me.tankgame.network.paquet.database;

public class CreateAccountRequest {

	public String username;
	public String password;
	
	public CreateAccountRequest() {}
	
	public CreateAccountRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
