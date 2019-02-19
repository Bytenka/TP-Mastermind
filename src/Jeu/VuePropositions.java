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
		int lineNb = 0;
		for (Rangee r : relativeModele.propositions)
			drawRangee(lineNb++, r, g);

		// Display current proposition
			drawRangee(lineNb++, relativeModele.currentProp, g);

		// Display correct combinaison (for debugging) @TODO
		drawRangee(11, relativeModele.combinaison, g);
	}

	public void drawRangee(int lineNb, Rangee rangee, Graphics g) {
		// Drawing proposition circles
		int colorNb = 0;
		for (Color c : rangee) {
			g.setColor(c);
			g.fillOval((DOT_SIZE + SPACE_SIZE) * colorNb, (DOT_SIZE + SPACE_SIZE) * lineNb, DOT_SIZE, DOT_SIZE);
			colorNb++;
		}

		// Drawing results circles
		Color[] results = rangee.getResult();
		if (results != null) {
			for (int i = 0; i < results.length; i++) {
				Color c = results[i];
				if (c != null) {
					g.setColor(c);
					g.fillOval((DOT_SIZE + SPACE_SIZE) * colorNb + i*15, (DOT_SIZE + SPACE_SIZE) * lineNb, 10, 10);
				}

			}
		}
	}
}
