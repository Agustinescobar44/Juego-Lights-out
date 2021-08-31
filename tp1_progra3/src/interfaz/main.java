package interfaz;

import logica.DatosJuego;
import logica.lightsOut;

public class main {
	
	private static DatosJuego data=new DatosJuego();
	
	final public static void modificarTurnos(int num) {
		data.modificarTurnos(num);
	}
	
	final public static int devolverTurnos() {
		return data.devolverTurnos();
	}
	
	final public static void modificarRecord(int num) {
		data.modificarRecord(num);
	}
	
	final public static int devolverRecord() {
		return data.devolverRecord();
	}

	public static void main(String[] args) {
		ventana menu = new ventana();
		menu.mostrarse();		
	}

}
