package me.tankgame.game.models;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Map {

	private ArrayList<Entity> entities;
	private Queue<Entity> removedEntities;
	private int width;
	private int height;
	
	public Map() {
		
	}
	
	public Map(int width, int height) {
		this.width = width;
		this.height = height;
		entities = new ArrayList<Entity>();
		removedEntities = new ArrayDeque<Entity>();
		SetupBarriers();
		SetupCrates();
	}
	
	public void SetupBarriers() {
		InvisibleBarrier a = new InvisibleBarrier(-30, 0, 30, width);
		InvisibleBarrier b = new InvisibleBarrier(0, -30, width, 30);
		InvisibleBarrier c = new InvisibleBarrier(width, 0, 30, height);
		InvisibleBarrier d = new InvisibleBarrier(0, height, width, 30);
		
		entities.add(a);
		entities.add(b);
		entities.add(c);
		entities.add(d);
	}
	
	public void SetupCrates() {
		entities.add(new Crate(220, 0));
		entities.add(new Crate(250, 20));
	}
	

	public void draw(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, width, height);
        
        for (Entity entity: entities)
        	entity.draw(g);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 30)); 
        g.drawString("ESC to leave", 150, 40);
	}
	
	public void update() {
		for (Entity e : entities) {
			e.update(entities);
		}
		
		removeEntitiesOnQueue();
	}
	
	private void removeEntitiesOnQueue() {
		while (!removedEntities.isEmpty()) {
			Entity e = removedEntities.poll();
			entities.remove(e);
		}
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	public void removeEntity(Entity entity) {
		entities.remove(entity);
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
	public void addEntityToRemoveQueue(Entity e) {
		removedEntities.add(e);
	}
	
}
