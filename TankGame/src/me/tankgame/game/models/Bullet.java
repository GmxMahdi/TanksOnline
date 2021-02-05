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
		this.speed = 3;
	}
	@Override
	public void update(ArrayList<Entity> entities) {
		collisionDetection(entities);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.drawRect((int)this.X, (int)this.Y, this.width, this.height);
	}

}
