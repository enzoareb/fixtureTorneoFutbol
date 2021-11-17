package instancias;

import java.util.Objects;

public class Arbitro {
	

	private int numero;
	private String nombre;

	public Arbitro(int numero, String nombre) {
		this.numero = numero;
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Arbitro[Nro:" + numero + ", Nombre:" + nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arbitro other = (Arbitro) obj;
		return Objects.equals(nombre, other.nombre) && numero == other.numero;
	}
	
}
	
