package Lorem_Software.Library_Maintenance_System.business.entity;

import java.util.List;
import jakarta.persistence.Column;
// import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Titulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String ISBN;
	@Column
	private String Titulo;
	@Column
	private String numReserva;
	
	@ManyToMany
	@JoinTable(
		name = "AUTOR_TITULOS",
		joinColumns = @JoinColumn(name = "titulo_id"), 
		inverseJoinColumns = @JoinColumn(name = "autor_id"))	
	List<Autor> autores;

	public Titulo() {
	}

	public Titulo(String Titulo, String ISBN) {
		super();
		// this.id = Long.parseLong(ISBN.replace("-",""));
		this.ISBN = ISBN;
		this.Titulo = Titulo;

		// String[] splitted_authors = campoautores.split(";");
		// for (int i = 0; i < splitted_authors.length; i++) {
		// 	String partes[] = splitted_authors[i].split(",");
		// 	Autor my_author = new Autor(partes[0], partes[1]);
		// 	this.autores.add(my_author);
		// }

		// this.setNumReserva(numReserva);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getNumReserva() {
		return numReserva;
	}

	public void setNumReserva(String numReserva) {
		this.numReserva = numReserva;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

}
