package logicaSolver;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import instancias.Fecha;
import instancias.Torneo;

public class SolverTest {
		
	@Test
	public void todasFechasSinArbitrosDisponiblesTest() {
		Torneo torneo = ejemploTorneo8equipos();
		Solver solver = new Solver(torneo);
		solver.asignarArbitros();
		assertEquals(0, cantArbitroDIsponibles(torneo.getArbitrosDisponibles()));
	}
	
	@Test
	public void todasFechasSinArbitrosDisponiblesAleatoriosTest() {
		Torneo torneo = ejemploTorneo8equipos();
		Solver solver = new Solver(torneo);
		GeneradorRandom random = new GeneradorRandom();
		Solver.setGenerador(random);
		solver.asignarArbitrosAleatoriamente(random);
		
		assertEquals(0, cantArbitroDIsponibles(torneo.getArbitrosDisponibles()));
	}

	private int cantArbitroDIsponibles(HashMap<Fecha, ArrayList<Integer>> arbitrosDisponibles) {
		int ret = 0;
		for (Fecha fecha : arbitrosDisponibles.keySet()) {
			ret = ret + arbitrosDisponibles.get(fecha).size();
		}
		return ret;
	}

	public Torneo ejemploTorneo8equipos() {
		Torneo torneo = new Torneo();
		torneo.agregarEquipo("UNO");
		torneo.agregarEquipo("DOS");
		torneo.agregarEquipo("TRES");
		torneo.agregarEquipo("CUATRO");
		torneo.agregarEquipo("CINCO");
		torneo.agregarEquipo("SEIS");
		torneo.agregarEquipo("SIETE");
		torneo.agregarEquipo("OCHO");
		torneo.generarFixture();
		
		return torneo;
	}

}
