package me.tankgame.game.player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import me.tankgame.game.models.Bullet;
import me.tankgame.game.models.Entity;
import me.tankgame.game.models.Map;
import me.tankgame.game.models.MovableEntity;

public class Tank extends MovableEntity {
	
	private Color color;
	private Cursor cursor;
	
	private float barrelLength = 50;
	
	private Map map;
	
	private boolean colX = false;
	private boolean colY = false;
	
    public Tank(float X, float Y, Map map) {
        this.X = X;
        this.Y = Y;
        this.width = 30;
        this.height = 30;
        this.speed = 5;
        this.color = Color.red;
        
        cursor = new Cursor();
        
        this.map = map;
    }
    
    private float getBarrelAngle() {
    	return (float)Math.atan2(this.cursor.getY() - this.getCenterY(), this.cursor.getX() - this.getCenterX());
    }

    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.fillRect((int)this.X, (int)this.Y, width, height);
        
        // DRAW BARREL OF TANK (set it to a function or something else
        double barrelAngle = getBarrelAngle();
        
        g.setColor(Color.red);
        g.setStroke(new BasicStroke(5));
        g.drawLine((int)this.getCenterX(), (int)this.getCenterY(), 
        		(int)(this.getCenterX() + Math.cos(barrelAngle)*barrelLength), (int)(this.getCenterY() + Math.sin(barrelAngle)*barrelLength));
        cursor.draw(g);
    }

    public void shoot() {
    	double barrelAngle = getBarrelAngle();
    	Bullet b = new Bullet((int)(this.getCenterX()+ Math.cos(barrelAngle)*barrelLength), (int)(this.getCenterY() + Math.sin(barrelAngle)*barrelLength));
        b.setVelX((float)Math.cos(barrelAngle)*b.getSpeed());
        b.setVelY((float)Math.sin(barrelAngle)*b.getSpeed());
        
        map.AddEntity(b);
        map.AddMovableEntity(b);
    }

   public void update(ArrayList<Entity> entities) {
	   collisionDetection(entities);
    }
   
	public void collisionDetection(ArrayList<Entity> entities) {
		colX = false;
		colY = false;
		
		for (Entity e: entities)
			if (e != this)
				isColliding(e);
		
		if (!colX) this.X += this.velX;
		if (!colY) this.Y += this.velY;
	}

	public void isColliding(Entity e) {
		// Horizontal displacement
		if (this.velX + this.X + this.width > e.getX() &&  this.getVelX() + this.X < e.getX() + e.getWidth() &&
			this.Y + this.height > e.getY() && this.Y < e.getY() + e.getHeight()) {
				// performing action
				if (velX > 0) this.X = e.getX() - this.width;
				if (velX < 0) this.X = e.getX() + e.getWidth();
			this.colX = true;
		}
		
		// Vertical displacement
		if (this.X + this.width > e.getX() &&  this.X < e.getX() + e.getWidth() &&
			this.velY + this.Y + this.height > e.getY() && this.velY + this.Y < e.getY() + e.getHeight()) {
				// performing action
				if (velY > 0) this.Y = e.getY() - this.height;
				if (velY < 0) this.Y = e.getY() + e.getHeight();
			this.colY = true;
		}
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
    
    public Color GetColor() { return this.color; }
    public void SetColor(Color color) { this.color = color; }
    
    public Cursor getCursor() { return this.cursor; }
}
