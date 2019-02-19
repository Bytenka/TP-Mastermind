package Jeu;

import java.awt.Button;
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
		Button b = (Button) e.getSource();
		
		System.out.println("clicked " + b.getBackground().toString());
	}
	
	
}
