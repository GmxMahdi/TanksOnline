package me.tankgame.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TankLobbyCanvas extends JPanel {

	private Color color;
	
	private int WIDTH = 50, HEIGHT = 50;
	public TankLobbyCanvas() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setSize(WIDTH, HEIGHT);
		color = Color.GREEN;
	}
	
	public TankLobbyCanvas(Color color) {
		this.color = color;
	}
	
	public void setTankColor(Color color) {
		this.color = color;
		repaint();
		revalidate();
	}
	
	private int diameter = 10;
	private int padding = 10;
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		g.fillOval(padding, padding, diameter, diameter);
		g.fillOval(WIDTH - diameter -padding, padding, 10, 10);
		g.fillArc(15, 15, 20, 20, 180, 180);
	}
}
