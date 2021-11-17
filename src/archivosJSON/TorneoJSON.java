package archivosJSON;

import java.util.ArrayList;
import java.util.HashMap;

import instancias.Arbitro;
import instancias.Equipo;
import instancias.Fecha;
import instancias.Torneo;

public class TorneoJSON {
	private Torneo torneo;
	
	public TorneoJSON(Torneo torneo) {
		this.torneo = torneo;
	}
	
	public Torneo dame() {
		return torneo;
	}
	
	
	public void generarJSON() {	
		
		//---------------------------------------------------------------------------//
	    //Recorremos los equipos y generamos el json para el ArrayList de equipos
		EquipoJSON equiposJson = new EquipoJSON();
		for (Equipo equipo : torneo.getEquipos()) {
			equiposJson.agregarAEquiposJson(equipo);
		}
		equiposJson.generarJSON("src/archivosJSON/EquiposJsonPretty.JSON");
		
		//---------------------------------------------------------------------------//
		//Recorremos las fechas y generamos el json para el ArrayList de fechas
		FechaJSON fechasJson = new FechaJSON();
		for (Fecha fecha : torneo.getFechas()) {
			fechasJson.agregarAFechasJson(fecha);
		}
		fechasJson.generarJSON("src/archivosJSON/FechasJsonPretty.JSON");
		//---------------------------------------------------------------------------//
		//Recorremos los arbitros y generamos el json para el ArrayList de arbitros
		ArbitroJSON arbitrosJson = new ArbitroJSON();
		for (Arbitro arbitro : torneo.getArbitros()) {
			arbitrosJson.agregarAArbitrosJson(arbitro);
		}
		arbitrosJson.generarJSON("src/archivosJSON/ArbitrosJsonPretty.JSON");
		//---------------------------------------------------------------------------//
		//Generamos el json de la matriz de arbitrajes
		ArbitrajesEquiposJSON arbitrajesJson = new ArbitrajesEquiposJSON(torneo);
		arbitrajesJson.generarJSON("src/archivosJSON/ArbitrajesEquiposJsonPretty.JSON");
		//---------------------------------------------------------------------------//
		//Generamos el json del Map de arbitrosDisponibles
		ArbitrosDisponiblesJSON arbitrosDisponiblesJson = new ArbitrosDisponiblesJSON(torneo);
		arbitrosDisponiblesJson.generarJSON("src/archivosJSON/ArbitrosDisponiblesJsonPretty.JSON");
	
	}
	
	
	
	public static Torneo leerJSON()
	{
		Torneo ret = new Torneo();
		
		//-------------------traigo devuelta a los equipos----------------------//
		EquipoJSON equiposJson = EquipoJSON.leerJSON("src/archivosJSON/EquiposJsonPretty.JSON");
		ArrayList<Equipo> equipos = equiposJson.dame();
		ret.setEquipos(equipos);
		//-------------------traigo devuelta a los arbitros----------------------//
		ArbitroJSON arbitrosJson = ArbitroJSON.leerJSON("src/archivosJSON/ArbitrosJsonPretty.JSON");
		ArrayList<Arbitro> arbitros = arbitrosJson.dame();
		ret.setArbitros(arbitros);
		//-------------------traigo devuelta a los fechas----------------------//
		FechaJSON fechasJson = FechaJSON.leerJSON("src/archivosJSON/FechasJsonPretty.JSON");
		ArrayList<Fecha> fechas = fechasJson.dame();
		ret.setFechas(fechas);
		//-------------------traigo devuelta a los matriz de arbitrajes----------------------//
		ArbitrajesEquiposJSON arbitrajesJson = ArbitrajesEquiposJSON.leerJSON("src/archivosJSON/ArbitrajesEquiposJsonPretty.JSON");
		int[][] arbitrajes = arbitrajesJson.dame();
		ret.setArbitrajesPorEquipo(arbitrajes);
		//-------------------traigo devuelta a los map de arbitros disponibles----------------------//
		ArbitrosDisponiblesJSON arbitrosDisponiblesJson = ArbitrosDisponiblesJSON.leerJSON("src/archivosJSON/ArbitrosDisponiblesJsonPretty.JSON");
		HashMap<Fecha, ArrayList<Integer>> arbitrosDisponibles = arbitrosDisponiblesJson.dame();
		ret.setArbitrosDisponibles(arbitrosDisponibles);
		
		
		return ret;
	}
	
	
}

