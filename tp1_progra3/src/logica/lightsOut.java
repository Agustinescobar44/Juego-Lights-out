package logica;


import java.util.Set;

public class lightsOut extends Grafo{

	
	light[] luces;
	
	public lightsOut(int i) {
		super(i*i);
		luces = new light[i*i];
		for (int j = 0; j < i*i; j++) {
			luces[j] = new light();
		}
		setearVecinos(i);
	}
	 
	/**
	 * genera una cuadrilla con la cantidad de columnas que le pasamos por 
	 * parametro
	 * 
	 * ej 4 columnas 
	 * 
	 *  0-0-0-0
	 *  0-0-0-0
	 *  0-0-0-0 
	 *  0-0-0-0
	 * 
	 * @param columnas
	 */
	private void setearVecinos(int columnas ) { 
		for (int i = 0; i < tamanio(); i++) {
			
			if(i<tamanio()-1) {
				if (i>tamanio()-(columnas+1)) { 
					agregarArista(i, i+1);
				} 
				else if(i+1 % columnas != 0){
					agregarArista(i, i+1); 
					agregarArista(i, i+columnas);
				}
				
				else{
					agregarArista(i, i+columnas);
				}
			}
			
		}
	}
	
	public void cambiarLuces(int i) {
		Set<Integer> vecinos= dameVecinos(i);
		luces[i].cambiarEstado();
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

	
	
	
	
}
