package me.tankgame.network.paquet.lobby;

public class DeleteLobbyRequest {

	public int idUserHost;
	
	public DeleteLobbyRequest() {
		
	}
	
	public DeleteLobbyRequest(int idUserHost) {
		this.idUserHost = idUserHost;
	}
}
