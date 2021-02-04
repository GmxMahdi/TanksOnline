package me.tankgame.ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import me.tankgame.game.GameView;
import me.tankgame.game.TrainingMode;
import me.tankgame.main.Main;

import java.awt.Font;

public class MainMenu extends JPanel {
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	public MainMenu() {
		setLayout(null);
		
		JButton btnPlayOnline = new JButton("Play Online");
		btnPlayOnline.setBounds(10, 466, 110, 23);
		add(btnPlayOnline);
		btnPlayOnline.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Main.SwitchMenu(new LobbiesMenu());
			}
			
		});
		
		JButton btnTraining = new JButton("Training");
		btnTraining.setBounds(10, 432, 110, 23);
		add(btnTraining);
		btnTraining.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Main.SwitchMenu(new GameView());
			}
			
		});
		
		
		JLabel lblTitle = new JLabel("Tanks?!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblTitle.setBounds(46, 34, 168, 104);
		add(lblTitle);
		
		JPanel panel = new JPanel();
		panel.setBounds(352, 11, 238, 90);
		add(panel);
		panel.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(78, 28, 160, 20);
		panel.add(txtPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(0, 31, 67, 14);
		panel.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(149, 59, 89, 23);
		panel.add(btnLogin);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(78, 0, 160, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(0, 3, 67, 14);
		panel.add(lblUsername);
	}
}
