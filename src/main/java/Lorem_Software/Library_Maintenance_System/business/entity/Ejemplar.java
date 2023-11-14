package Lorem_Software.Library_Maintenance_System.business.entity;

// import java.util.List;
// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ejemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdPrestamo;

    @ManyToOne
    @JoinColumn(name="titulo_id")
    private Titulo tit;

    public Ejemplar () {

    }

    public Long getIdPrestamo() {
		return IdPrestamo;
	}

    public void setIdPrestamo(Long IdPrestamo) {
		this.IdPrestamo = IdPrestamo;
	}

    public Titulo getTit() {
        return tit;
    }

    public void setTit(Titulo tit) {
        this.tit = tit;
    }

}
