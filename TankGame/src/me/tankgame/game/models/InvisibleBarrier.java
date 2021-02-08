package me.tankgame.game.models;

import java.awt.Graphics2D;

public class InvisibleBarrier extends Entity {

	public InvisibleBarrier(float X, float Y, int width, int height) {
		super(X, Y, width, height);
	}
	
	@Override
	public void draw(Graphics2D g) {
	}

}
