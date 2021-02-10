package me.tankgame.game.lobby;

import java.util.Hashtable;



public class Lobby {

	private int userIdHost;
	private String lobbyName;
	
	private GameMode gamemode;
	private LobbyState lobbyState;
	private Hashtable<Integer, Player> players;
	
	public Lobby() {}
	public Lobby(int userIdHost, String lobbyName) {
		this.userIdHost = userIdHost;
		this.lobbyName = lobbyName;
		this.lobbyState = LobbyState.WAITING;
		this.gamemode = GameMode.FFA;
		
		players = new Hashtable<Integer, Player>();
	}
	
	public void addPlayer(Player player) {
		players.put(player.getUserId(), player);
	}
	
	public void removePlayer(Player player) {
		players.remove(player.getUserId());
	}
	
	public Hashtable<Integer, Player> getPlayers() {
		return this.players;
	}
	
	public int getUserIdHost() {
		return userIdHost;
	}

	public String getLobbyName() {
		return lobbyName;
	}
	
	public GameMode getGamemode() {
		return gamemode;
	}
	
	public LobbyState getLobbyState() {
		return lobbyState;
	}
	
	public String getPlayerCount() {
		return players.size() + "/4";
	}

	public void setUserIdHost(int userIdHost) {
		this.userIdHost = userIdHost;
	}

	public void setLobbyName(String lobbyName) {
		this.lobbyName = lobbyName;
	}

	public void setGamemode(GameMode gamemode) {
		this.gamemode = gamemode;
	}

	public void setLobbyState(LobbyState lobbyState) {
		this.lobbyState = lobbyState;
	}
}
