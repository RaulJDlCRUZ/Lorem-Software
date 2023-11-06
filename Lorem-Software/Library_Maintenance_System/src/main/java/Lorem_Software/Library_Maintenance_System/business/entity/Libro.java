package es.uclm.library.business.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Libro {
	

	
	private String Titulo;
	@Id
	private String ISBN;

	private String numReserva;
	private List<Autor> autores;

	public Libro() {}
	public Libro(String Titulo, String ISBN, String[] autoresdados ) {
		super();
		for (int i = 0; i<autoresdados.length; i++) {
			String partes[] = autoresdados[i].split("-");
			if (partes.length == 2) {
	            		Autor autor = new Autor(partes[0], partes[1]);
	            		autores.add(autor);
	        	}
		}
		this.Titulo = Titulo;
		this.ISBN = ISBN;
		this.setNumReserva(numReserva);
	}
	
	public String getTitulo() {
		return Titulo;
	}
	
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getISBN() {
		return ISBN;
	}
	
	
	public String getNumReserva() {
		return numReserva;
	}
	
	public void setNumReserva(String numReserva) {
		this.numReserva = numReserva;
	}
}
	


