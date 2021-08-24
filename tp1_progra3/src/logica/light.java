package logica;

import java.util.Random;

public class light {
	
	boolean prendido;
	Random rd = new Random();
	
	public light() {
		prendido = rd.nextBoolean();
		
	}
	
	public void cambiarEstado() {
		this.prendido = !prendido;
	}
}
