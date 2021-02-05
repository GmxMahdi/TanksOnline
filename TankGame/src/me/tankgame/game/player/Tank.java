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
	private ArrayList<Bullet> bullets;
	
	private Map map;
	
    public Tank(float X, float Y, Map map) {
        this.X = X;
        this.Y = Y;
        this.width = 50;
        this.height = 50;
        this.speed = 5;
        this.color = Color.red;
        
        cursor = new Cursor();
        
        this.map = map;
    }

    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.fillRect((int)this.X, (int)this.Y, width, height);
        
        // DRAW BARREL OF TANK (set it to a function or something else
        double angle = Math.atan2(this.cursor.getY() - this.getCenterY(), this.cursor.getX() - this.getCenterX());
        double length = 50;
        
        g.setColor(Color.red);
        g.setStroke(new BasicStroke(10));
        g.drawLine((int)this.getCenterX(), (int)this.getCenterY(), 
        		(int)(this.getCenterX() + Math.cos(angle)*length), (int)(this.getCenterY() + Math.sin(angle)*length));
        cursor.draw(g);
    }

    public void shoot() {

    	double angle = Math.atan2(this.cursor.getY() - this.getCenterY(), this.cursor.getX() - this.getCenterX());
        double length = 50;
    	Bullet b = new Bullet((int)(this.getCenterX()+ Math.cos(angle)*length), (int)(this.getCenterY() + Math.sin(angle)*length));
        b.setVelX((float)Math.cos(angle)*b.getSpeed());
        b.setVelY((float)Math.sin(angle)*b.getSpeed());
        
        map.AddEntity(b);
        map.AddMovableEntity(b);
        System.out.println("bullet shot");
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
