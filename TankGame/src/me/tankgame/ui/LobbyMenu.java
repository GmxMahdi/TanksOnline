package me.tankgame.ui;

import javax.swing.JPanel;
import me.tankgame.components.ChatComponent;
import me.tankgame.game.lobby.Lobby;
import me.tankgame.network.ClientHandler;
import me.tankgame.network.NetManager;
import me.tankgame.network.paquet.lobby.PaquetGetLobbies;
import me.tankgame.network.paquet.lobby.PaquetMessage;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class LobbyMenu extends NetworkingMenu {
	
	private Lobby lobby;
	private ChatComponent chatComponent;
	public LobbyMenu(Lobby lobby) {
		this.lobby = lobby;

		this.setSize(Gui.WIDTH, Gui.HEIGHT);
		setLayout(null);
		
		chatComponent = new ChatComponent(lobby);
		chatComponent.setBounds(303, 316, 287, 173);
		add(chatComponent);
		
		JLabel lblLobbyName = new JLabel(lobby.getLobbyName());
		lblLobbyName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLobbyName.setBounds(10, 9, 443, 23);
		add(lblLobbyName);
		
		JButton btnNewButton = new JButton("Leave Lobby");
		btnNewButton.setBounds(463, 16, 127, 23);
		add(btnNewButton);
	}
	
	public void sendMessage(String message) {
		
	}

	@Override
	public void handleNetworkResponse(Object o) {
		if (o instanceof PaquetMessage) {
			PaquetMessage paquet = (PaquetMessage)o;
			chatComponent.insertMessage(paquet.getMessage());
		}
	}

	@Override
	public void onloadSendNetworkRequests() {
		String message = "[" + NetManager.getPlayer().getUsername() + " Connected]";
		ClientHandler.send(new PaquetMessage(lobby.getUserIdHost(), "", message));
	}
}
