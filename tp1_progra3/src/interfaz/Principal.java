package interfaz;

import java.util.ArrayList;

import logica.DatosJuego;
import logica.lightsOut;

public class Principal {

    private static boolean tableroArmado=false;
	
	final private static DatosJuego data=new DatosJuego();
	
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
	
	final public static ArrayList<Integer> devolverRanking(){
		return data.devolverRanking();
	}

    final public static boolean esTableroArmado() {
		return tableroArmado;
	}
   
    final public static void tableroArmado(boolean i) {
    	tableroArmado=i;
    }

	public static void main(String[] args) {
		Ventana menu = new Ventana();
		menu.mostrarse();	
}

}
