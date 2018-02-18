package com.gui;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.gui.MainGuiApplication;

public class StartView extends JFrame {
	private StartPane sp;
	
	public StartView() {
		this.init();
	}

	public void init() {
		this.setTitle("Machine Learning : Sequential Coverage");
		this.setSize(697, 399);
		this.setLocationRelativeTo(null);   
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Instanciation d'un objet JPanel
		sp = new StartPane();
		//On prévient notre JFrame que notre JPanel sera son content pane
		this.setContentPane(sp);               
		this.setVisible(true);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dispose();

	}
}
