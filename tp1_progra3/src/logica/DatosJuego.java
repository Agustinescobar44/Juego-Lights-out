package logica;

public class DatosJuego {
	private int turnos=0;
	private int record=10000;
	
	public void modificarRecord(int num) {
		if( num<this.record) {
			this.record=num;
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

}
