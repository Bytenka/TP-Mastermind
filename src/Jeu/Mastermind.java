package Jeu;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;

public class Mastermind extends Frame implements WindowListener {

	Modele modele;
	Controleur ctrl;
	
	VueClavier vueClavier;
	VuePropositions vuePropositions;

	public Mastermind() {
		modele = new Modele();
		ctrl = new Controleur(modele);
		
		this.setTitle("Mastermind");
		this.setSize(300, 700);
		this.setLayout(new BorderLayout());
		this.addWindowListener(this);
		this.setVisible(true);

		vueClavier = new VueClavier(ctrl);
		modele.addObserver(vueClavier);
		vuePropositions = new VuePropositions(modele);

		this.add(vuePropositions, BorderLayout.CENTER);
		this.add(vueClavier, BorderLayout.PAGE_END);
	}
	
	public static void main(String[] args) {
		Mastermind jeu = new Mastermind();

		System.out.println("Hello World!");
	}

	public void update(Observable arg0, Object arg1) {
		System.out.println("Called update in Frame");
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		this.dispose();
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