package logica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class juegoTest {
	lightsOut game = new lightsOut(16);
	void setUp() throws Exception {
		
	}

	@Test
	void testSetearVecinosCon4Columnas() {
		game.setearVecinos(4);
		assertEquals(2, game.dameVecinos(0).size());
		assertEquals(4, game.dameVecinos(7).size());
		assertEquals(2, game.dameVecinos(game.tamanio()-1).size());
	}
	@Test
	void testSetearVecinosCon5Columnas() {
		game.setearVecinos(5);
		assertEquals(2, game.dameVecinos(0).size());
		assertEquals(4, game.dameVecinos(6).size());
		assertEquals(4, game.dameVecinos(8).size());
		assertEquals(2, game.dameVecinos(game.tamanio()-1).size());
	}
	@Test
	void testSetearVecinosCon3Columnas() {
		game.setearVecinos(3);
		assertEquals(2, game.dameVecinos(0).size());
		assertEquals(4, game.dameVecinos(5).size());
		assertEquals(2, game.dameVecinos(game.tamanio()-1).size());
	}

}
