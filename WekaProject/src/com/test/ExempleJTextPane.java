package com.test;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class ExempleJTextPane {
	
	public static void afficher(String titrePoeme, String auteur, String livre, String poeme){
		/*
		 * Création du JTextPane
		 */
		JTextPane textPane = new JTextPane();

		/*
		 * Création d'un style
		 * (le style du texte du poème)
		 */
		SimpleAttributeSet style_normal = new SimpleAttributeSet();
		StyleConstants.setFontFamily(style_normal, "Calibri");
		StyleConstants.setFontSize(style_normal, 14);

		/*
		 * Création du style pour l'affichage du titre
		 */
		SimpleAttributeSet style_titre = new SimpleAttributeSet();
		style_titre.addAttributes(style_normal);
		StyleConstants.setForeground(style_titre, Color.BLUE);
		StyleConstants.setUnderline(style_titre, true);
		StyleConstants.setFontSize(style_titre, 18);
		StyleConstants.setBold(style_titre, true);
		
		/*
		 * Création du style qui permet de centrer le texte
		 */
		SimpleAttributeSet centrer = new SimpleAttributeSet();
		StyleConstants.setAlignment(centrer, StyleConstants.ALIGN_CENTER);
		
		/*
		 * Création du style qui permet d'afficher les référénces
		 */
		SimpleAttributeSet style_citation = new SimpleAttributeSet();
		style_citation.addAttributes(style_normal);
		StyleConstants.setItalic(style_citation, true);
		
		try {
			/*
			 * Récupération du style du document 
			 */
			StyledDocument doc = textPane.getStyledDocument();
			
			/*
			 * Insertion d'une chaine de caractères dans le document
			 * insertString :
			 * 	position de départ dans le document (doc.getLength ajoute à la fin
			 *  texte à ajouter
			 *  style pour le texte à ajouter
			 */
			doc.insertString(doc.getLength(), titrePoeme+"\n\n", style_titre);
			int fin_titre=doc.getLength();
			doc.insertString(doc.getLength(), poeme+"\n", style_normal);
			int fin_poeme=doc.getLength();
			doc.insertString(doc.getLength(), auteur+"\n", style_citation);
			doc.insertString(doc.getLength(), livre, style_citation);
			
			/*
			 * Centrage du titre
			 */
			doc.setParagraphAttributes(0, fin_titre, centrer, false);
			
			/*
			 * Centrage des références
			 */
			doc.setParagraphAttributes(fin_poeme, doc.getLength(), centrer, false);
		}
		catch (BadLocationException e) {
			e.printStackTrace();
		}

		/*
		 * Construction de la fenêtre pour affichage du JTextPane
		 */
		JFrame f = new JFrame("Affichage poeme");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(350, 450);
		f.setLocationRelativeTo(null);
		f.add(textPane);
		f.setVisible(true);
	}

	/*
	 * Création du texte et appel de la fonction d'affichage
	 */
	public static void main(String[] args){

		String titre ="A une passante";

		StringBuilder sb = new StringBuilder();
		sb.append("La rue assourdissante autour de moi hurlait.").append("\n");
		sb.append("Longue, mince, en grand deuil, douleur majestueuse,").append("\n");   
		sb.append("Une femme passa, d'une main fastueuse").append("\n");
		sb.append("Soulevant, balançant le feston et l'ourlet ;").append("\n");
		sb.append("\n");
		sb.append("Agile et noble, avec sa jambe de statue.").append("\n");
		sb.append("Moi, je buvais, crispé comme un extravagant,").append("\n");
		sb.append("Dans son oeil, ciel livide où germe l'ouragan,").append("\n");
		sb.append("La douceur qui fascine et le plaisir qui tue.").append("\n");
		sb.append("\n");
		sb.append("Un éclair... puis la nuit ! - Fugitive beauté").append("\n");
		sb.append("Dont le regard m'a fait soudainement renaître,").append("\n");
		sb.append("Ne te verrai-je plus que dans l'éternité ?").append("\n");
		sb.append("\n");
		sb.append("Ailleurs, bien loin d'ici ! trop tard ! jamais peut-être !").append("\n");
		sb.append("Car j'ignore où tu fuis, tu ne sais où je vais,").append("\n");
		sb.append("Ô toi que j'eusse aimée, ô toi qui le savais !").append("\n");
		
		String auteur="Baudelaire"; 
		String livre="Les Fleurs du mal, 1857";

		afficher(titre, auteur, livre, sb.toString());
	}

}