package me.tankgame.network.paquet.lobby;

import java.util.ArrayList;

import me.tankgame.game.lobby.Lobby;

public class PaquetGetLobbies {

	public ArrayList<Lobby> lobbies;
	
	public PaquetGetLobbies() {}
	
	public PaquetGetLobbies(ArrayList<Lobby> lobbies) {
		this.lobbies = lobbies;
	}
}
