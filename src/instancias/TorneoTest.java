package instancias;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;


import org.junit.Test;

public class TorneoTest {
	
	@Test
	public void todosLosArbitrosDisponiblesTest() {
		Torneo torneo = ejemploTorneo8equipos();
		assertEquals(4, torneo.getArbitrosDisponibles().get(torneo.getFechas().get(0)).size());
	}
	
	@Test
	public void arbitroConPromedioMinimoTest() {
		Torneo torneo = ejemploTorneo8equipos();
		int [][] arbitrajesPorEquipo = generarArbitrajeMinimoEjemplo();
		torneo.setArbitrajesPorEquipo(arbitrajesPorEquipo);	
		assertEquals(3, torneo.arbitroConPromedioMinimo(torneo.getEquipos().get(0), torneo.getEquipos().get(1)) );
	}
	
	

	@Test
	public void agregarArbitrosDistintosTest() {
		Torneo torneo = ejemploTorneo8equipos();
		Fecha fecha = torneo.getFechas().get(0);
		Partido partido1 = torneo.getFechas().get(0).getPartidos().get(0);
		Partido partido2 = torneo.getFechas().get(0).getPartidos().get(1);
		Arbitro arbitro1 = new Arbitro(2,"");
		Arbitro arbitro2 = new Arbitro(1,"");
		torneo.agregarArbitraje(fecha, partido1, arbitro1.getNumero());
		torneo.agregarArbitraje(fecha, partido2, arbitro2.getNumero());
		assertEquals(2, torneo.getArbitrosDisponibles().get(torneo.getFechas().get(0)).size());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void agregarMismosArbitrosMismoPartidoTest() {
		Torneo torneo = ejemploTorneo8equipos();
		Fecha fecha = torneo.getFechas().get(0);
		Partido partido1 = torneo.getFechas().get(0).getPartidos().get(0);
		Partido partido2 = torneo.getFechas().get(0).getPartidos().get(1);
		Arbitro arbitro1 = new Arbitro(2,"");
		Arbitro arbitro2 = new Arbitro(2,"");
		torneo.agregarArbitraje(fecha, partido1, arbitro1.getNumero());
		torneo.agregarArbitraje(fecha, partido2, arbitro2.getNumero());
	}
	
	@Test (expected=RuntimeException.class)
	public void agregarDiferentesArbitrosMismoPartidoTest() {
		Torneo torneo = ejemploTorneo8equipos();
		Fecha fecha = torneo.getFechas().get(0);
		Partido partido1 = torneo.getFechas().get(0).getPartidos().get(0);
		Partido partido2 = torneo.getFechas().get(0).getPartidos().get(0);
		Arbitro arbitro1 = new Arbitro(2,"");
		Arbitro arbitro2 = new Arbitro(1,"");
		torneo.agregarArbitraje(fecha, partido1, arbitro1.getNumero());
		torneo.agregarArbitraje(fecha, partido2, arbitro2.getNumero());
	}
	
	
	@Test
	public void cantPartidosTest() {
		Torneo torneo = ejemploTorneo8equipos();
		assertEquals(4, torneo.getFechas().get(0).getPartidos().size());
	}
	
	@Test
	public void fechasinEquiposRepetidosTest() {
		Torneo torneo = ejemploTorneo8equipos();
		ArrayList<Fecha> fechas = torneo.getFechas();
		Assert.sinRepetidos(fechas,toset(torneo.getEquipos()));
	}
	
	@Test
	public void cantEquiposTest() {
		Torneo torneo = ejemploTorneo8equipos();
		assertEquals(8, torneo.getEquipos().size());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void cantEquiposImparTest() {
		Torneo torneo = new Torneo();
		torneo.agregarEquipo("PERON FUTBOL CLUB");
		torneo.generarFixture();
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void sinEquiposTest() {
		Torneo torneo = new Torneo();
		torneo.generarFixture();
	}
	
	@Test
	public void cantFechasTest() {
		Torneo torneo = ejemploTorneo8equipos();
		assertEquals(7, torneo.getFechas().size());
	}
	
	@Test
	public void sinFechasTest() {
		Torneo torneo = new Torneo();
		assertEquals(0, torneo.getFechas().size());
	}
	
	public Torneo ejemploTorneo8equipos() {
		Torneo torneo = new Torneo();
		torneo.agregarEquipo("river");
		torneo.agregarEquipo("boca");
		torneo.agregarEquipo("independiente");
		torneo.agregarEquipo("racing");
		torneo.agregarEquipo("san lorenzo");
		torneo.agregarEquipo("huracan");
		torneo.agregarEquipo("estudiantes");
		torneo.agregarEquipo("gimnasia");
		torneo.generarFixture();
		
		return torneo;
	}
	
	private HashSet<Equipo> toset(ArrayList<Equipo> equipos) {
		HashSet<Equipo> retEquipos = new HashSet<>();
		for (Equipo equipo : equipos) {
			if (!retEquipos.contains(equipo))
				retEquipos.add(equipo);
		}
		return retEquipos;
	}
	
	private int[][] generarArbitrajeMinimoEjemplo() {
		int [][] ret = {{1,1,1,0},{1,1,1,0},{2,2,2,2},{2,2,2,2},{2,2,2,2},{2,2,2,2},{2,2,2,2},{2,2,2,2}};
		return ret;
	}
	
	

}
