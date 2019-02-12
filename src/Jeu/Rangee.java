package Jeu;
import java.awt.Color;

public class Rangee {
	private Color[] jetons;
	private int indiceJeton = 0;

	public Rangee() {
		jetons = new Color[Modele.DIFFICULTE];
	}

	public void pushColor(Color color) throws Exception {
		if (indiceJeton == Modele.DIFFICULTE)
			throw new Exception("Rangee is full");
		
		jetons[indiceJeton++] = color;
	}
	
	public boolean isEmpty() {
		return indiceJeton == 0;
	}
	
	public boolean isCompleted() {
		return indiceJeton == Modele.DIFFICULTE;
	}
	
	/* If necessary, uncomment
	@Override
	public String toString()
	{
		String tr = "";
		for (Color c : jetons)
			tr += c.toString();
		return tr;
	}
	*/
}