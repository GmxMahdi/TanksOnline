package me.tankgame.network.paquet.lobby;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PaquetMessage {

	int idLobby;
	String username;
	String text;
	LocalTime timeStamp;
	
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
	
	public String getMessage() {
		return "\n[" + 
				timeStamp.format(dtf) + "] " 
				+ username + ": " 
				+ text; 
	}
	
	public PaquetMessage() {
		this.username = "";
		this.text = "";
		this.idLobby = -1;
	}
	
	public PaquetMessage(int idLobby, String username, String text) {
		this.idLobby = idLobby;
		this.username = username;
		this.text = text;
	}
	
	public int getLobbyId() {
		return this.idLobby;
	}
	public void setLobbyId(int value) {
		this.idLobby = value;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public LocalTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalTime timeStamp) {
		this.timeStamp = timeStamp;
	}
}
