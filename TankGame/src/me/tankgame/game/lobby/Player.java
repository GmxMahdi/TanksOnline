package me.tankgame.game.lobby;

import java.awt.Color;

public class Player {

	private int userId;
	private String username;
	private Color color;
	
	public Player() {
		this(-1, "n/a");
	}
	
	public Player(int userId, String username) {
		this.userId = userId;
		this.username = username;
	}

	public int getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}
	
	public Color getTankColor() {
		return color;
	}

	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setTankColor(Color tankColor) {
		this.color = tankColor;
	}
}