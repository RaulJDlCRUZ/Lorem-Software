package Lorem_Software.Library_Maintenance_System.business.entity;

// import java.util.List;
// import jakarta.persistence.Column;
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
    private long IdEjemplar;
    

    @OneToOne (mappedBy = "ejemplar")
    private Prestamo prestamo;
    

    @ManyToOne
    @JoinColumn(name="titulo_id")
    private Titulo tit;
    

    public Ejemplar () {

    }
    
    
    public Long getIdEjemplar() {
		return IdEjemplar;
	}

    public void setIdEjemplar(Long IdPrestamo) {
		this.IdEjemplar = IdPrestamo;
	}

    public Titulo getTit() {
        return tit;
    }

    public void setTit(Titulo tit) {
        this.tit = tit;
    }

}
