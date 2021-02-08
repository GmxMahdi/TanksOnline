package me.tankgame.game;


import me.tankgame.ui.NetworkingMenu;

import java.awt.*;


public class GameView extends NetworkingMenu implements Runnable {
    public TrainingMode trainingMode;
    public GameView() {
    	this.setFocusable(true);
        trainingMode = new TrainingMode();
        this.addKeyListener(trainingMode);
        this.addMouseListener(trainingMode);
        this.addMouseMotionListener(trainingMode);
        
        
        Thread t = new Thread(this);
        t.start();
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

	@Override
	public void handleNetworkResponse(Object o) {
	}
}
