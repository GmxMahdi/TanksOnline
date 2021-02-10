package me.tankgame.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.formdev.flatlaf.FlatDarkLaf;

import me.tankgame.network.ClientHandler;

public class Gui {

	public static int WIDTH = 600;
	public static int HEIGHT = 500;
	
	private static JFrame frame;
	
	private static NetworkingMenu currentMenu;
	
	public static  void start() {
		FlatDarkLaf.install();
		frame = new JFrame("Tank");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);	
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		//ImageIcon image = new ImageIcon("C:\\Users\\D0_00\\Desktop\\Desktop Compilation 2.1\\dragon.png");
		//frame.setIconImage(image.getImage());

		//GameView view = new GameView();
		//view.setFocusable(true);
		
		currentMenu = new MainMenu();
		frame.setFocusable(true);
		frame.getContentPane().add(currentMenu);
		frame.setVisible(true);
		frame.pack();
		
		ClientHandler.start();
		//view.run();
	}
	
	public static void ShowWarning(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public static void SwitchMenu(NetworkingMenu menu) {
		frame.getContentPane().removeAll();
		currentMenu = menu;
		frame.getContentPane().add(currentMenu);
		currentMenu.onloadSendNetworkRequests();
		currentMenu.requestFocus();
		frame.revalidate();
		frame.repaint();
	}
	
	public static void ReceiveNetworkResponse(Object o) {
		currentMenu.handleNetworkResponse(o);
	}
	
	public static void DebugBorder(JComponent jc , Color c) {
		jc.setBorder(
				BorderFactory.createLineBorder(c, 2));
	}
}
