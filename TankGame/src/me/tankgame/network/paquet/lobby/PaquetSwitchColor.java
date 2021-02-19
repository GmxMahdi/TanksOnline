package me.tankgame.network.paquet.lobby;

import java.awt.Color;

public class PaquetSwitchColor {

	public int idLobby;
	public int idUser;
	public Color color;
	
	public PaquetSwitchColor() {
		
	}
	
	public PaquetSwitchColor(int idLobby, int idUser, Color color) {
		this.idLobby = idLobby;
		this.idUser = idUser;
		this.color = color;
	}
}
