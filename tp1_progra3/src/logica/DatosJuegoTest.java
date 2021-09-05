package logica;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class DatosJuegoTest {
	DatosJuego data=new DatosJuego();
	
	@Test
	void testModificarRecord() {
		data.modificarRecord(1);
		data.modificarRecord(2);
		assertEquals(1,data.devolverRecord());
	}

	@Test
	void testModificarTurnos() {
		data.modificarTurnos(1);
		data.modificarTurnos(data.devolverTurnos()+2);
		assertEquals(3, data.devolverTurnos());
	}

	@Test
	void testDevolverRanking() {
		data.modificarRecord(4);
		data.modificarRecord(2);
		ArrayList<Integer> esperado=new ArrayList<Integer>();
		esperado.add(2);
		esperado.add(4);
		assertEquals(esperado,data.devolverRanking());
	}

}
