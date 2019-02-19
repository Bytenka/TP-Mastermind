package Jeu;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.util.Observable;
import java.util.Observer;

public class VueClavier extends Panel implements Observer {

	public VueClavier(Controleur ctrl) {
		super();
		this.setPreferredSize(new Dimension(0, 40));
		this.setBackground(Color.LIGHT_GRAY);

		// For vueClavier
		FlowLayout fl = new FlowLayout();
		fl.preferredLayoutSize(this);
		this.setLayout(fl);
		
		// Adding buttons to the layout, at the bottom
		for (Color c : Modele.COULEURS) {
			Button b = new Button();
			b.setPreferredSize(new Dimension(30, 30));
			b.setBackground(c);
			b.addActionListener(ctrl);
			this.add(b);
		}

		/********************/
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
