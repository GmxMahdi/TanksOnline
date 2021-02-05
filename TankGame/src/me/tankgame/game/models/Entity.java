package me.tankgame.game.models;

import java.awt.Graphics2D;

public abstract class Entity {

	protected float X;
	protected float Y;
	
	protected int width;
	protected int height;
	
	public Entity(float X, float Y, int width, int height) {
		this.X = X;
		this.Y = Y;
		this.width = width;
		this.height = height;
	}
	
	public Entity(int width, int height) {
		this(0, 0, width, height);
	}
	
	public Entity() {
		this(0, 0, 100, 100);
	}
	
	public abstract void draw(Graphics2D g);
	
	public float getX() { return X; }
	public float getY() { return Y; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	public float getCenterX() { return X + width/2; }
	public float getCenterY() { return Y + height/2; }
	
	public void setX(float x) { X = x; }
	public void setY(float y) { Y = y; }
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
}
