package me.tankgame.ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import me.tankgame.game.GameView;
import me.tankgame.network.NetManager;
import me.tankgame.network.paquet.database.AddFriendResponse;
import me.tankgame.network.paquet.database.CreateAccountResponse;
import me.tankgame.network.paquet.database.FriendListResponse;
import me.tankgame.network.paquet.database.LoginResponse;
import me.tankgame.network.paquet.database.RefreshFriendListUpdate;
import me.tankgame.network.paquet.database.RemoveFriendResponse;
import me.tankgame.network.paquet.database.ReplyFriendResponse;

import java.awt.Font;
import java.awt.Color;
import me.tankgame.components.LoginComponent;
import me.tankgame.components.CreateAccountPopup;
import me.tankgame.components.FriendListComponent;

@SuppressWarnings("serial")
public class MainMenu extends NetworkingMenu {
	
	private LoginComponent loginComponent;
	private JPanel panelNotification;
	private JLabel lblNotification;
	private JButton btnPlayOnline;
	private FriendListComponent friendListComponent;
	private JButton btnCreateAccount;
	
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
		
		
		JLabel lblTitle = new JLabel("Tank Online (Client)");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblTitle.setBounds(0, 45, 351, 73);
		add(lblTitle);
		
		panelNotification = new JPanel();
		panelNotification.setBounds(10, 11, 206, 23);
		panelNotification.setVisible(false);
		add(panelNotification);
		panelNotification.setLayout(null);
		
		lblNotification = new JLabel("Connected as ?????");
		lblNotification.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNotification.setForeground(Color.GREEN);
		lblNotification.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotification.setBounds(0, 0, 196, 14);
		panelNotification.add(lblNotification);
		
		loginComponent = new LoginComponent();
		loginComponent.setBounds(352, 11, 238, 111);
		add(loginComponent);
		
		friendListComponent = new FriendListComponent();
		friendListComponent.setBounds(422, 236, 168, 253);
		friendListComponent.setVisible(false);
		add(friendListComponent);
		
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(475, 466, 115, 23);
		add(btnCreateAccount);
		
		
		btnCreateAccount.addActionListener(e -> {
			CreateAccountPopup cap = new CreateAccountPopup();
			cap.showPopup();
		});
		
		if(!NetManager.isServerRunning()) {
			loginComponent.setVisible(false);
			btnCreateAccount.setVisible(false);
		}
		
		if(NetManager.getPlayer().getUserId() != -1)
			setupConnectedMenu();
	}
	
	public void setupConnectedMenu() {
		loginComponent.setVisible(false);
		btnCreateAccount.setVisible(false);
		panelNotification.setVisible(true);
		btnPlayOnline.setEnabled(true);
		friendListComponent.setVisible(true);
		friendListComponent.refreshFriendList();
		lblNotification.setText("Connected as "+ NetManager.getPlayer().getUsername().toUpperCase());
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
		else if (o instanceof CreateAccountResponse) {
			CreateAccountResponse paquet = (CreateAccountResponse)o;
			Gui.showMessage(paquet.message);
		}
		else if (o instanceof FriendListResponse) {
			FriendListResponse flr = (FriendListResponse)o;
			friendListComponent.populateFriendList(flr.friendList);
		}
		else if (o instanceof AddFriendResponse) {
			AddFriendResponse adr = (AddFriendResponse)o;
			if(adr.isValid) friendListComponent.refreshFriendList();
			else Gui.showMessage("Could not add friend \"" + adr.username +"\"");
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
