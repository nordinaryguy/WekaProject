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
		 * Cr�ation du JTextPane
		 */
		JTextPane textPane = new JTextPane();

		/*
		 * Cr�ation d'un style
		 * (le style du texte du po�me)
		 */
		SimpleAttributeSet style_normal = new SimpleAttributeSet();
		StyleConstants.setFontFamily(style_normal, "Calibri");
		StyleConstants.setFontSize(style_normal, 14);

		/*
		 * Cr�ation du style pour l'affichage du titre
		 */
		SimpleAttributeSet style_titre = new SimpleAttributeSet();
		style_titre.addAttributes(style_normal);
		StyleConstants.setForeground(style_titre, Color.BLUE);
		StyleConstants.setUnderline(style_titre, true);
		StyleConstants.setFontSize(style_titre, 18);
		StyleConstants.setBold(style_titre, true);
		
		/*
		 * Cr�ation du style qui permet de centrer le texte
		 */
		SimpleAttributeSet centrer = new SimpleAttributeSet();
		StyleConstants.setAlignment(centrer, StyleConstants.ALIGN_CENTER);
		
		/*
		 * Cr�ation du style qui permet d'afficher les r�f�r�nces
		 */
		SimpleAttributeSet style_citation = new SimpleAttributeSet();
		style_citation.addAttributes(style_normal);
		StyleConstants.setItalic(style_citation, true);
		
		try {
			/*
			 * R�cup�ration du style du document 
			 */
			StyledDocument doc = textPane.getStyledDocument();
			
			/*
			 * Insertion d'une chaine de caract�res dans le document
			 * insertString :
			 * 	position de d�part dans le document (doc.getLength ajoute � la fin
			 *  texte � ajouter
			 *  style pour le texte � ajouter
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
			 * Centrage des r�f�rences
			 */
			doc.setParagraphAttributes(fin_poeme, doc.getLength(), centrer, false);
		}
		catch (BadLocationException e) {
			e.printStackTrace();
		}

		/*
		 * Construction de la fen�tre pour affichage du JTextPane
		 */
		JFrame f = new JFrame("Affichage poeme");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(350, 450);
		f.setLocationRelativeTo(null);
		f.add(textPane);
		f.setVisible(true);
	}

	/*
	 * Cr�ation du texte et appel de la fonction d'affichage
	 */
	public static void main(String[] args){

		String titre ="A une passante";

		StringBuilder sb = new StringBuilder();
		sb.append("La rue assourdissante autour de moi hurlait.").append("\n");
		sb.append("Longue, mince, en grand deuil, douleur majestueuse,").append("\n");   
		sb.append("Une femme passa, d'une main fastueuse").append("\n");
		sb.append("Soulevant, balan�ant le feston et l'ourlet ;").append("\n");
		sb.append("\n");
		sb.append("Agile et noble, avec sa jambe de statue.").append("\n");
		sb.append("Moi, je buvais, crisp� comme un extravagant,").append("\n");
		sb.append("Dans son oeil, ciel livide o� germe l'ouragan,").append("\n");
		sb.append("La douceur qui fascine et le plaisir qui tue.").append("\n");
		sb.append("\n");
		sb.append("Un �clair... puis la nuit ! - Fugitive beaut�").append("\n");
		sb.append("Dont le regard m'a fait soudainement rena�tre,").append("\n");
		sb.append("Ne te verrai-je plus que dans l'�ternit� ?").append("\n");
		sb.append("\n");
		sb.append("Ailleurs, bien loin d'ici ! trop tard ! jamais peut-�tre !").append("\n");
		sb.append("Car j'ignore o� tu fuis, tu ne sais o� je vais,").append("\n");
		sb.append("� toi que j'eusse aim�e, � toi qui le savais !").append("\n");
		
		String auteur="Baudelaire"; 
		String livre="Les Fleurs du mal, 1857";

		afficher(titre, auteur, livre, sb.toString());
	}

}