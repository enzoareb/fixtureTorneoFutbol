package instancias;

import java.util.ArrayList;
import java.util.Objects;

//Clase Fecha Java
public class Fecha {

  private int numero;
  private ArrayList<Partido> partidos;  
 
  public Fecha(int numero) {
      this.numero = numero;
      this.partidos= new ArrayList<Partido>();
  }


  	public int getNumero() {
  		return numero;
  	}


	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	public ArrayList<Partido> getPartidos() {
		return partidos;
	}
	
	public int cantPartidos() {
		return partidos.size();
	}


	public void agregarPartido(Partido partido) {
		partidos.add(partido);
	}
	
	public boolean existePartido(Partido partido) {
		return partidos.contains(partido);
	}
	
	public ArrayList<Partido> partidosSinArbitro(){
		
		ArrayList<Partido> partidosSinArbitro = new ArrayList<Partido>();
		for(Partido partido: partidos) {
			if(partido.getArbitro() == null) {
				partidosSinArbitro.add(partido);
			}
		}
		return partidosSinArbitro;
	}
	
	@Override
	public String toString() {
		return "Fecha " + numero + ":" + partidos;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fecha other = (Fecha) obj;
		return numero == other.numero;
	}

 
  
} 
