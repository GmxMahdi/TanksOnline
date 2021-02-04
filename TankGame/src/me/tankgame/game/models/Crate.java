package me.tankgame.game.models;

import java.awt.Color;
import java.awt.Graphics2D;

import me.tankgame.main.Main;

public class Crate extends Entity {
	
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
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

}
