package com.core;

import java.util.ArrayList;

import com.patternObs.Observable;
import com.patternObs.Observer;

public class MainCore implements Observable {
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	//private ArffParser arffParser;

	public  void parseArffFile(String arffName, String arffpath) {
		ArffParser arffParser = new ArffParser(arffName, arffpath);
		ArrayList<String> listInst = new ArrayList<String>();
		listInst = arffParser.getStringInstances();
		for(String instance : listInst) {
			this.notifyObserver(instance);
		}
	}

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.listObserver.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.listObserver.remove(obs);
	}

	@Override
	public void notifyObserver(String str) {
		// TODO Auto-generated method stub
		for(Observer obs : this.listObserver) {
			obs.update(str);
		}
	}

}
