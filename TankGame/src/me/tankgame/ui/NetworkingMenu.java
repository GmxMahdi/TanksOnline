package me.tankgame.ui;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class NetworkingMenu extends JPanel {
	
	public abstract void handleNetworkResponse(Object o);

	public abstract void onloadSendNetworkRequests();
}
