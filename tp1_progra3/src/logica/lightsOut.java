package logica;


import java.util.Random;
import java.util.Set;

public class lightsOut{

	private Random rd = new Random();
	private Boolean[] luces;
	private Grafo mapa;
	
	public lightsOut(int i) {
		mapa = new Grafo(i*i);
		luces = new Boolean[i*i];
		for (int j = 0; j < i*i; j++) {
			luces[j] = rd.nextBoolean();
		}
		setearVecinos(i);
	}

    public lightsOut(int i, int j) {
		mapa = new Grafo(i*i);
		luces = new Boolean[i*i];
		for (int k = 0; k <i*i; k++) {
			luces[k] = false;
		}
		luces[0]=true;
		luces[1]=true;
		luces[3]=true;
		setearVecinos(i);
		for(int k=1;k<j;k++) {
			int indiceRandom=(int) (Math.random()*(luces.length-1));
			this.cambiarLuces(indiceRandom);
		}
	}
	 
	private void setearVecinos(int columnas ) { 
		for (int i = 0; i < mapa.tamanio(); i++) {
			if(i<mapa.tamanio()-1) {
				if (i>mapa.tamanio()-(columnas+1)) { 
					mapa.agregarArista(i, i+1);
				} 
				else if(((i+1) % columnas) != 0){
					
					mapa.agregarArista(i, i+1); 
					mapa.agregarArista(i, i+columnas);
				}
				
				else{
					mapa.agregarArista(i, i+columnas);
				}
			}
			 
		}
	}
	
	public void cambiarLuces(int i) {
		luces[i] = !luces[i];
		Set<Integer> vecinos= mapa.dameVecinos(i);
		for (Integer integer : vecinos) {
			luces[integer]= !luces[integer];
		}
	}

	public boolean isGanador() {

        for (Boolean luz : luces) {
            if (luz)
                return false;
        }
        return true;
    }
	public boolean estaPrendida(int i ) {
		return luces[i];
	}

	public Set<Integer> dameVecinos(int i) {
		return mapa.dameVecinos(i);
	}

	public int tamanio() {
		return mapa.tamanio();
	}
	
	
	
	
}
