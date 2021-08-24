package logica;

public class lightsOut {

	Grafo juego = new Grafo(16);
	
	public lightsOut() {
		setearVecinos();
	}
	
	private void setearVecinos() {
		int contador= 1; 
		for (int i = 0; i < juego.tamanio(); i++) {
			if(contador != 4){
				juego.agregarArista(i, i+1); 
				juego.agregarArista(i, i+4);
				contador++;  
			}
			else if(contador==4){
				juego.agregarArista(i, i+4);
				contador=1;
			}
			else if (i<juego.tamanio()) { 
				juego.agregarArista(i, i+1);
			} 
		}
	}
	
	
	
}
