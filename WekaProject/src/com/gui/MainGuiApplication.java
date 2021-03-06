package com.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.core.ArffParser;
import com.core.MainCore;
import com.patternObs.Observer;

public class MainGuiApplication extends JFrame implements Observer {

	private MainPanel pan;
	private MainCore mainCore;
	private JMenuBar menu = new JMenuBar();

	private JMenu file = new JMenu("File"),
			about = new JMenu("About");

	private JMenuItem open = new JMenuItem("Open a file..."),
			quit = new JMenuItem("Quit"),
			aboutItem = new JMenuItem("?");

	private String arfffilepath = null;
	private String arfffilename = null;

	public MainGuiApplication(MainCore mc){             
		this.mainCore = mc;
		this.init();
		this.initMenu();
	}

	private void init() {
		this.setTitle("Machine Learning : Sequential Coverage");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);   
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Instanciation d'un objet JPanel
		pan = new MainPanel();
		//D�finition de sa couleur de fond
		pan.setBackground(Color.LIGHT_GRAY);        
		//On pr�vient notre JFrame que notre JPanel sera son content pane
		this.setContentPane(pan);    
		this.setVisible(true);
	}

	private void initMenu() {
		//Premier onglet File
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser choix = new JFileChooser();
				int retour=choix.showOpenDialog(null);
				if(retour==JFileChooser.APPROVE_OPTION){
					// un fichier a �t� choisi (sortie par OK)
					// nom du fichier  choisi 
					arfffilename =  choix.getSelectedFile().getName();
					// chemin absolu du fichier choisi
					arfffilepath = choix.getSelectedFile().getAbsolutePath();
					mainCore.parseArffFile(arfffilename, arfffilepath);
					//ap = new ArffParser(arfffilename, arfffilepath);
					//ap.parseAndDisplay();
				}else {
					System.out.println("Pas de fichier choisi!");
				};
			}
		});
		file.add(open);
		file.addSeparator();
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		file.add(quit);

		//Deuxieme onglet About
		aboutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Bo�te du message d'information
				JOptionPane.showMessageDialog(null, "Machine Learning : Sequential Coverage\nDUMONT Hugues - HUET Guillaume\nM1 Informatique - Universit� d'Angers\n2018", "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		about.add(aboutItem);


		//Ajout des onglets menus dans la barre de menus
		menu.add(file);
		menu.add(about);

		//Ajout de la barre de menus dans la fenetre
		this.setJMenuBar(menu);
	}

	@Override
	public void update(String str) {
		// TODO Auto-generated method stub
		pan.getInstancesArea().append(str+"\n");
	}
}
