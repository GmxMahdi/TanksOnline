package me.tankgame.components;

import java.time.format.DateTimeFormatter;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import me.tankgame.game.lobby.Lobby;
import me.tankgame.network.ClientHandler;
import me.tankgame.network.NetManager;
import me.tankgame.network.paquet.lobby.PaquetMessage;

import javax.swing.JTextField;

public class ChatComponent extends JPanel {
	
	private Lobby lobby;
	private TextFieldWithPrompt tfInput;
	private JTextArea txtChat;
	
	public ChatComponent(Lobby lobby) {
		this.lobby = lobby;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 285, 140);
		add(scrollPane);
		
		txtChat = new JTextArea();
		scrollPane.setViewportView(txtChat);
		
		tfInput = new TextFieldWithPrompt("Send messages here...");
		tfInput.setBounds(0, 151, 285, 20);
		add(tfInput);
		tfInput.setColumns(10);
		
		tfInput.addActionListener(e -> {
			sendMessage(tfInput.getText());
			tfInput.setText("");
		});
	}
	
	private void sendMessage(String message) {
		ClientHandler.send(new PaquetMessage(lobby.getUserIdHost(), NetManager.getPlayer().getUsername(), message));
	}
	
	public void insertMessage(String message) {
		txtChat.append(message);
	}
}
