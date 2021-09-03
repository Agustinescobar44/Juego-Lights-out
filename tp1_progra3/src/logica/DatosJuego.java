package logica;

import java.util.ArrayList;

public class DatosJuego {
	private int turnos=0;
	private int record=10000;
	
	private ArrayList<Integer> ranking=new ArrayList<Integer>();
	
	public void modificarRecord(int num) {
		if( num<this.record) {
			this.record=num;
		}
		if (!ranking.contains(num)) {
			ranking.add(num);
		}
	}
	
	public void modificarTurnos(int i) {
		this.turnos=i;
	}
	
	public int devolverRecord() {
		return this.record;
	}
	
	public int devolverTurnos() {
		return this.turnos;
	}
	
	public void agregarEnRanking() {
		//falta definir funcion
	}
	
	public ArrayList<Integer> devolverRanking(){
		return this.ranking;
	}

}
