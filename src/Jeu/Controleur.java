package Jeu;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener {
	
	Modele mod;
	
	public Controleur(Modele m) {
		this.mod = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("clicked");
		Button b = (Button) e.getSource();
		Color c = b.getBackground();
		try {
			mod.combinaison.pushColor(c);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Cannot push color" + e1.getMessage());
		}
	}
	
	
}
