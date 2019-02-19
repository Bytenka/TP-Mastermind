package Jeu;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class VuePropositions extends Canvas {

	private Modele relativeModele;

	public VuePropositions(Modele relativeModele) {
		super();
		this.relativeModele = relativeModele;

		this.setBackground(Color.GRAY);
		this.setSize(100, 100); // @TODO Change size according to Modele data
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		for (Rangee r : relativeModele.propositions) {
			int spacesCount = 0;
			for (Color c : r) {
				g.setColor(c);
				g.fillOval(60*spacesCount, 0, 50, 50);
				spacesCount++;
			}
		}
	}
}
