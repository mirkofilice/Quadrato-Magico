package it.polito.tdp.quadratomagico.model;

import java.util.ArrayList;
import java.util.List;

public class Square {

	// List come struttura dati per la mia griglia
	private List<Integer> griglia = null;
	private int N;
	private int N2;
	private int magicConst;

	public Square(Square square) {
		this.griglia = new ArrayList<Integer>(square.getGriglia());
		this.N = square.getN();
		this.N2 = square.getN2();
		this.magicConst = square.getMagicConst();
	}
	
	public Square(int dimension) {
		this.griglia = new ArrayList<Integer>();
		this.N = dimension;
		this.N2 = N * N;
		this.magicConst = N * (N * N + 1) / 2;
	}

	public List<Integer> getGriglia() {
		return griglia;
	}
	
	public int getN() {
		return N;
	}
	
	public int getN2() {
		return N2;
	}
	
	public int getMagicConst() {
		return magicConst;
	}

	public boolean contains(int number) {
		return griglia.contains(number);
	}

	public void add(int number) {
		griglia.add(number);
	}

	public void remove(int pos) {
		griglia.remove(pos);
	}

	public boolean checkMagicConst() {
		if (griglia.size() != N2){
			return false;
		}
		
		// Controllare le righe
		if (!checkRows())
			return false;
		
		// Controllare le colonne
		if (!checkColumns())
			return false;
		
		// Controllare le diagonali
		if (!checkDiagonals()){
			return false;
		}
		
		return true;
	}
	
	private boolean checkRows(){
//		matrice[i][j]
//		array[i*n + j]
		
//		0,0 0,1 0,2
//		1,0 1,1 1,2
//		2,0 2,1 2,2
		
//		0 1 2  3 = (1,0)....8
		
		for (int i = 0; i < N; i++){
			int tmp = 0;
			for (int j = 0; j < N; j++) {
				tmp += griglia.get(i*N + j);
			}
			if (tmp != magicConst)
				return false;
		}
		
		return true;
	}
	
	private boolean checkColumns(){
		
//		0,0 0,1 0,2
//		1,0 1,1 1,2
//		2,0 2,1 2,2
		
		for (int i = 0; i < N; i++){
			int tmp = 0;
			for (int j = 0; j < N; j++) {
				tmp += griglia.get(j*N + i);
			}
			if (tmp != magicConst)
				return false;
		}

		return true;
	}
	
	private boolean checkDiagonals(){
//		0,0 0,1 0,2
//		1,0 1,1 1,2
//		2,0 2,1 2,2
		
		int tmp = 0;
		for (int i = 0; i< N ; i++)
			tmp += griglia.get(i*N + i);
		
		if (tmp != magicConst)
			return false;
		
		tmp = 0;
		for (int i = N-1; i>=0; i--){
			tmp += griglia.get((N-1-i)*N + i);
		}
		
		return true;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(String.format("%d ", griglia.get(i * N + j)));
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
