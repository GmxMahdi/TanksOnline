package me.tankgame.components;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import me.tankgame.network.ClientHandler;
import me.tankgame.network.paquet.database.CreateAccountRequest;
import me.tankgame.ui.Gui;

public class CreateAccountPopup {

	JTextField usernameField = new JTextField();
	JTextField passwordField = new JPasswordField();
	Object[] message = {
	    "Username:", usernameField,
	    "Password:", passwordField
	};
	
	public CreateAccountPopup() {
		
	}
	
	public void showPopup() {
		int option = JOptionPane.showConfirmDialog(null, message, "Create Account", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			if (validateInput()) {
				String username = usernameField.getText().toLowerCase();
				String password = new String(passwordField.getText());
				ClientHandler.send(new CreateAccountRequest(username, password));
			}
		}
	}
	
	private boolean validateInput() {
		String username = usernameField.getText();
		String password = new String(passwordField.getText());
		if (username.length() < 2) {
			Gui.showMessage("Username is too short (must be 2 characters long)");
			return false;
		}
		if (password.length() < 2) {
			Gui.showMessage("Password is too short (must be 2 characters long)");
			return false;
		}
		return true;
	}
}
