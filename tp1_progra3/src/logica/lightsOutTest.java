package logica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class lightsOutTest {
	lightsOut game = new lightsOut(4);

	
	@Test
	void testSetearVecinosCon5Columnas() {
		game= new lightsOut(5);
		assertEquals(2, game.dameVecinos(0).size()); //esquina arriba izquierda
		assertEquals(2, game.dameVecinos(4).size()); //esquina arriba derecha
		assertEquals(3, game.dameVecinos(5).size()); //costado izquierda
		assertEquals(4, game.dameVecinos(6).size()); // centro
		assertEquals(3, game.dameVecinos(9).size()); //costado derecha
		assertEquals(2, game.dameVecinos(game.tamanio()-1).size()); // esquina abajo derecha
		assertEquals(2, game.dameVecinos(game.tamanio()-1-4).size()); // esquina abajo izquierda
	}
	@Test
	void testSetearVecinosCon3Columnas() {
		game= new lightsOut(3);
		assertEquals(2, game.dameVecinos(0).size()); //esquina arriba izquierda
		assertEquals(2, game.dameVecinos(2).size()); //esquina arriba derecha
		assertEquals(3, game.dameVecinos(3).size()); //costado izquierda
		assertEquals(4, game.dameVecinos(4).size()); // centro
		assertEquals(3, game.dameVecinos(5).size()); //costado derecha
		assertEquals(2, game.dameVecinos(game.tamanio()-1).size()); // esquina abajo derecha
		assertEquals(2, game.dameVecinos(game.tamanio()-1-2).size()); // esquina abajo izquierda
	}
	@Test
	void testSetearVecinosCon4Columnas() {
		lightsOut game = new lightsOut(4);
		assertEquals(2, game.dameVecinos(0).size()); //esquina arriba izquierda
		assertEquals(2, game.dameVecinos(3).size()); //esquina arriba derecha
		assertEquals(3, game.dameVecinos(4).size()); //costado izquierda
		assertEquals(4, game.dameVecinos(5).size()); // centro
		assertEquals(3, game.dameVecinos(7).size()); //costado derecha
		assertEquals(2, game.dameVecinos(game.tamanio()-1).size()); // esquina abajo derecha
		assertEquals(2, game.dameVecinos(game.tamanio()-1-3).size()); // esquina abajo izquierda
	}
	@Test
	void testVecinos() {
		assertEquals(2, game.dameVecinos(3).size());
	}
	@Test 
	void testCambiarLucesEsquinaIzquierda() {
		boolean luz = game.estaPrendida(0); //esquina izquierda
		boolean luz2 = game.estaPrendida(1); //derecha 
		boolean luz3 = game.estaPrendida(4); //abajo
		game.cambiarLuces(0);
		assertNotEquals(luz, game.estaPrendida(0));
		assertNotEquals(luz2, game.estaPrendida(1));
		assertNotEquals(luz3, game.estaPrendida(4));
	}
	@Test 
	void testCambiarLucesEsquinaDerecha() {
		//tablero 4x4
		boolean luz = game.estaPrendida(3); //esquina derecha
		boolean luz2 = game.estaPrendida(2); //izquierda
		boolean luz3 = game.estaPrendida(7); //abajo
		game.cambiarLuces(3);
		assertNotEquals(luz, game.estaPrendida(3));
		assertNotEquals(luz2, game.estaPrendida(2));
		assertNotEquals(luz3, game.estaPrendida(7));
	}
	@Test 
	void testCambiarLucesCostadoIzquierda() {
		boolean luz = game.estaPrendida(0); //arriba
		boolean luz2 = game.estaPrendida(4); //centro
		boolean luz3 = game.estaPrendida(5); // derecha
		boolean luz4 = game.estaPrendida(8); //abajo
		game.cambiarLuces(4);
		assertNotEquals(luz, game.estaPrendida(0));
		assertNotEquals(luz2, game.estaPrendida(4));
		assertNotEquals(luz3, game.estaPrendida(5));
		assertNotEquals(luz4, game.estaPrendida(8));
	}
	@Test 
	void testCambiarLucesCostadoDerecha() {
		boolean luz = game.estaPrendida(3); //arriba
		boolean luz2 = game.estaPrendida(6); //izquierda
		boolean luz3 = game.estaPrendida(7); //centro
		boolean luz4 = game.estaPrendida(11); //abajo
		game.cambiarLuces(7);
		assertNotEquals(luz, game.estaPrendida(3));
		assertNotEquals(luz2, game.estaPrendida(6));
		assertNotEquals(luz3, game.estaPrendida(7));
		assertNotEquals(luz4, game.estaPrendida(11));
	}
	@Test 
	void testCambiarLucesCentro() {
		boolean luz = game.estaPrendida(1); //arriba
		boolean luz2 = game.estaPrendida(4); //izquierda
		boolean luz3 = game.estaPrendida(5); //centro
		boolean luz4 = game.estaPrendida(6); //derecha
		boolean luz5 = game.estaPrendida(9); //abajo
		game.cambiarLuces(5);
		assertNotEquals(luz, game.estaPrendida(1));
		assertNotEquals(luz2, game.estaPrendida(4));
		assertNotEquals(luz3, game.estaPrendida(5));
		assertNotEquals(luz4, game.estaPrendida(6));
		assertNotEquals(luz5, game.estaPrendida(9));
	}
}
