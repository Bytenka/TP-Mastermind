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
		g.setColor(Color.GREEN);
		g.drawRect(10, 10, 50, 50);
	}
}
