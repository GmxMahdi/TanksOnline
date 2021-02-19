package me.tankgame.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.IntelliJTheme;

import me.tankgame.network.ClientHandler;
import me.tankgame.main.Main;
import java.io.InputStream;

public class Gui {

	public static final String TITLE = "TANKS ONLINE CLIENT";
	public static int WIDTH = 600;
	public static int HEIGHT = 500;
	
	private static JFrame frame;
	
	private static NetworkingMenu currentMenu;
	
	public static  void start() {
		IntelliJTheme.install(
				Main.class.getResourceAsStream("/me/tankgame/themes/one_dark.theme.json")
		); // Mettre en marche le dark theme du GUI

		
		frame = new JFrame(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);	
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		//ImageIcon image = new ImageIcon("C:\\Users\\D0_00\\Desktop\\Desktop Compilation 2.1\\dragon.png");
		//frame.setIconImage(image.getImage());

		//GameView view = new GameView();
		//view.setFocusable(true);
		
		currentMenu = new ConnectToServerMenu();
		frame.setFocusable(true);
		frame.getContentPane().add(currentMenu);
		frame.setVisible(true);
		frame.pack();
		ClientHandler.start();
		//view.run();
	}
	
	public static void showMessage(String message) {
		JOptionPane.showMessageDialog(frame, message);
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
