package me.tankgame.components;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import me.tankgame.game.lobby.Lobby;
import me.tankgame.game.lobby.Player;
import me.tankgame.network.ClientHandler;
import me.tankgame.network.paquet.lobby.PaquetGetLobbies;


public class LobbyListComponent extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JLabel lblTitle = new JLabel("Lobbies");
	JButton btnRefresh = new JButton("Refresh");
	JPanel refreshPanel = new JPanel();
	
	
	JTable tableLobbies = new JTable();
	LobbyTableModel model = new LobbyTableModel();
	JScrollPane scrollPane = new JScrollPane(tableLobbies);
	


	
	public LobbyListComponent() {
		this.setLayout(new BorderLayout());
		this.add(lblTitle, BorderLayout.PAGE_START);
		this.add(scrollPane, BorderLayout.CENTER);
		this.add(refreshPanel, BorderLayout.PAGE_END);
		
		refreshPanel.setLayout(new BoxLayout(refreshPanel, BoxLayout.PAGE_AXIS));
		refreshPanel.add(btnRefresh);
		btnRefresh.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		tableLobbies.setSelectionModel(new ForcedListSelectionModel());
		tableLobbies.setModel(model);
		
		btnRefresh.addActionListener(e -> {
			refreshLobbyList();
		});
	}
	
	public void refreshLobbyList() {
		removeAll();
		ClientHandler.send(new PaquetGetLobbies());
	}
	
	public void removeAll() {
		model.removeAll();
	}
	
	public void populateLobbyList(ArrayList<Lobby> lobbies) {
		model.addAll(lobbies);
	}
	
	public Lobby getSelectedLobby() {
		return model.getLobby(tableLobbies.getSelectedRow());
	}
}
