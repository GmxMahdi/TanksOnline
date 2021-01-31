package me.tankgame.game;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    public TrainingMode trainingMode;
    public GameView() {
        trainingMode = new TrainingMode();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        trainingMode.draw((Graphics2D) g);
    }
}
