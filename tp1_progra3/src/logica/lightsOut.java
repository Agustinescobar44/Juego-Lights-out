package logica;


public class lightsOut extends Grafo{

	public lightsOut(int i) {
		super(i);
	}
	
	public void setearVecinos(int columnas ) { 
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
	
	
	
}
