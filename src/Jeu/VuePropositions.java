package Jeu;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class VuePropositions extends Canvas {

	public VuePropositions() {
		super();
		this.setBackground(Color.GRAY);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawRect(10, 10, 50, 50);
	}
}
