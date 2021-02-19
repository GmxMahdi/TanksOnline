package me.tankgame.design;

import me.tankgame.game.models.Bullet;
import me.tankgame.game.models.Crate;
import me.tankgame.game.models.InvisibleBarrier;
import me.tankgame.game.player.Tank;

public interface ICollideable {

	public abstract void resolveCollision(ICollideable collideable);
	
	public void resolveCollision(Tank tank);
	public void resolveCollision(Bullet bullet);
	public void resolveCollision(Crate crate);
	public void resolveCollision(InvisibleBarrier invisibleBarrier);
}
