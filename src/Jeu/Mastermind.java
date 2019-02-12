package Jeu;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;

public class Mastermind extends Frame implements WindowListener, Observer {

	VueClavier vueClavier;
	VuePropositions vuePropositions;

	public Mastermind() {
		this.setTitle("Mastermind");
		this.setSize(300, 700);
		this.setLayout(new BorderLayout());
		this.addWindowListener(this);
		this.setVisible(true);

		vueClavier = new VueClavier();
		vuePropositions = new VuePropositions();

		this.add(vuePropositions, BorderLayout.CENTER);
		this.add(vueClavier, BorderLayout.PAGE_END);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("Called update in Frame");
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		this.dispose();
	}

	public static void main(String[] args) {
		Mastermind jeu = new Mastermind();
		Modele modele = new Modele();
		modele.addObserver(jeu);

		System.out.println("Hello World!");
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}
}