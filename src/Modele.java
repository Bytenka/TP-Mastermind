import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Modele {
	public static final Color[] COULEURS = { Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.RED,
			Color.ORANGE, Color.WHITE, Color.BLACK };
	public static final int N_TENTATIVES = 10;
	public static final int DIFFICULTE = 4;

	public static enum Etat {
		EN_COURS, GAGNE, PERDU
	};

	private Etat etat;
	private Rangee combinaison;
	private ArrayList<Rangee> propositions;
	private int tentative;

	public Modele() {
		etat = Etat.EN_COURS;
		combinaison = new Rangee();
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
	}
}