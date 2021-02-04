package me.tankgame.game.models;

import java.util.ArrayList;

public abstract class MovableEntity extends Entity {
	
	protected float velX;
	protected float velY;
	protected float angle;
	protected float speed;
	
	
	public MovableEntity(float X, float Y, int width, int height) {
		super(X, Y, width, height);
		this.velX = 0;
		this.velY = 0;
		this.angle = 0;
		this.speed = 0;
	}
	
	public MovableEntity() {
		super();
		this.velX = 0;
		this.velY = 0;
		this.angle = 0;
	}

	public float getVelX() { return velX; }
	public float getVelY() { return velY; }
	public float getAngle() { return angle; }
	public float getSpeed() { return speed; }
	
	public void setVelX(float velX) { this.velX = velX; }
	public void setVelY(float velY) { this.velY = velY; }
	public void setAngle(float angle) { this.angle = angle; }
	public void setSpeed(float speed) { this.speed = speed; }
	
	
	public abstract void update(ArrayList<Entity> entities);
	
	
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
		if (this.velX + this.X + this.width > e.X &&  this.velX + this.X < e.X + e.width &&
			this.Y + this.height > e.Y && this.Y < e.Y + e.height) {
				// performing action
				if (velX > 0) this.X = e.X - this.width;
				if (velX < 0) this.X = e.X + e.width;
			this.colX = true;
		}
		
		// Vertical displacement
		if (this.X + this.width > e.X &&  this.X < e.X + e.width &&
			this.velY + this.Y + this.height > e.Y && this.velY + this.Y < e.Y + e.height) {
				// performing action
				if (velY > 0) this.Y = e.Y - this.height;
				if (velY < 0) this.Y = e.Y + e.height;
			this.colY = true;
		}
	}

}
