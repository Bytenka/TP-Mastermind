package Jeu;

import java.awt.Color;
import java.util.Arrays;
import java.util.Iterator;

public class Rangee implements Iterable<Color> {
	private Color[] jetons;
	private Color[] result;
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

	public Color[] getJetons() {
		return jetons;
	}
	
	public void setResult(Color[] result) {
		this.result = result;
	}
	
	public Color[] getResult() {
		return result;
	}

	public boolean contains(Color c) {
		for (int i = 0; i < jetons.length; i++) {
			if (c.equals(jetons[i]))
				return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object other) {
		return Arrays.equals(jetons, ((Rangee)other).getJetons());
	}

	@Override
	public Iterator<Color> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator {
		private int position = 0;

		@Override
		public boolean hasNext() {
			return position < indiceJeton;
		}

		@Override
		public Color next() {
			return jetons[position++];
		}

		@Override
		public void remove() {
		}
	}

	/*
	 * If necessary, uncomment
	 * 
	 * @Override public String toString() { String tr = ""; for (Color c : jetons)
	 * tr += c.toString(); return tr; }
	 */
}