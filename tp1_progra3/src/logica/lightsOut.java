package logica;

public class lightsOut {

	Grafo juego;
	
	public lightsOut(int i) {
		juego =  new Grafo(i);
		setearVecinos();
		System.out.println(juego.dameVecinos(1));
	}
	
	private void setearVecinos() { 
		for (int i = 0; i < juego.tamanio(); i++) {
			if(i+1<juego.tamanio()-1) {
				if (i+1>=juego.tamanio()-6) { 
					juego.agregarArista(i, i+1);
				} 
				else if(i+1 % 4 != 0){
					juego.agregarArista(i, i+1); 
					juego.agregarArista(i, i+4);
				}
				
				else{
					juego.agregarArista(i, i+4);
				}
			}
			
		}
	}
	
	
	
}
