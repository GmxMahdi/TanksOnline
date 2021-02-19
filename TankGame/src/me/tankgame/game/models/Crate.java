package me.tankgame.game.models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import me.tankgame.design.ICollideable;
import me.tankgame.game.player.Tank;

public class Crate extends Entity {
	
	public static final int WIDTH = 100;
	public static final int HEIGHT = 70;
	public Crate() {
		super(WIDTH, HEIGHT);
	}
	
	public Crate(float X, float Y) {
		super(X, Y, WIDTH, HEIGHT);
	}
	
	

	@Override
	public void draw(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.fillRect((int)this.X, (int)this.Y, this.width, this.height);
	}

	@Override
	public void update(ArrayList<Entity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resolveCollision(ICollideable collideable) {
		collideable.resolveCollision(this);	
	}

	@Override
	public void resolveCollision(Tank tank) {
		tank.resolveCollision(this);
	}

	@Override
	public void resolveCollision(Bullet bullet) {
		bullet.resolveCollision(this);
	}

	@Override
	public void resolveCollision(Crate crate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resolveCollision(InvisibleBarrier invisibleBarrier) {
		// TODO Auto-generated method stub
		
	}

}
