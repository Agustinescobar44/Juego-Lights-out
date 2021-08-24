package logica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class juegoTest {
	lightsOut game = new lightsOut(16);
	void setUp() throws Exception {
		
	}

	@Test
	void testSetearVecinos() {
		game.setearVecinos(4);
		assertEquals(2, game.dameVecinos(0).size());
		assertEquals(4, game.dameVecinos(7).size());
		assertEquals(2, game.dameVecinos(game.tamanio()-1).size());
	}

}
