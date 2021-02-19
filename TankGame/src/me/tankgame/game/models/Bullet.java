package me.tankgame.game.models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import me.tankgame.design.ICollideable;
import me.tankgame.game.player.Tank;

public class Bullet extends MovableEntity {

	private int MAX_BOUNCE_COUNT = 5;
	private int bounces = 0;
	
	private Map map_reference; // another solution would be a boolean removed on entity

	public Bullet(float X, float Y, Map map_reference) {
		super();
		this.map_reference = map_reference;
		
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
	

	public void collisionDetection(ArrayList<Entity> entities) {
	   ArrayList<Entity> collidingEntites = this.collidingEntities(entities);
	   
	   for (Entity e : collidingEntites) {
		   if (e == this) continue;
		   resolveCollision(e);
	   }
	   this.X += this.velX;
	   this.Y += this.velY;
	}
	
	protected void bounce(Entity e) {
		// Horizontal displacement
		if (this.velX + this.X + this.width > e.getX() &&  this.getVelX() + this.X < e.getX() + e.getWidth() &&
			this.Y + this.height > e.getY() && this.Y < e.getY() + e.getHeight()) {
			this.velX = -this.velX;
			this.X += this.velX;
		}
		
		// Vertical displacement
		if (this.X + this.width > e.getX() &&  this.X < e.getX() + e.getWidth() &&
			this.velY + this.Y + this.height > e.getY() && this.velY + this.Y < e.getY() + e.getHeight()) {
			this.velY = -this.velY;
			this.Y += this.velY;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.drawRect((int)this.X, (int)this.Y, this.width, this.height);
	}
	
	private void bulletBounce(Entity e) {
		bounces += 1;
		bounce(e);
		
		if (bounces == MAX_BOUNCE_COUNT) {
			map_reference.addEntityToRemoveQueue(this);
		}
	}
	@Override
	public void resolveCollision(ICollideable collideable) {
		collideable.resolveCollision(this);
	}
	@Override
	public void resolveCollision(Tank tank) {
		bulletBounce(tank);
	}
	@Override
	public void resolveCollision(Bullet bullet) {
		bulletBounce(bullet);
	}
	@Override
	public void resolveCollision(Crate crate) {
		bulletBounce(crate);
	}
	@Override
	public void resolveCollision(InvisibleBarrier invisibleBarrier) {
		bulletBounce(invisibleBarrier);
	}

}
