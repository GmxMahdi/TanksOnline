package me.tankgame.components;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class LobbyListComponent extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JLabel lblTitle = new JLabel("Lobbies");
	JButton btnRefresh = new JButton("Refresh");
	JPanel refreshPanel = new JPanel();
	
	String[] columnNames = { "Lobby Name", "Players" };
	
	// Dummy data
	Object[][] data = {
			{"Stacey's Lobby", "1/4"},
			{"Bobby's Lobby", "3/4"},
			{"Tracer's Lobby", "2/4"},
	};
	JTable tableLobbies = new JTable(data, columnNames);
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
	}
}
