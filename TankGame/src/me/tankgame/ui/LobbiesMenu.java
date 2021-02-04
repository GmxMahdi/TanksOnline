package me.tankgame.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import me.tankgame.components.LobbyListComponent;
import me.tankgame.game.GameView;
import me.tankgame.main.Main;

public class LobbiesMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	LobbyListComponent lobbyListComponent = new LobbyListComponent();
	
	JPanel panelBtns = new JPanel();
	JButton btnCreateLobby = new JButton("Create Lobby");
	JButton btnJoinLobby = new JButton("Join Lobby");
	private final JButton btnBack = new JButton("Back");
	
	public LobbiesMenu() {
		this.setLayout(null);
		this.add(lobbyListComponent);
		this.add(panelBtns);
		
		panelBtns.setLayout(new BoxLayout(panelBtns, BoxLayout.PAGE_AXIS));
		panelBtns.add(btnCreateLobby);
		panelBtns.add(Box.createRigidArea(new Dimension(5, 5)));
		panelBtns.add(btnJoinLobby);
		
		btnJoinLobby.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnCreateLobby.setAlignmentX(Component.RIGHT_ALIGNMENT);

		panelBtns.setBounds(
				430,11, 150,100);
		lobbyListComponent.setBounds(10, 11, 200, 400);
		btnBack.setBounds(481, 426, 89, 23);
		
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Main.SwitchMenu(new MainMenu());
			}
			
		});
	}
}
