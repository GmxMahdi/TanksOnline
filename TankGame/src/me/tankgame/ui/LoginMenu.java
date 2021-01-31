package me.tankgame.ui;


import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginMenu extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JPanel panelTop = new JPanel();
	JPanel panelBottom = new JPanel();
	
	JLabel lblLogin = new JLabel("Username");
	JLabel lblPassword = new JLabel("Password");
	
	JTextField txtLogin = new JTextField("", 20);
	JTextField txtPassword = new JTextField("", 20);
	
	public LoginMenu() {
		
		this.setLayout(new GridLayout(2,1));
		this.add(panelTop);
		this.add(panelBottom);
		
		JPanel card = new JPanel();
		panelTop.setLayout(new BorderLayout());
		panelTop.add(card, BorderLayout.PAGE_END);
		card.add(lblLogin);
		card.add(txtLogin);

		panelBottom.add(lblPassword);
		panelBottom.add(txtPassword);
		

	}
}
