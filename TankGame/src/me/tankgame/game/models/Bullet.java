package me.tankgame.game.models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Bullet extends MovableEntity {

	
	public Bullet(float X, float Y) {
		super();
		this.X = X;
		this.Y = Y;
		this.width = 10;
		this.height = 10;
		this.speed = 5;
	}
	@Override
	public void update(ArrayList<Entity> entities) {
		collisionDetection(entities);
	}
	
	private boolean colX = false;
	private boolean colY = false;
	public void collisionDetection(ArrayList<Entity> entities) {
		colX = false;
		colY = false;
		
		for (Entity e: entities)
			if (e != this)
				isColliding(e);
		
		if (!colX) this.X += this.velX;
		if (!colY) this.Y += this.velY;
	}
	
	public void isColliding(Entity e) {
		// Horizontal displacement
		if (this.velX + this.X + this.width > e.getX() &&  this.getVelX() + this.X < e.getX() + e.getWidth() &&
			this.Y + this.height > e.getY() && this.Y < e.getY() + e.getHeight()) {
			this.velX = -this.velX;
			this.colX = true;
		}
		
		// Vertical displacement
		if (this.X + this.width > e.getX() &&  this.X < e.getX() + e.getWidth() &&
			this.velY + this.Y + this.height > e.getY() && this.velY + this.Y < e.getY() + e.getHeight()) {
			this.velY = -this.velY;
			this.colY = true;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.drawRect((int)this.X, (int)this.Y, this.width, this.height);
	}

}
