package me.tankgame.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginMenu extends JPanel {
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	
	public LoginMenu() {
		setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(173, 190, 69, 14);
		add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(252, 187, 130, 20);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(252, 218, 130, 20);
		add(txtPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(173, 215, 69, 14);
		add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(299, 249, 83, 23);
		add(btnLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(487, 426, 83, 23);
		add(btnBack);
	}
}
