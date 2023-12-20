package Lorem_Software.Library_Maintenance_System.business.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Ejemplar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEjemplar;

	@ManyToOne
	@JoinColumn(name = "titulo_id")
	private Titulo tit;

	@OneToOne(mappedBy = "ejem")
	private Prestamo prestamo;

	@OneToOne(mappedBy = "ejem")
	private Reserva reserva;

	public Ejemplar() {
	}

	public Ejemplar(Titulo tit, Prestamo prest, Reserva res){
		this.tit = tit;
		this.prestamo = prest;
		this.reserva = res;
	}

	public Long getIdEjemplar() {
		return idEjemplar;
	}

	public void setIdEjemplar(Long idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	public Titulo getTit() {
		return tit;
	}

	public void setTit(Titulo tit) {
		this.tit = tit;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo nPrestamo) {
		this.prestamo = nPrestamo;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
}
