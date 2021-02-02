package me.tankgame.game.player;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    float x, y;
    float velX, velY;
    int width, height;
    public Tank(float x, float y) {
        this.x = x;
        this.y = y;
        width = 50;
        height = 50;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.black);
        g.fillRect((int)x, (int)y, width, height);
    }

    public void update() {
        x += velX;
        y += velY;
    }

    public void keyDown(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                velY = -5;
                break;
            case KeyEvent.VK_A:
                velX = -5;
                break;
            case KeyEvent.VK_S:
                velY = 5;
                break;
            case KeyEvent.VK_D:
                velX = 5;
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
}
