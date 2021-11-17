package logicaSolver;

import archivosJSON.TorneoJSON;
import instancias.Fecha;
import instancias.Partido;
import instancias.Torneo;

public class Solver {
	private Torneo torneo;
	private static Generador random;
	
	
	public Solver(Torneo torneo) {
		this.torneo = torneo;
	}
	
	public void asignarArbitros() {
		
		for ( Fecha fecha : torneo.getFechas() ) {
			
			for ( Partido partido: fecha.getPartidos()) {
				
				int indiceArbitro = torneo.arbitroConPromedioMinimoDisponible(fecha, partido.getEquipo1(), partido.getEquipo2());
				
				torneo.agregarArbitraje(fecha, partido, indiceArbitro);
			}
		}			
	}
	
	public void asignarArbitrosAleatoriamente(Generador generador) {

		int j = 0;
		while (j < torneo.getFechas().size()) {
			Fecha fechaRandom = darFechaRandomSinArbitrosEnPartidos(generador);

			int i = 0;
			while (i < fechaRandom.getPartidos().size()) {

				Fecha fecha = torneo.getFechas().get(j);
				Partido partidoRandom = darPartidoRandomSinArbitro(fecha,generador);
				int indiceArbitro = torneo.arbitroConPromedioMinimoDisponible(fecha, partidoRandom.getEquipo1(),partidoRandom.getEquipo2());
				torneo.agregarArbitraje(fecha, partidoRandom, indiceArbitro);
				i++;
			}
			j++;
		}

	}
	
	private Partido darPartidoRandomSinArbitro(Fecha fecha,Generador generador) {
		if(fecha.partidosSinArbitro().size() > 0) {
			int indiceRand = random.nextInt(fecha.partidosSinArbitro().size());
			return fecha.partidosSinArbitro().get(indiceRand);
		}
		else {
			return fecha.partidosSinArbitro().get(0);
		}
	}
	
	private Fecha darFechaRandomSinArbitrosEnPartidos(Generador generador) {
		if(torneo.fechasSinArbitro().size() > 0) {
			int indiceRand = random.nextInt(torneo.fechasSinArbitro().size());
			return torneo.fechasSinArbitro().get(indiceRand);
		}
		else {
			return torneo.fechasSinArbitro().get(0);
		}
	}
	
	public static void setGenerador(Generador generador) {
		random = generador;
	}
	
	public static void imprimir(Torneo torneo) {
		System.out.println();
		System.out.println("|----------Fechas------------|");
		System.out.println();
		for (Fecha fecha : torneo.getFechas()) {
			System.out.println("Fecha: " + fecha.getNumero() + "\n " + fecha.getPartidos());
			System.out.println();
		
		}
		
		System.out.println("Tabla de arbitrajes Equipos x Arbitros");
		System.out.println("|---------------------------------------|");
		
		for (int i = 0; i < torneo.getArbitrajesPorEquipo().length; i++) {
			for (int j = 0; j < torneo.getArbitrajesPorEquipo()[i].length; j++) {
				
				System.out.print(torneo.getArbitrajesPorEquipo()[i][j]);	
			}
			System.out.println();
		}
		
		System.out.println("Arbitros");
		System.out.println("|---------------------------------------|");
		System.out.println(torneo.getArbitros());
		
		
	
	}
	
	
}
