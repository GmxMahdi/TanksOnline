package me.tankgame.game;


import me.tankgame.ui.Gui;
import me.tankgame.ui.MainMenu;
import me.tankgame.ui.NetworkingMenu;

import java.awt.*;


public class GameView extends NetworkingMenu implements Runnable {
	
    private TrainingMode trainingMode;
    private boolean running = false;
    
    public GameView() {
    	this.setFocusable(true);
        trainingMode = new TrainingMode(this);
        this.addKeyListener(trainingMode);
        this.addMouseListener(trainingMode);
        this.addMouseMotionListener(trainingMode);
        
        
        running = true;
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        while (running) {
            trainingMode.update();
            this.repaint();

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void stop() {
    	running = false;
    	Gui.SwitchMenu(new MainMenu());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        trainingMode.draw((Graphics2D) g);
    }

	@Override
	public void handleNetworkResponse(Object o) {
	}

	@Override
	public void onloadSendNetworkRequests() {
		// TODO Auto-generated method stub
		
	}
}
