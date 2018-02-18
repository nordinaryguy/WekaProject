package com.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

public class ArffParser {

	private String arffpath=null;
	private String arfffilename=null;
	private File arfffile;
	private ArrayList<String> stringInstances = new ArrayList<String>();

	public ArffParser(String arfffilename, String arffpath) {
		this.arfffilename = arfffilename;
		this.arffpath = arffpath;
	}

	public ArrayList<String> getStringInstances() {
		this.parseAndDisplay();
		if (stringInstances!=null) {
			JOptionPane.showMessageDialog(null, "Arff file loaded successfully !", "Arff File Loading", JOptionPane.INFORMATION_MESSAGE);
			return this.stringInstances;
		}
		else {
			return null;
		}
	}
	
	private void parseAndDisplay() {
		ArffLoader arffLoader = new ArffLoader();

		File datasetFile = new File(this.arffpath);
		try {
			arffLoader.setFile(datasetFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Instances dataInstances = null;
		
		try {
			dataInstances = arffLoader.getDataSet();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Instance inst : dataInstances){
			//System.out.println("Instance:" + inst);
			this.stringInstances.add(inst.toString());
		}
	}
}
