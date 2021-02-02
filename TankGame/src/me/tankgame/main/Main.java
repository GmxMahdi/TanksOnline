package me.tankgame.main;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.formdev.flatlaf.FlatLightLaf;

import me.tankgame.game.GameView;
import me.tankgame.ui.*;

public class Main {

	public static int WIDTH = 600;
	public static int HEIGHT = 500;
	
	private static JFrame frame;
	
	public static void main(String[] args) {
		// FlatDarkLaf.install();
		FlatLightLaf.install();
		ImageIcon image = new ImageIcon("C:\\Users\\D0_00\\Desktop\\Desktop Compilation 2.1\\dragon.png");
		
		frame = new JFrame("Tank");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);	
		frame.setIconImage(image.getImage());

		GameView view = new GameView();

		frame.addMouseListener(view.trainingMode);
		frame.addKeyListener(view.trainingMode);

		frame.getContentPane().add(new MainMenu());

		frame.setVisible(true);
		// frame.pack();
	}
	
	public static void SwitchMenu(JPanel menu) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(menu);
		frame.revalidate();
		frame.repaint();
	}
	
	public static void DebugBorder(JComponent jc , Color c) {
		jc.setBorder(
				BorderFactory.createLineBorder(c, 2));
	}

}
