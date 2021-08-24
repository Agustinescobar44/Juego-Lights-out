package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class Grafo {
	
	//representamos un grafo con lista de vecinos 
	private ArrayList<HashSet<Integer>> LV;
	
	//la cantidad de vertice esta dada por el constructor
	public Grafo(int vertices) {
		LV = new ArrayList<HashSet<Integer>>();
		for (int i = 0; i < vertices; i++) {
			LV.add(new HashSet<Integer>());
		}
	}
	
	//agregar arista
	public void agregarArista(int i, int j) {
		verificarLoop(i, j);
		verificarVerticeValido(i);
		verificarVerticeValido(j);
		
		LV.get(i).add(j);
		LV.get(j).add(i);
	}
	//existe arista
	public boolean existeArista(int i, int j) {
		verificarLoop(i, j);
		verificarVerticeValido(i);
		verificarVerticeValido(j);
		
		return LV.get(i).contains(j);
	}
	
	//eliminar arista
	public void eliminarArista(int i, int j ) {
		
		verificarLoop(i, j);
		verificarVerticeValido(i);
		verificarVerticeValido(j);
		
		if(existeArista(i, j)) {
			LV.get(i).remove(j);
			LV.get(j).remove(i);
		}
	}
	
	//cantidad de vertices
	public int tamanio() {
		return LV.size();
	}
	
	// devolver los vecinos
	public Set<Integer> dameVecinos(int i ){
		return LV.get(i);
	}
	
	
	
	/*
	//representamos un grafo con matriz de adyacencia
	private boolean[][] A;
	
	
	// La cantidad de vertices esta predeterminada desde el contructor
	public Grafo(int vertices){
		A = new boolean[vertices][vertices];
	}
	
	
	//agregar una arista
	 
	 
	
	public void agregarArista(int i , int j) {
		
		//a esto se le llama codigo defensivo
		verificarVerticeValido(i);
		verificarVerticeValido(j);
		verificarLoop(i, j);	
		
		A[i][j] = true;
		A[j][i] = true;
	}
	//existe arista
	public boolean existeArista(int i, int j ) {
		//codigo defensivo
		verificarVerticeValido(i);
		verificarVerticeValido(j);
		verificarLoop(i, j);
		
		return A[i][j];
	}
	//eliminar aristas
	public void eliminarArista(int i, int j ) {
		//codigo defensivo
		verificarVerticeValido(i);
		verificarVerticeValido(j);
		verificarLoop(i, j);
		
		A[i][j] = false;
		A[j][i] = false;
	}
	
	// Cantidad de vertices 
	public int tamanio() {
		return A.length;
	}
	
	//Vecinos de un vertice
	public Set<Integer> dameVecinos(int i){
		
			verificarVerticeValido(i);
			
			Set<Integer> vecinos = new HashSet<>();
			
			for (int j = 0; j < tamanio(); j++) {
				
				if(i!=j) 
					if(existeArista(i, j))
						vecinos.add(j);
			
			}
			
			return vecinos;
	}
	
	*/
	
	

	//verificacion de vertices
	private void verificarLoop(int i, int j) {
		if(i==j)
			throw new IllegalArgumentException("No se permiten loops: ("+i + ", "+j+") ");
	}
	private void verificarVerticeValido(int i) {
			if(i<0) 
				throw new IllegalArgumentException("El vertice no puede ser negativo: "+ i);
			if(i>= LV.size())
				throw new IllegalArgumentException("Los vertices deben estar entre 0 y " + (LV.size()-1) + "este: " +i);
	}
}
