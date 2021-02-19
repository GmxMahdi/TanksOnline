package me.tankgame.network.paquet.database;

public class CreateAccountResponse {

	public boolean isValid;
	public String message;
	
	public CreateAccountResponse() {}
	
	public CreateAccountResponse(boolean isValid, String message) {
		this.isValid = isValid;
		this.message = message;
	} 
}
