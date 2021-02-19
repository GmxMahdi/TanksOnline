package me.tankgame.game.player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import me.tankgame.design.ICollideable;
import me.tankgame.game.models.Bullet;
import me.tankgame.game.models.Crate;
import me.tankgame.game.models.Entity;
import me.tankgame.game.models.InvisibleBarrier;

public class Cursor extends Entity {

	private final int SIZE = 10;
	private Color color;
	
	public Cursor() {
		this.width = 30;
		this.height = 30;
		color = Color.RED;
	}
	
	public Cursor(Color color) {
		this.width = 30;
		this.height = 30;
		this.color = color;
	}
	
	
	@Override
	public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillRect((int)this.X -SIZE, (int)this.Y-SIZE, SIZE, SIZE);
        g.fillRect((int)this.X +SIZE, (int)this.Y-SIZE, SIZE, SIZE);
        g.fillRect((int)this.X -SIZE, (int)this.Y+SIZE, SIZE, SIZE);
        g.fillRect((int)this.X +SIZE, (int)this.Y+SIZE, SIZE, SIZE);
	}
	
	public Color getColor() {return this.color; }
	public void setColor(Color color) {this.color = color;}

	@Override
	public void update(ArrayList<Entity> entities) {
	}

	@Override
	public void resolveCollision(ICollideable collideable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resolveCollision(Tank tank) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resolveCollision(Bullet bullet) {
		// TODO Auto-generated method stub
		
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
