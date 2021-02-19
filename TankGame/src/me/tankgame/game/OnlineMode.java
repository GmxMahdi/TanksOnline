package me.tankgame.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;

import javax.swing.JPanel;

import me.tankgame.game.lobby.Lobby;
import me.tankgame.game.lobby.Player;
import me.tankgame.game.models.Map;
import me.tankgame.game.player.Tank;
import me.tankgame.network.ClientHandler;
import me.tankgame.network.NetManager;
import me.tankgame.network.paquet.game.PaquetUpdatePlayer;
import me.tankgame.ui.Gui;
import me.tankgame.ui.MainMenu;
import me.tankgame.ui.NetworkingMenu;

@SuppressWarnings("serial")
public class OnlineMode extends NetworkingMenu implements KeyListener, MouseListener, MouseMotionListener, Runnable {

	 private boolean running = false;
	 
	 private int userId;
	 private Tank userTank;

	 private Lobby lobby;
	 
	 private Map map;
	 private HashMap<Integer, Tank> tanks;
	
	
	public OnlineMode(Lobby lobby) {
		this.lobby = lobby;
		this.tanks = new HashMap<Integer, Tank>();
		
		this.map = new Map(Gui.WIDTH, Gui.HEIGHT);
		
		// Add players to the map
		for (Player player: lobby.getPlayers().values()) {
			
			// Create tank
			Tank tank = new Tank(100, 100, map);
			tank.setColor(player.getTankColor());
			
			// Add tank to map
			map.addEntity(tank);
			
			// Add tank to HashMap
			tanks.put(player.getUserId(), tank);
		}
		
		// Set controllable tank
		this.userId = NetManager.getPlayer().getUserId();
		this.userTank = tanks.get(userId);
		
		// Add listeners
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
		
		// Run update thread
        running = true;
        Thread t = new Thread(this);
        t.start();
	}
	
	
	@Override
	public void run() {
        while (running) {
            this.update();
            this.repaint();
            sendUserUpdate();
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
	
    public void update() {
        map.update();
    }

    public void draw(Graphics2D g) {
        map.draw(g);
    }
    
    // PAINTTT
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        draw((Graphics2D) g);
    }
    
    public void sendUserUpdate() {
    	
    	// Cheap solution to not serialize map
    	// Must find better solution
    	Map debugmap = userTank.map_reference;
    	userTank.map_reference = null;
    	ClientHandler.send(new PaquetUpdatePlayer(lobby.getUserIdHost(), userId, userTank));
    	userTank.map_reference = debugmap;
    }

	@Override
	public void mouseDragged(MouseEvent arg0) {
		this.userTank.getCursor().setX(arg0.getX());
		this.userTank.getCursor().setY(arg0.getY());
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		this.userTank.getCursor().setX(arg0.getX());
		this.userTank.getCursor().setY(arg0.getY());
	}
	
    @Override
    public void keyPressed(KeyEvent e) {
    	userTank.keyDown(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    	if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
    		stop();
    	}
    	else userTank.keyUp(e);
    }
    
	@Override
	public void handleNetworkResponse(Object o) {
		if (o instanceof PaquetUpdatePlayer) {
			PaquetUpdatePlayer paquet = (PaquetUpdatePlayer)o;
			Tank onlineTank = paquet.tank;
			Tank localTank = tanks.get(paquet.userId);
			localTank.setX(onlineTank.getX());
			localTank.setY(onlineTank.getY());
			localTank.setVelX(onlineTank.getVelX());
			localTank.setVelY(onlineTank.getVelY());
			localTank.setAngle(onlineTank.getAngle());
			localTank.getCursor().setX(onlineTank.getCursor().getX());
			localTank.getCursor().setY(onlineTank.getCursor().getY());
		}
	}


	@Override
	public void onloadSendNetworkRequests() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
