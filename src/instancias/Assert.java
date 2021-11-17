package instancias;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;

public class Assert {

	public static void sinRepetidos(ArrayList<Fecha> fechas, HashSet<Equipo> equiposdelTorneo) {
		for (Fecha fecha : fechas) {
			ArrayList<Equipo> equiposDeLaFecha = new ArrayList<>();
			for (Partido partido : fecha.getPartidos()) {
				equiposDeLaFecha.add(partido.getEquipo1());
				equiposDeLaFecha.add(partido.getEquipo2());
			}
			for (Equipo equipo : equiposDeLaFecha) {
				assertTrue(equiposdelTorneo.contains(equipo));
			}
		}
	}

}
