package es.uclm.library.business.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String Titulo;
	private String informacion;
	public int num_ejemplares;


	public Libro() {}
	public Libro(String Titulo, String informacion, int num_ejemplares) {
		super();
		this.setTitulo(Titulo);
		this.setInformacion(informacion);
		this.num_ejemplares = num_ejemplares;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id_new) {
		id = id_new;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getInformacion() {
		return informacion;
	}
	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
}
	


