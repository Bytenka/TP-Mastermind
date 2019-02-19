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
	public Rangee currentProp;
	public ArrayList<Rangee> propositions;
	public int tentative;

	public Modele() {
		etat = Etat.EN_COURS;
		combinaison = new Rangee();
		currentProp = new Rangee();

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

	public void submitColor(Color color) {
		try {
			currentProp.pushColor(color);
		} catch (Exception e) {
			throw new RuntimeException("Could not push color: " + e.getMessage());
		}

		if (currentProp.isCompleted()) {
			System.out.println("Proposition completed, setting results");
			currentProp.setResult(checkProp());
			propositions.add(currentProp);
			currentProp = new Rangee();
			tentative++;
		}
	}

	public Color[] checkProp() {
		Color[] toReturn = new Color[Modele.DIFFICULTE];

		Color[] combColors = combinaison.getJetons();
		Color[] propColors = currentProp.getJetons();

		// Iterate on colors, find matches
		for (int i = 0; i < combColors.length; i++) {
			if (combColors[i] == propColors[i])
				toReturn[i] = Color.BLACK;

			else if (combinaison.contains(propColors[i]))
				toReturn[i] = Color.WHITE;
			else
				toReturn[i] = null;
		}

		return toReturn;
	}
}