package me.tankgame.main;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

import com.formdev.flatlaf.FlatDarkLaf;

import me.tankgame.ui.*;

public class Main {

	public static int WIDTH = 600;
	public static int HEIGHT = 500;
	
	public static void main(String[] args) {
		FlatDarkLaf.install();
		ImageIcon image = new ImageIcon("C:\\Users\\D0_00\\Desktop\\Desktop Compilation 2.1\\dragon.png");
		
		JFrame frame = new JFrame("Tank");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);	
		frame.setIconImage(image.getImage());
		frame.setContentPane(new MainMenu());
		frame.setVisible(true);
		// frame.pack();
	}
	
	public static void DebugBorder(JComponent jc , Color c) {
		jc.setBorder(
				BorderFactory.createLineBorder(c, 2));
	}

}
