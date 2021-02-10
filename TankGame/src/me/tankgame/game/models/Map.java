package me.tankgame.game.models;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import me.tankgame.ui.Gui;

public class Map extends Entity{

	private ArrayList<Entity> entities;
	private ArrayList<MovableEntity> movableEntities;
	
	public Map() {
		entities = new ArrayList<Entity>();
		movableEntities = new ArrayList<MovableEntity>();
		SetupBarriers();
		SetupCrates();
	}
	
	public void SetupBarriers() {
		InvisibleBarrier a = new InvisibleBarrier(-30, 0, 30, Gui.HEIGHT);
		InvisibleBarrier b = new InvisibleBarrier(0, -30, Gui.WIDTH, 30);
		InvisibleBarrier c = new InvisibleBarrier(Gui.WIDTH, 0, 30, Gui.HEIGHT);
		InvisibleBarrier d = new InvisibleBarrier(0, Gui.HEIGHT, Gui.WIDTH, 30);
		
		entities.add(a);
		entities.add(b);
		entities.add(c);
		entities.add(d);
	}
	
	public void SetupCrates() {
		
		Crate c = new Crate(200, 200);
		entities.add(c);
		entities.add(new Crate(0,0));
		entities.add(new Crate(100,300));
	}
	
	@Override
	public void draw(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, Gui.WIDTH, Gui.HEIGHT);
        
        for (Entity entity: entities)
        	entity.draw(g);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 30)); 
        g.drawString("ESC to leave", 150, 40);
	}
	
	public void update() {
		for (MovableEntity me : movableEntities) {
			me.update(entities);
		}
	}
	
	public void AddEntity(Entity entity) {
		entities.add(entity);
	}
	
	public void RemoveEntity(Entity entity) {
		entities.remove(entity);
	}
	
	public void AddMovableEntity(MovableEntity entity) {
		movableEntities.add(entity);
	}
	
	public void RemoveMovableEntity(MovableEntity entity) {
		movableEntities.remove(entity);
	}
	
}
