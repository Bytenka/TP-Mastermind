package Jeu;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener {
	
	Modele modele;
	
	public Controleur(Modele modele) {
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color buttonColor = ((Button) e.getSource()).getBackground();
		System.out.println("Button pressed! Color: " + buttonColor);
		
		modele.submitColor(buttonColor);
	}
}
