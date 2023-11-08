package Lorem_Software.Library_Maintenance_System.business.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libro {

	@Id
	private String ISBN;

	private String Titulo;

	private String numReserva;
	// @ElementCollection
	private String autores;

	public Libro() {
	}

	public Libro(String Titulo, String ISBN, String autoresdados) {
		super();
		this.ISBN = ISBN;
		// for (int i = 0; i < autoresdados.length; i++) {
		// 	String partes[] = autoresdados[i].split("-");
		// 	if (partes.length == 2) {
		// 		String autor = partes[0]+partes[1];
		// 		//Autor autor = new Autor(partes[0], partes[1]);
		// 		autores.add(autor);
		// 	}
		// }
		this.autores = autoresdados;
		this.Titulo = Titulo;
		this.setNumReserva(numReserva);
	}
	
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String iSBN) {
		this.ISBN = iSBN;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		this.Titulo = titulo;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getNumReserva() {
		return numReserva;
	}

	public void setNumReserva(String numReserva) {
		this.numReserva = numReserva;
	}
}
