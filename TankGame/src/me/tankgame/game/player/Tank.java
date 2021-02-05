package me.tankgame.game.player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import me.tankgame.game.models.Entity;
import me.tankgame.game.models.MovableEntity;

public class Tank extends MovableEntity {
	
	private Color color;
	private Cursor cursor;
	
    public Tank(float X, float Y) {
        this.X = X;
        this.Y = Y;
        this.width = 50;
        this.height = 50;
        this.speed = 5;
        this.color = Color.red;
        
        cursor = new Cursor();
    }

    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.fillRect((int)this.X, (int)this.Y, width, height);
        
        // DRAW BARREL OF TANK (set it to a function or something else
        double angle = Math.atan2(this.cursor.getY() - this.Y, this.cursor.getX()- this.X);
        double length = 50;
        
        g.setColor(Color.red);
        g.setStroke(new BasicStroke(10));
        g.drawLine((int)this.X, (int)this.Y, 
        		(int)(this.X + Math.cos(angle)*length), (int)(this.Y + Math.sin(angle)*length));
        cursor.draw(g);
    }


   public void update(ArrayList<Entity> entities) {
	   collisionDetection(entities);
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
