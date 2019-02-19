package Jeu;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

public class Modele extends Observable {
	public static final Color[] COULEURS = { Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.RED,
			Color.ORANGE, Color.WHITE, Color.BLACK };
	public static final int N_TENTATIVES = 10;
	public static final int DIFFICULTE = 4;

	public static enum Etat {
		EN_COURS, GAGNE, PERDU
	};

	public Etat etat;
	public Rangee combinaison;
	public Rangee propEnCours; // @TODO ??
	public ArrayList<Rangee> propositions;
	public int tentative;

	public Modele() {
		etat = Etat.EN_COURS;
		combinaison = new Rangee();
		propEnCours = null;
		propositions = new ArrayList<>();
		tentative = 0;

		Random r = new Random();
		while (!combinaison.isCompleted()) {
			try {
				combinaison.pushColor(COULEURS[r.nextInt(COULEURS.length)]);
			} catch (Exception e) {
				throw new RuntimeException("Cannot push Color: " + e.getMessage());
			}
		}

		// @TODO Debug
		propositions.add(combinaison);
		propositions.add(combinaison);
		propositions.add(combinaison);
		propositions.add(combinaison);
		propositions.add(combinaison);
		propositions.add(combinaison);
	}
	
	public void submitRangee(Rangee rangee) {
		checkRangee(rangee);
		// @TODO get result from check and add it
		propositions.add(rangee);
		tentative++;
	}

	public Color[] checkRangee(Rangee rangee) {
		Color[] tr = new Color[Modele.DIFFICULTE];
		Color[] tc = combinaison.getJetons();
		Color[] rc = rangee.getJetons();

		for (int i = 0; i < rc.length; i++) {
			if (rc[i] == tc[i])
				tr[i] = Color.BLACK;

			else if (combinaison.contains(rc[i]))
				tr[i] = Color.WHITE;
			else
				tr[i] = null;
		}

		return tr;
	}
}