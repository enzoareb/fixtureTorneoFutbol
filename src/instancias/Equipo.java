package instancias;



public class Equipo {
	private String nombre;
	
	public Equipo(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo otroEquipo = (Equipo) obj;
		return this.nombre.equals(otroEquipo.getNombre());
	}
	
	
	
}
