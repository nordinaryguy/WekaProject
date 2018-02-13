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

public class MainGuiApplication extends JFrame {

	private JPanel pan;
	private JMenuBar menu = new JMenuBar();
	private ArffParser ap;

	private JMenu file = new JMenu("File"),
			about = new JMenu("About");

	private JMenuItem open = new JMenuItem("Open a file..."),
			quit = new JMenuItem("Quit"),
			aboutItem = new JMenuItem("?");

	private String arfffilepath = null;
	private String arfffilename = null;

	public MainGuiApplication(){             

	}

	public void init() {
		this.setTitle("Machine Learning : Sequential Coverage");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);   
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Instanciation d'un objet JPanel
		pan = new JPanel();
		//Définition de sa couleur de fond
		pan.setBackground(Color.LIGHT_GRAY);        
		//On prévient notre JFrame que notre JPanel sera son content pane
		this.setContentPane(pan);    
		this.initMenu();
		this.setVisible(true);
	}

	public void initMenu() {
		//Premier onglet File
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser choix = new JFileChooser();
				int retour=choix.showOpenDialog(null);
				if(retour==JFileChooser.APPROVE_OPTION){
				   // un fichier a été choisi (sortie par OK)
				   // nom du fichier  choisi 
				 arfffilename =  choix.getSelectedFile().getName();
				   // chemin absolu du fichier choisi
				 arfffilepath = choix.getSelectedFile().getAbsolutePath();
				 ap = new ArffParser(arfffilename, arfffilepath);
				 ap.parseAndDisplay();
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
				//Boîte du message d'information
				JOptionPane jop1 = new JOptionPane();
				jop1.showMessageDialog(null, "Machine Learning : Sequential Coverage\nDUMONT Hugues - HUET Guillaume\nM1 Informatique - Université d'Angers\n2018", "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		about.add(aboutItem);
		
		
		//Ajout des onglets menus dans la barre de menus
		menu.add(file);
		menu.add(about);
		
		//Ajout de la barre de menus dans la fenetre
		this.setJMenuBar(menu);
	}
}
