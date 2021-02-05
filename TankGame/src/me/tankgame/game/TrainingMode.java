package me.tankgame.game;

import me.tankgame.game.models.Map;
import me.tankgame.game.player.Cursor;
import me.tankgame.game.player.Tank;
import me.tankgame.main.Main;

import java.awt.*;
import java.awt.event.*;

public class TrainingMode implements KeyListener, MouseListener, MouseMotionListener {
    
    private Map map;
    Tank player;
    boolean running;


    public TrainingMode() {
        running = true;
        
        map = new Map();
        player = new Tank((Main.WIDTH / 2f) - 25, (Main.HEIGHT / 2f) - 25);
        player.SetColor(Color.yellow);
        
        map.AddEntity(player);
        map.AddMovableEntity(player);
    }

    public void update() {
        map.update();
    }

    public void draw(Graphics2D g) {
        map.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        player.keyDown(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.keyUp(e);
    }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("lol!");
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		this.player.getCursor().setX(arg0.getX());
		this.player.getCursor().setY(arg0.getY());
	}
}
