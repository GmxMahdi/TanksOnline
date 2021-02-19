package me.tankgame.game.models;

import java.awt.Graphics2D;
import java.util.ArrayList;

import me.tankgame.design.ICollideable;
import me.tankgame.game.player.Tank;

public class InvisibleBarrier extends Entity {

	public InvisibleBarrier(float X, float Y, int width, int height) {
		super(X, Y, width, height);
	}
	
	@Override
	public void draw(Graphics2D g) {
	}

	@Override
	public void update(ArrayList<Entity> entities) {
	}

	@Override
	public void resolveCollision(ICollideable icollideable) {}
	@Override
	public void resolveCollision(Tank tank) {
		tank.resolveCollision(this);
	}
	@Override
	public void resolveCollision(Bullet bullet) {
		bullet.resolveCollision(this);
	}
	@Override
	public void resolveCollision(Crate crate) {}
	@Override
	public void resolveCollision(InvisibleBarrier invisibleBarrier) {}

}
