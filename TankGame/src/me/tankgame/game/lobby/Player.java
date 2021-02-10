package me.tankgame.game.lobby;

import java.awt.Color;

public class Player {

	private int userId;
	private String username;
	private Color tankColor;
	
	public Player() {
		this.userId = -1;
		this.username = "";
		this.tankColor = Color.RED;
	}
	
	public Player(int userId, String username) {
		this.userId = userId;
		this.username = username;
		this.tankColor = Color.RED;
	}

	public int getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}
	
	public Color getTankColor() {
		return tankColor;
	}

	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setTankColor(Color tankColor) {
		this.tankColor = tankColor;
	}
}
