package me.tankgame.components;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import me.tankgame.network.ClientHandler;
import me.tankgame.network.paquet.database.LoginRequest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class LoginComponent extends JPanel {
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblNotification;
	public LoginComponent() {
		setLayout(null);
		this.setSize(238, 109);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(107, 0, 131, 20);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(107, 31, 131, 20);
		add(txtPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(0, 3, 97, 14);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(10, 34, 87, 14);
		add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(149, 62, 89, 23);
		add(btnLogin);
		
		lblNotification = new JLabel("");
		lblNotification.setForeground(Color.RED);
		lblNotification.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNotification.setBounds(10, 96, 228, 14);
		add(lblNotification);
		
		
		ActionListener e = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNotification.setText("");
				if (txtUsername.getText().isEmpty() || txtPassword.getPassword().length == 0)
				{
					lblNotification.setForeground(Color.ORANGE);
					lblNotification.setText("Fields cannot be empty.");	
				}
				else sendLoginRequest();
			}
			
		};
		
		btnLogin.addActionListener(e);
		txtPassword.addActionListener(e);
	}
	
	public void sendLoginRequest() {
		String username = txtUsername.getText().toLowerCase().trim();
		String password = new String(txtPassword.getPassword());
		ClientHandler.send(new LoginRequest(username, password));
	}
	
	public void validateLogin(Boolean isValid) {
		if (!isValid) {
			lblNotification.setForeground(Color.ORANGE);
			lblNotification.setText("Bad username/password");
		}
	}
}
