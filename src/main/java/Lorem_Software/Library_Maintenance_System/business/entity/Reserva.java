package Lorem_Software.Library_Maintenance_System.business.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate fechaReserva;

	@OneToOne
	@JoinColumn(name = "ejemplar_id")
	private Ejemplar ejem;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario user;

	public Reserva() {
		/*
		 * No presenta constructor con atributos dado que
		 * existen atributos de reserva son dependientes de
		 * Otros objetos
		 * */
	}


	public Long getIdReserva() {
		return id;
	}

	public void setIdReserva(Long id) {
		this.id = id;
	}

	public LocalDate getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(LocalDate fecha) {
		this.fechaReserva = fecha;
	}

	public Ejemplar getEjem() {
		return ejem;
	}

	public void setEjem(Ejemplar ejem) {
		this.ejem = ejem;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

}
