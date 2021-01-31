package me.tankgame.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class MainMenu extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Image backgroundImage;
	 
	SpringLayout layout = new SpringLayout();
	
	JLabel title = new JLabel("Tanks?!");
	JButton btnTraining = new JButton("Training Mode");
	JButton btnPlayOnline = new JButton("Play Online");
	JButton btnSettings = new JButton("Settings");
	
	Font btnFont = new Font("Arial", Font.PLAIN, 20);
	
	public MainMenu() {

		try {
			backgroundImage = ImageIO.read(new File("C:\\Users\\D0_00\\Desktop\\bg_menu.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setLayout(layout);
		this.setBackground(Color.white);
		this.add(title);
		this.add(btnTraining);
		this.add(btnPlayOnline);
		this.add(btnSettings);
		
		btnTraining.setFont(btnFont);
		btnPlayOnline.setFont(btnFont);
		btnSettings.setFont(btnFont);
	
		// title
		layout.putConstraint(
				SpringLayout.NORTH, title, 
				10, SpringLayout.NORTH, this);
		layout.putConstraint(
				SpringLayout.WEST, title, 
				10, SpringLayout.WEST, this);
		
		// btnSettings
		layout.putConstraint(
				SpringLayout.SOUTH, btnSettings, 
				-10, SpringLayout.SOUTH, this);
		layout.putConstraint(
				SpringLayout.WEST, btnSettings, 
				10, SpringLayout.WEST, this);
		
		// btnPlayOnline
		layout.putConstraint(
				SpringLayout.SOUTH, btnPlayOnline, 
				-5, SpringLayout.NORTH, btnSettings);
		layout.putConstraint(
				SpringLayout.WEST, btnPlayOnline, 
				10, SpringLayout.WEST, this);
		
		// btnTraining
		layout.putConstraint(
				SpringLayout.SOUTH, btnTraining, 
				-5, SpringLayout.NORTH, btnPlayOnline);
		layout.putConstraint(
				SpringLayout.WEST, btnTraining, 
				10, SpringLayout.WEST, this);
		
		//Border border = BorderFactory.createLineBorder(Color.green, 3);
		title.setFont(new Font("Consolas", Font.PLAIN , 40));
		//title.setBorder(border);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
	}
}
