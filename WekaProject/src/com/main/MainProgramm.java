package com.main;

import com.core.MainCore;
import com.gui.MainGuiApplication;
import com.gui.StartView;
import com.test.ExempleJTextPane;


public class MainProgramm {

	public static void main(String[] args) throws InterruptedException {
		StartView sv = new StartView();
		MainCore mainCore = new MainCore();
		MainGuiApplication guiapp = new MainGuiApplication(mainCore);
		mainCore.addObserver(guiapp);
	}

}
