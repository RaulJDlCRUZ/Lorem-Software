package Lorem_Software.Library_Maintenance_System.business.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nombre;

	@Column
	private String apellido;

	@ManyToMany(mappedBy = "autores")
	Set<Titulo> titulos;

	public Autor() {
	}

	public Autor(String nombre, String apellido) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Set<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(Set<Titulo> titulos) {
		this.titulos = titulos;
	}

}