package com.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.ConverterUtils.DataSource;

public class ArffParser {

	private String arffpath=null;
	private String arfffilename=null;
	private File arfffile;
	private String arfffilestring;
	//private ArrayList<String> stringInstances = new ArrayList<String>();

	public ArffParser(String arfffilename, String arffpath) {
		this.arfffilename = arfffilename;
		this.arffpath = arffpath;
	}

	public String getStringDataSet() {
		this.parseAndDisplay();
		if (arfffilestring!=null) {
			JOptionPane.showMessageDialog(null, "Arff file loaded successfully !", "Arff File Loading", JOptionPane.INFORMATION_MESSAGE);
			return this.arfffilestring;
		}
		else {
			return null;
		}
	}

	private void parseAndDisplay() {
		/*
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
		 */
		try {
			DataSource source = new DataSource(this.arffpath);
			Instances instances = source.getDataSet();
			//instances.setClassIndex(instances.numAttributes()-1);
			this.arfffilestring = "\nDataset:\n\n";
			this.arfffilestring+=instances.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
