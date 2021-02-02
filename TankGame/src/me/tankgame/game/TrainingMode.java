package me.tankgame.game;

import me.tankgame.game.player.Tank;
import me.tankgame.main.Main;

import java.awt.*;
import java.awt.event.*;

public class TrainingMode extends KeyAdapter {
    Tank player;
    boolean running;

    public TrainingMode() {
        running = true;
        player = new Tank((Main.WIDTH / 2f) - 25, (Main.HEIGHT / 2f) - 25);
    }

    public void update() {
        player.update();
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

        player.draw(g);
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
