package me.tankgame.game.models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import me.tankgame.main.Main;

public class Map extends Entity{

	private ArrayList<Entity> entities;
	private ArrayList<MovableEntity> movableEntities;
	
	public Map() {
		entities = new ArrayList<Entity>();
		movableEntities = new ArrayList<MovableEntity>();
		SetupCrates();
	}
	
	public void SetupCrates() {
		
		Crate c = new Crate(200, 200);
		Crate d =  new Crate(100, 100);
		entities.add(c);
		entities.add(new Crate(0,0));
		entities.add(new Crate(100,300));
		//entities.add(d);
//		for (int i = 0; i < 6; ++i) {
//			Crate c = new Crate(i*Crate.WIDTH*2, 0);
//			entities.add(c);
//		}
	}
	
	@Override
	public void draw(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
        
        for (Entity entity: entities)
        	entity.draw(g);
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
