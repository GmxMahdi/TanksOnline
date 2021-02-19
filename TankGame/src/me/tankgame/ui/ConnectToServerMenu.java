package me.tankgame.ui;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import java.awt.BorderLayout;
import java.awt.Font;

public class ConnectToServerMenu extends NetworkingMenu {
	private static final long serialVersionUID = 2781840823207417912L;

	public ConnectToServerMenu() {
		this.setSize(Gui.WIDTH, Gui.HEIGHT);
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Connecting to server...");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.CENTER);
	}
	@Override
	public void handleNetworkResponse(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onloadSendNetworkRequests() {
		// TODO Auto-generated method stub
		
	}

}
