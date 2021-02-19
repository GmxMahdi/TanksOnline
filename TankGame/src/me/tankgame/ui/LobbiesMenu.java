package me.tankgame.ui;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import me.tankgame.components.LobbyListComponent;
import me.tankgame.game.lobby.Lobby;
import me.tankgame.network.ClientHandler;
import me.tankgame.network.NetManager;
import me.tankgame.network.paquet.lobby.CreateLobbyRequest;
import me.tankgame.network.paquet.lobby.JoinLobbyRequest;
import me.tankgame.network.paquet.lobby.PaquetGetLobbies;
import me.tankgame.network.paquet.lobby.PaquetJoinLobby;
public class LobbiesMenu extends NetworkingMenu {
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
				440,11, 150,100);
		lobbyListComponent.setBounds(10, 11, 200, 400);
		btnBack.setBounds(501, 466, 89, 23);
		
		add(btnBack);
		btnBack.addActionListener(e -> {
			Gui.SwitchMenu(new MainMenu());
		});
		
		btnCreateLobby.addActionListener(e -> {
			String defaultText = NetManager.getPlayer().getUsername() + "'s Lobby";
            String lobbyName = JOptionPane.showInputDialog(this, "Enter lobby name", "Create Lobby",JOptionPane.PLAIN_MESSAGE, null, null, defaultText).toString();
            if (lobbyName != null) {
            	ClientHandler.send(new CreateLobbyRequest(NetManager.getPlayer(), lobbyName));
            }
		});
		
		btnJoinLobby.addActionListener(e -> {
			Lobby lobby = lobbyListComponent.getSelectedLobby();
			if (lobby != null)
				ClientHandler.send(new JoinLobbyRequest(NetManager.getPlayer(), lobby.getUserIdHost()));
		});
	}

	@Override
	public void handleNetworkResponse(Object o) {
		if (o instanceof PaquetJoinLobby) {
			PaquetJoinLobby paquet = (PaquetJoinLobby)o;
			Gui.SwitchMenu(new LobbyMenu(paquet.lobby));
		}
		else if (o instanceof PaquetGetLobbies) {
			PaquetGetLobbies paquet = (PaquetGetLobbies)o;
			lobbyListComponent.populateLobbyList(paquet.lobbies);
		}
	}

	@Override
	public void onloadSendNetworkRequests() {
		lobbyListComponent.refreshLobbyList();
	}
}
