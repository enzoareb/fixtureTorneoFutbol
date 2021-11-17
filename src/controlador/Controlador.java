package controlador;


import java.util.ArrayList;
import archivosJSON.TorneoJSON;
import instancias.Arbitro;
import instancias.Equipo;
import instancias.Fecha;
import instancias.Torneo;
import logicaSolver.GeneradorRandom;
import logicaSolver.Solver;

public class Controlador {
	private Torneo torneo;

	public Controlador() {
		this.torneo  = TorneoJSON.leerJSON();
	}

	public int cantFechas() {
		return this.torneo.getFechas().size();
		
	}
	
	public int cantPartidos() {
		return torneo.cantEquipos()/2;
	}
	
	public int cantEquipos() {
		return torneo.cantEquipos();
	}
	
	public int cantArbitros() {
		return torneo.cantArbitros();
	}
	
	public ArrayList<String> getEquipos(){
		ArrayList<String> ret = new ArrayList<>();
		
		for(Equipo equipo : torneo.getEquipos()) {
			String nombre = equipo.getNombre();
			ret.add(nombre);
		}
		return ret;
			
	}
	
	public String darPartido(int fecha, int partido) {
		String equipo1 = fechas().get(fecha).getPartidos().get(partido).getEquipo1().getNombre();
		String equipo2 = fechas().get(fecha).getPartidos().get(partido).getEquipo2().getNombre();
		String ret = equipo1 + " vs " + equipo2;
		return ret;
	} 
	
	private ArrayList<Fecha> fechas(){
		ArrayList<Fecha> fechasTorneo = torneo.getFechas();
		return fechasTorneo;
	}

	public ArrayList<String> getArbitros() {
		ArrayList<String> ret = new ArrayList<>();
		
		for(Arbitro arbitro : torneo.getArbitros()) {
			String nombre = arbitro.getNombre();
			int numero = arbitro.getNumero();
			ret.add(numero + ": " + nombre );
		}
		return ret;
	}

	public String darArbitro(int fecha, int partido) {
		String arbitro = " ";
		if(torneo.getFechas().get(fecha).getPartidos().get(partido).tieneArbitro()) {
			int numero = torneo.getFechas().get(fecha).getPartidos().get(partido).getArbitro().getNumero();
			
			arbitro = torneo.getFechas().get(fecha).getPartidos().get(partido).getArbitro().getNombre();
			return "Arbitro(" + numero + "): " + arbitro;
		}
		return "-";
			
		
	}

	public void asignarArbitros() {
		Solver solver = new Solver(torneo);
		GeneradorRandom random = new GeneradorRandom();
		Solver.setGenerador(random);
		solver.asignarArbitrosAleatoriamente(random);
		
	}
	
}
