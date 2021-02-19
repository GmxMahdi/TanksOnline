package me.tankgame.components;

import javax.swing.JPanel;

import me.tankgame.game.lobby.Lobby;
import me.tankgame.game.lobby.Player;
import me.tankgame.network.ClientHandler;
import me.tankgame.network.NetManager;
import me.tankgame.network.paquet.lobby.PaquetSwitchColor;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PlayerLobbyComponent extends JPanel {
	
	private final int MARGIN = 20;
	private JLabel lblUsername;
	private TankLobbyCanvas tankLobbyCanvas;
	
	private Lobby lobby;
	private Player player;
	
	private int index = 0;
	private Color[] colorList = {Color.RED, Color.GREEN, Color.CYAN, Color.PINK, Color.MAGENTA};
	
	private JPanel margin2;
	private JButton btnSwitchColor;
	
	public PlayerLobbyComponent(Lobby lobby) {
		this.lobby = lobby;
		this.setSize(500, 50);
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		tankLobbyCanvas = new TankLobbyCanvas();
		FlowLayout flowLayout = (FlowLayout) tankLobbyCanvas.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(tankLobbyCanvas);
		
		JPanel margin = new JPanel();
		margin.setBackground( new Color(0,0,0,0) ); // Invisible
		FlowLayout flowLayout_1 = (FlowLayout) margin.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		margin.setPreferredSize(new Dimension(MARGIN, MARGIN));
		add(margin);
		
		lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblUsername);
		
		margin2 = new JPanel();
		margin2.setBackground( new Color(0,0,0,0) ); // Invisible
		margin2.setPreferredSize(new Dimension(20, 20));
		add(margin2);
		
		btnSwitchColor = new JButton("Color");
		btnSwitchColor.setVisible(false);
		btnSwitchColor.addActionListener(e -> {
			switchColor();
		});
		add(btnSwitchColor);
	}
	
	private void switchColor() {
		index = (index + 1) % colorList.length;	
		PaquetSwitchColor paquet = new PaquetSwitchColor(
				lobby.getUserIdHost(), 
				NetManager.getPlayer().getUserId(), 
				colorList[index]);
		ClientHandler.send(paquet);
	}
	
	private void showPlayerCard(boolean show) {
		if (show) {
			lblUsername.setVisible(true);
			tankLobbyCanvas.setVisible(true);
			btnSwitchColor.setVisible(true);
			this.setEnabled(true);
			this.setBackground(Color.DARK_GRAY);
		}
		else {
			lblUsername.setVisible(false);
			tankLobbyCanvas.setVisible(false);
			btnSwitchColor.setVisible(false);
			this.setEnabled(false);
			this.setBackground(new Color(10, 10, 10 ));
		}
	}
	
	public void setPlayer(Player player) {
		this.player = player;
		if (player == null) {
			showPlayerCard(false);
		}
		else
		{
			showPlayerCard(true);
			if (player.getUserId() == NetManager.getPlayer().getUserId()) {
				btnSwitchColor.setVisible(true);
				setColorIndex(player.getTankColor());
			}
			else
				btnSwitchColor.setVisible(false);
			
			lblUsername.setText(player.getUsername());
			tankLobbyCanvas.setTankColor(player.getTankColor());
		}
	}
	
	private void setColorIndex(Color color) {
		for (int i = 0; i < colorList.length; ++i)
			if (colorList[i] == color) {
				index = i;
				break;
			}
	}
}
