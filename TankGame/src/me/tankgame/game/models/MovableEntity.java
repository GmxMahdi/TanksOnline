package me.tankgame.game.models;

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

}
