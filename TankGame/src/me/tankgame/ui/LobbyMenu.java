package me.tankgame.ui;


import me.tankgame.components.ChatComponent;
import me.tankgame.game.OnlineMode;
import me.tankgame.game.lobby.GameMode;
import me.tankgame.game.lobby.Lobby;
import me.tankgame.game.lobby.Player;
import me.tankgame.network.ClientHandler;
import me.tankgame.network.NetManager;
import me.tankgame.network.paquet.game.PaquetJoinGame;
import me.tankgame.network.paquet.game.PaquetStartGame;
import me.tankgame.network.paquet.lobby.DeleteLobbyRequest;
import me.tankgame.network.paquet.lobby.LeaveLobbyRequest;
import me.tankgame.network.paquet.lobby.PaquetLeaveLobby;
import me.tankgame.network.paquet.lobby.PaquetMessage;
import me.tankgame.network.paquet.lobby.PaquetSwitchGameMode;
import me.tankgame.network.paquet.lobby.PaquetUpdateLobby;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import me.tankgame.components.PlayerLobbyComponent;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class LobbyMenu extends NetworkingMenu {
	
	private final int LOBBY_SIZE = 4;
	private final String STRING_GAMEMODE_FFA = "Gamemode: Free-For-All";
	private final String STRING_GAMEMODE_TEAMS = "Gamemode: Teams";
	
	private Lobby lobby;
	private boolean isHost;
	private ChatComponent chatComponent;
	private PlayerLobbyComponent[] playerLabels = new PlayerLobbyComponent[4];
	private JButton btnStartMatch;
	private JLabel lblGamemode;
	
	public LobbyMenu(Lobby lobby) {
		this.lobby = lobby;
		
		for (int i = 0; i < LOBBY_SIZE; ++i)
			playerLabels[i] = new PlayerLobbyComponent(lobby);
		
		this.isHost = lobby.getUserIdHost() == NetManager.getPlayer().getUserId();

		this.setSize(Gui.WIDTH, Gui.HEIGHT);
		setLayout(null);
		
		chatComponent = new ChatComponent(lobby);
		chatComponent.setBounds(240, 289, 350, 200);
		add(chatComponent);
		
		JLabel lblLobbyName = new JLabel(lobby.getLobbyName());
		lblLobbyName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLobbyName.setBounds(10, 9, 443, 23);
		add(lblLobbyName);
		
		JButton btnLeaveLobby = new JButton("Leave Lobby");
		btnLeaveLobby.setBounds(463, 16, 127, 23);
		add(btnLeaveLobby);
		
		
		playerLabels[0].setBounds(10, 43, 580, 50);
		add(playerLabels[0]);
		

		playerLabels[1].setBounds(10, 104, 580, 50);
		add(playerLabels[1]);
		

		playerLabels[2].setBounds(10, 165, 580, 50);
		add(playerLabels[2]);
		

		playerLabels[3].setBounds(10, 226, 580, 50);
		add(playerLabels[3]);
		

		lblGamemode = new JLabel("GAMEMODE");
		lblGamemode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGamemode.setBounds(10, 289, 230, 20);
		add(lblGamemode);
		
		btnStartMatch = new JButton("Start Match");
		btnStartMatch.setBounds(10, 466, 121, 23);
		add(btnStartMatch);
		btnStartMatch.setVisible(false);


		if (this.isHost) {
			JRadioButton rbtnFFA = new JRadioButton("Free-For-All");
			rbtnFFA.setBounds(10, 316, 109, 23);
			add(rbtnFFA);
			
			JRadioButton rbtnTeams = new JRadioButton("Teams");
			rbtnTeams.setBounds(10, 342, 109, 23);
			add(rbtnTeams);
			
			ButtonGroup buttonGroup = new ButtonGroup();
			buttonGroup.add(rbtnFFA);
			buttonGroup.add(rbtnTeams);
			
			buttonGroup.setSelected(rbtnFFA.getModel(), true);
			
			rbtnFFA.addActionListener(e -> {
				ClientHandler.send(new PaquetSwitchGameMode(lobby.getUserIdHost(), GameMode.FFA));
			});
			
			rbtnTeams.addActionListener(e -> {
				ClientHandler.send(new PaquetSwitchGameMode(lobby.getUserIdHost(), GameMode.TEAM));
			});
			
			btnStartMatch.setVisible(true);
			btnStartMatch.addActionListener(e -> {
				ClientHandler.send(new PaquetStartGame(lobby.getUserIdHost()));
			});
		}
		
		
		btnLeaveLobby.addActionListener(e -> {
			if (isHost) {
				if (JOptionPane.showConfirmDialog(
						this, 
						"Are you sure you want to leave?\nOther players in the lobby will be kicked out.", 
						"Leave Lobby",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					ClientHandler.send(new DeleteLobbyRequest(NetManager.getPlayer().getUserId()));
				}
			}
			else ClientHandler.send(new LeaveLobbyRequest(NetManager.getPlayer(), lobby.getUserIdHost()));
		});
		
		refreshLobby();
	}
	
	public void refreshLobby() {
		ArrayList<Player> players = new ArrayList<Player>(lobby.getPlayers().values());
		int playerCount = players.size();
		for (int i = 0; i < players.size(); ++i)
			playerLabels[i].setPlayer(players.get(playerCount -i -1));
		for (int i = players.size(); i < 4; ++i)
			playerLabels[i].setPlayer(null);
		
		if (lobby.getGamemode() == GameMode.FFA)
			lblGamemode.setText(STRING_GAMEMODE_FFA);
		else
			lblGamemode.setText(STRING_GAMEMODE_TEAMS);
		
		if (isHost) {
			boolean enabled = true;
			if (lobby.getGamemode() == GameMode.FFA) {
				if (players.size() <= 1)
					enabled = false;
			}
			else {
				if (players.size() != 4) {
					enabled = false;
				}
			}
			
			btnStartMatch.setEnabled(enabled);
		}
	}

	@Override
	public void handleNetworkResponse(Object o) {
		if (o instanceof PaquetMessage) {
			PaquetMessage paquet = (PaquetMessage)o;
			chatComponent.insertMessage(paquet.getMessage());
		}
		if (o instanceof PaquetLeaveLobby) {
			PaquetLeaveLobby paquet = (PaquetLeaveLobby)o;
			Gui.SwitchMenu(new LobbiesMenu());
			if (paquet.message != null)
				Gui.showMessage(paquet.message);
		}
		if (o instanceof PaquetUpdateLobby) {
			PaquetUpdateLobby paquet = (PaquetUpdateLobby)o;
			this.lobby = paquet.lobby;
			refreshLobby();
		}
		if (o instanceof PaquetJoinGame) {
			Gui.SwitchMenu(new OnlineMode(lobby));
		}
	}

	@Override
	public void onloadSendNetworkRequests() {
		String message = "[" + NetManager.getPlayer().getUsername() + " Connected]";
		ClientHandler.send(new PaquetMessage(lobby.getUserIdHost(), "", message));
	}
}
