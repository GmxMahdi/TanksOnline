package me.tankgame.game;

import me.tankgame.game.models.Map;
import me.tankgame.game.player.Tank;
import me.tankgame.main.Main;

import java.awt.*;
import java.awt.event.*;

public class TrainingMode extends KeyAdapter {
    
    private Map map;
    Tank player;
    boolean running;


    public TrainingMode() {
        running = true;
        
        map = new Map();
        
        player = new Tank((Main.WIDTH / 2f) - 25, (Main.HEIGHT / 2f) - 25);
        player.SetColor(Color.yellow);
        
        map.AddEntity(player);
    }

    public void update() {
        player.update();
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
}
