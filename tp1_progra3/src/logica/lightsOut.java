package logica;


import java.util.Set;

public class lightsOut{

	
	private light[] luces;
	private Grafo mapa;
	
	public lightsOut(int i) {
		mapa = new Grafo(i*i);
		luces = new light[i*i];
		for (int j = 0; j < i*i; j++) {
			luces[j] = new light();
		}
		setearVecinos(i);
	}
	 
	/**
	 * 
	 * @param columnas
	 */
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
		luces[i].cambiarEstado();
		Set<Integer> vecinos= mapa.dameVecinos(i);
		for (Integer integer : vecinos) {
			luces[integer].cambiarEstado();
		}
	}

	public boolean isGanador() {

        for (light light : luces) {
            if (light.prendido)
                return false;
        }
        return true;
    }
	public boolean estaPrendida(int i ) {
		return luces[i].prendido;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		int contador=1;
		for (int i = 0; i < luces.length; i++) {
			
			builder.append(luces[i]);
			builder.append("-");
			if(contador%4 == 0 )
				builder.append("\n");
			contador++;
		}
		return builder.toString();
	}

	public Set<Integer> dameVecinos(int i) {
		return mapa.dameVecinos(i);
	}

	public int tamanio() {
		return mapa.tamanio();
	}
	
	
	
	
}
