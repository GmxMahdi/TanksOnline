package me.tankgame.game.player;

import java.awt.Color;
import java.awt.Graphics2D;

import me.tankgame.game.models.Entity;

public class Cursor extends Entity {

	public Cursor() {
		this.width = 30;
		this.height = 30;
	}
	
	@Override
	public void draw(Graphics2D g) {
		

// Find a way to properly solve no-collision objects
//        g.setColor(Color.blue);
//        g.fillRect((int)this.X, (int)this.Y, this.width, this.height);
        
        g.setColor(Color.red);
        g.fillRect((int)this.X -10, (int)this.Y-10, 10, 10);
        g.fillRect((int)this.X +10, (int)this.Y-10, 10, 10);
        g.fillRect((int)this.X -10, (int)this.Y+10, 10, 10);
        g.fillRect((int)this.X +10, (int)this.Y+10, 10, 10);
	}
	
	
}
