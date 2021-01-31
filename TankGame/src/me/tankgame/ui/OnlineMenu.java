package me.tankgame.ui;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import me.tankgame.components.LobbyListComponent;

public class OnlineMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	LobbyListComponent lobbyListComponent = new LobbyListComponent();
	
	JButton btnCreateLobby = new JButton("Create Lobby");
	
	JPanel panelBtns = new JPanel();
	JButton btnJoinLobby = new JButton("Join Lobby");
	JButton btnBack = new JButton("Back");
	
	public OnlineMenu() {
		this.setLayout(null);
		this.add(lobbyListComponent);
		this.add(panelBtns);
		
		SpringLayout sprLayout = new SpringLayout(); 
		panelBtns.setLayout(sprLayout);
		panelBtns.add(btnCreateLobby);
		panelBtns.add(btnJoinLobby);
		
		sprLayout.putConstraint(
				SpringLayout.SOUTH, btnJoinLobby, 
				-10, SpringLayout.SOUTH, panelBtns);
		sprLayout.putConstraint(
				SpringLayout.EAST, btnJoinLobby, 
				0, SpringLayout.EAST, panelBtns);
		
		sprLayout.putConstraint(
				SpringLayout.SOUTH, btnCreateLobby, 
				-5, SpringLayout.NORTH, btnJoinLobby);
		sprLayout.putConstraint(
				SpringLayout.EAST, btnCreateLobby, 
				0, SpringLayout.EAST, panelBtns);
		
		panelBtns.setBounds(300,100, 200, 100);
		lobbyListComponent.setBounds(100, 10, 200, 400);
	}
}
