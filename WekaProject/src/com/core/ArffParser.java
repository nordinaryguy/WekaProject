package com.core;

import java.io.File;
import java.io.IOException;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

public class ArffParser {

	private String arffpath=null;
	private String arfffilename=null;
	private File arfffile;

	public ArffParser(String arfffilename, String arffpath) {
		this.arfffilename = arfffilename;
		this.arffpath = arffpath;
	}

	public void parseAndDisplay() {
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
			System.out.println("Instance:" + inst);
		}
	}
}
