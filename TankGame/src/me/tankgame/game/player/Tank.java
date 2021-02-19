package me.tankgame.game.player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import me.tankgame.design.ICollideable;
import me.tankgame.game.models.Bullet;
import me.tankgame.game.models.Crate;
import me.tankgame.game.models.Entity;
import me.tankgame.game.models.InvisibleBarrier;
import me.tankgame.game.models.Map;
import me.tankgame.game.models.MovableEntity;

public class Tank extends MovableEntity {
	
	private Color color;
	private Cursor cursor;
	
	private float barrelLength = 50;
	
	public Map map_reference;
	
	public Tank() {
		super();
	}
	
    public Tank(float X, float Y, Map map_reference) {
        this.X = X;
        this.Y = Y;
        this.width = 30;
        this.height = 30;
        this.speed = 5;
        this.color = Color.red;
        
        cursor = new Cursor();
        
        this.map_reference = map_reference;
    }
    
    private float getBarrelAngle() {
    	return (float)Math.atan2(this.cursor.getY() - this.getCenterY(), this.cursor.getX() - this.getCenterX());
    }
    
    public Color getColor() { return this.color; }
    
    public Cursor getCursor() { return this.cursor; }
    
    public void setColor(Color color) { 
    	this.color = color; 
    	this.cursor.setColor(color);
    }
   


    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.fillRect((int)this.X, (int)this.Y, width, height);
        
        // DRAW BARREL OF TANK
        double barrelAngle = getBarrelAngle();
        
        g.setColor(this.color);
        g.setStroke(new BasicStroke(5));
        g.drawLine((int)this.getCenterX(), (int)this.getCenterY(), 
        		(int)(this.getCenterX() + Math.cos(barrelAngle)*barrelLength), (int)(this.getCenterY() + Math.sin(barrelAngle)*barrelLength));
        cursor.draw(g);
    }

    public void shoot() {
    	double barrelAngle = getBarrelAngle();
    	int bulletX = (int)(this.getCenterX()+ Math.cos(barrelAngle)*barrelLength);
    	int bulletY = (int)(this.getCenterY() + Math.sin(barrelAngle)*barrelLength);
    	Bullet b = new Bullet(bulletX, bulletY, map_reference);
    	
        b.setVelX((float)Math.cos(barrelAngle)*b.getSpeed());
        b.setVelY((float)Math.sin(barrelAngle)*b.getSpeed());
        
        map_reference.addEntity(b);
    }

   public void update(ArrayList<Entity> entities) {
	   ArrayList<Entity> collidingEntites = this.collidingEntities(entities);
	   
	   for (Entity e : collidingEntites) {
		   if (e == this) continue;
		   resolveCollision(e);
	   }
	   
	   this.X += this.velX;
	   this.Y += this.velY;
    }

    public void keyDown(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                velY = -speed;
                break;
            case KeyEvent.VK_A:
                velX = -speed;
                break;
            case KeyEvent.VK_S:
                velY = speed;
                break;
            case KeyEvent.VK_D:
                velX = speed;
                break;
        }
    }

    public void keyUp(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                velY = 0;
                break;
            case KeyEvent.VK_A:
                velX = 0;
                break;
            case KeyEvent.VK_S:
                velY = 0;
                break;
            case KeyEvent.VK_D:
                velX = 0;
                break;
        }
    }

	@Override
	public void resolveCollision(ICollideable collideable) {
		collideable.resolveCollision(this);
	}

	@Override
	public void resolveCollision(Tank tank) {
		uncollide(tank);
	}

	@Override
	public void resolveCollision(Bullet bullet) {
		bullet.resolveCollision(this);
	}

	@Override
	public void resolveCollision(Crate crate) {
		uncollide(crate);
	}

	@Override
	public void resolveCollision(InvisibleBarrier invisibleBarrier) {
		uncollide(invisibleBarrier);
	}
}
