package Lorem_Software.Library_Maintenance_System.business.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Autor {
	
	@Id
	private String nombre;
	private String apellido;

	

	public Autor() {}
	public Autor(String nombre, String apellido) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}