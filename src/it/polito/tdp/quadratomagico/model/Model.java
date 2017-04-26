package it.polito.tdp.quadratomagico.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	List<Square> solutions = null;

	public List<Square> findMagicSquares(int dim) {

		solutions = new ArrayList<Square>();

		// Creo un oggetto Square
		Square square = new Square(dim);

		// Chiamo la funzione ricorsiva
		int step = 0;
		recursive(square, step);

		// ritorno tutte le soluzioni trovate
		return solutions;
	}

	private void recursive(Square square, int step) {
		
		if (step >= square.getN2()) {
			if (square.checkMagicConst()) {
				solutions.add(new Square(square));//se scrivessi solo add(square) sovrascriverei ogni volta la soluzione in quanto
												  //aggiungerei alla lista il riferimento sempre allo stesso oggetto square il quale
												  //cambia ogni volta che si chiama la funzione ricorsiva
			}
			return;
		}

		for (int i = 1; i <= square.getN2(); i++) {
			if (!square.contains(i)) {
				square.add(i);
				recursive(square, step + 1);
				square.remove(i);
			}
		}
	}
}
