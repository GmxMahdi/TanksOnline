package me.tankgame.ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import me.tankgame.game.GameView;
import me.tankgame.network.NetManager;
import me.tankgame.network.paquet.database.AddFriendRequest;
import me.tankgame.network.paquet.database.AddFriendResponse;
import me.tankgame.network.paquet.database.FriendListResponse;
import me.tankgame.network.paquet.database.LoginResponse;
import me.tankgame.network.paquet.database.RefreshFriendListUpdate;
import me.tankgame.network.paquet.database.RemoveFriendResponse;
import me.tankgame.network.paquet.database.ReplyFriendResponse;

import java.awt.Font;
import java.awt.Color;
import me.tankgame.components.LoginComponent;
import me.tankgame.components.FriendListComponent;
import me.tankgame.components.TextFieldWithPrompt;

public class MainMenu extends NetworkingMenu {
	
	private LoginComponent loginComponent;
	private JPanel panelNotification;
	private JLabel lblNotification;
	private JButton btnPlayOnline;
	private FriendListComponent friendListComponent;
	
	public MainMenu() {
		setLayout(null);
		
		btnPlayOnline = new JButton("Play Online");
		btnPlayOnline.setEnabled(false);
		btnPlayOnline.setBounds(10, 466, 110, 23);
		add(btnPlayOnline);
		btnPlayOnline.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Gui.SwitchMenu(new LobbiesMenu());
			}
			
		});
		
		JButton btnTraining = new JButton("Training");
		btnTraining.setBounds(10, 432, 110, 23);
		add(btnTraining);
		btnTraining.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Gui.SwitchMenu(new GameView());
			}
			
		});
		
		
		JLabel lblTitle = new JLabel("Tanks?!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblTitle.setBounds(46, 34, 168, 104);
		add(lblTitle);
		
		panelNotification = new JPanel();
		panelNotification.setBounds(10, 11, 206, 48);
		panelNotification.setVisible(false);
		add(panelNotification);
		panelNotification.setLayout(null);
		
		lblNotification = new JLabel("Connected as ?????");
		lblNotification.setForeground(Color.GREEN);
		lblNotification.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotification.setBounds(0, 0, 196, 14);
		panelNotification.add(lblNotification);
		
		loginComponent = new LoginComponent();
		loginComponent.setBounds(352, 11, 238, 111);
		add(loginComponent);
		
		friendListComponent = new FriendListComponent();
		friendListComponent.setBounds(422, 167, 168, 322);
		friendListComponent.setVisible(false);
		add(friendListComponent);
		
		if(NetManager.getPlayer().getUserId() != -1)
			setupConnectedMenu();
	}
	
	public void setupConnectedMenu() {
		loginComponent.setVisible(false);
		panelNotification.setVisible(true);
		btnPlayOnline.setEnabled(true);
		friendListComponent.setVisible(true);
		friendListComponent.refreshFriendList();
		lblNotification.setText("Connected as " + NetManager.getPlayer().getUserId() + "-" + NetManager.getPlayer().getUsername());
	}

	@Override
	public void handleNetworkResponse(Object o) {
		if (o instanceof LoginResponse)
		{
			LoginResponse re = (LoginResponse)o;
			loginComponent.validateLogin(re.isLoginValid);
			if (re.isLoginValid)  {
				NetManager.setPlayer(re.player);
				setupConnectedMenu();
			}

		}
		else if (o instanceof FriendListResponse) {
			FriendListResponse flr = (FriendListResponse)o;
			friendListComponent.populateFriendList(flr.friendList);
		}
		else if (o instanceof AddFriendResponse) {
			AddFriendResponse adr = (AddFriendResponse)o;
			if(adr.isValid) friendListComponent.refreshFriendList();
			else Gui.ShowWarning("Could not add friend \"" + adr.username +"\"");
		}
		else if (o instanceof RemoveFriendResponse) {
			friendListComponent.refreshFriendList();
		}
		else if (o instanceof ReplyFriendResponse) {
			friendListComponent.refreshFriendList();
		}
		else if (o instanceof RefreshFriendListUpdate) {
			RefreshFriendListUpdate rflu = (RefreshFriendListUpdate)o;
			friendListComponent.populateFriendList(rflu.friendList);
		}
	}

	@Override
	public void onloadSendNetworkRequests() {
		if(NetManager.getPlayer().getUserId() != -1)
			friendListComponent.refreshFriendList();
	}
}
