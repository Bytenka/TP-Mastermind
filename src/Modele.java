public class Modele {
	private static final String[] couleurs = {
		"Jaune", "Vert", "Bleu", "Magenta", "Rouge", "Orange", "Blanc", "Noir"
	};
	
	private int n_tentatives = 0;
	private int difficulte = 4;
	private enum etat {
		EN_COURS,
		GAGNE,
		PERDU
	};
}