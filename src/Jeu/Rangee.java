package Jeu;

import java.awt.Color;
import java.util.Iterator;

public class Rangee implements Iterable<Color> {
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

	@Override
	public Iterator<Color> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator {
		private int position = 0;
		
		@Override
		public boolean hasNext() {
			return position < Modele.DIFFICULTE;
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