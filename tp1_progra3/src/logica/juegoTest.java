package logica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class juegoTest {
	lightsOut game = new lightsOut(4);
	void setUp() throws Exception {
		
	}

	@Test
	void testSetearVecinosCon4Columnas() {
		assertEquals(2, game.dameVecinos(0).size());
		assertEquals(4, game.dameVecinos(5).size());
		assertEquals(2, game.dameVecinos(game.tamanio()-1).size());
	}
	@Test
	void testSetearVecinosCon5Columnas() {
		game= new lightsOut(5);
		assertEquals(2, game.dameVecinos(0).size());
		assertEquals(4, game.dameVecinos(6).size());
		assertEquals(4, game.dameVecinos(8).size());
		assertEquals(2, game.dameVecinos(game.tamanio()-1).size());
	}
	@Test
	void testSetearVecinosCon3Columnas() {
		game= new lightsOut(3);
		assertEquals(2, game.dameVecinos(0).size());
		assertEquals(4, game.dameVecinos(4).size());
		assertEquals(2, game.dameVecinos(game.tamanio()-1).size());
	}
	@Test
	void testVecinos() {
		game= new lightsOut(4);
		assertEquals(2, game.dameVecinos(3).size());
	}
	@Test 
	void testCambiarLuces() {
		game = new lightsOut(4);
		boolean luz = game.estaPrendida(0);
		boolean luz2 = game.estaPrendida(1);
		boolean luz3 = game.estaPrendida(4);
		game.cambiarLuces(0);
		assertNotEquals(luz, game.estaPrendida(0));
		assertNotEquals(luz2, game.estaPrendida(1));
		assertNotEquals(luz3, game.estaPrendida(4));
	}
}
