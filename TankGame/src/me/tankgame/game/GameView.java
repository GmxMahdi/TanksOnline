package me.tankgame.game;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    public TrainingMode trainingMode;
    public GameView() {
        trainingMode = new TrainingMode();
        this.addKeyListener(trainingMode);
        this.addMouseListener(trainingMode);
        this.addMouseMotionListener(trainingMode);
    }

    public void run() {
        while (trainingMode.running) {
            trainingMode.update();
            this.repaint();

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        trainingMode.draw((Graphics2D) g);
    }
}
