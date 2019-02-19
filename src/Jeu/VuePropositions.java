package Jeu;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class VuePropositions extends Canvas {

	private Modele relativeModele;
	private static int DOT_SIZE = 40;
	private static int SPACE_SIZE = DOT_SIZE / 4;

	public VuePropositions(Modele relativeModele) {
		super();
		this.relativeModele = relativeModele;

		this.setBackground(Color.GRAY);
		this.setSize(100, 100); // @TODO Change size according to Modele data
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		// Display propositions
		int linesCount = 0;
		for (Rangee r : relativeModele.propositions) {
			int spacesCount = 0;
			for (Color c : r) {
				g.setColor(c);
				g.fillOval(
						(DOT_SIZE + SPACE_SIZE) * spacesCount, 
						(DOT_SIZE + SPACE_SIZE) * linesCount, 
						DOT_SIZE,
						DOT_SIZE);
				
				spacesCount++;
			}
			linesCount++;
		}
		
		// Display current proposition
		// @TODO relativeModele.propEnCours
		
		// Display correct combinaison (for debugging) @TODO
		int spacesCount = 0;
		for (Color c : relativeModele.combinaison) {
			g.setColor(c);
			g.fillOval(
					(DOT_SIZE + SPACE_SIZE) * spacesCount, 
					580, 
					DOT_SIZE,
					DOT_SIZE);
			
			spacesCount++;
		}
	}
}
