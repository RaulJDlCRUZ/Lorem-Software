package Lorem_Software.Library_Maintenance_System.business.entity;

import java.util.Set;

// import org.hibernate.annotations.OnDelete;
// import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
// import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

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
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name = "AUTOR_TITULOS",
		joinColumns = @JoinColumn(name = "titulo_id"), 
		inverseJoinColumns = @JoinColumn(name = "autor_id"))
		// @OnDelete(action = OnDeleteAction.CASCADE)
	Set<Autor> autores;

	@OneToMany(mappedBy="tit", cascade=CascadeType.ALL)
	private Set<Ejemplar> ejemplares;

	public Titulo() {
	}

	public Titulo(String Titulo, String ISBN) {
		super();
		this.ISBN = ISBN;
		this.Titulo = Titulo;
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

	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}

	public Set<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(Set<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}	

}
