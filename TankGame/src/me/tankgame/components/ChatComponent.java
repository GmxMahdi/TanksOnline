package me.tankgame.components;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.DefaultCaret;

import me.tankgame.game.lobby.Lobby;
import me.tankgame.network.ClientHandler;
import me.tankgame.network.NetManager;
import me.tankgame.network.paquet.lobby.PaquetMessage;
import java.awt.Font;

@SuppressWarnings("serial")
public class ChatComponent extends JPanel {
	
	private Lobby lobby;
	private JScrollPane scrollPane;
	private TextFieldWithPrompt tfInput;
	private JTextArea txtChat;
	
	public ChatComponent(Lobby lobby) {
		this.lobby = lobby;
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 349, 167);
		add(scrollPane);
		
		txtChat = new JTextArea();
		txtChat.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scrollPane.setViewportView(txtChat);
		DefaultCaret caret = (DefaultCaret)txtChat.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		txtChat.setLineWrap(true);
		txtChat.setEditable(false);
		txtChat.append("[" + this.lobby.getLobbyName() + "]");
		
		tfInput = new TextFieldWithPrompt("Send messages here...");
		tfInput.setBounds(0, 171, 349, 27);
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
		txtChat.getCaret().setDot( Integer.MAX_VALUE );
	}
}
