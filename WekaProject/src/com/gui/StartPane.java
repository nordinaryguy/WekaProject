package com.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class StartPane extends JPanel {
	public void paintComponent(Graphics g){
		try {
			Image img = ImageIO.read(new File("C:\\Users\\guill\\Documents\\0_MASTER INFORMATIQUE\\WekaProject\\WekaProject\\src\\com\\gui\\machinelearninglogoresized.png"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			//Pour une image de fond
			//g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}                
	}  
}
