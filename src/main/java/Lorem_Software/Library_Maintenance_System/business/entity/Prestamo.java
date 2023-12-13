package Lorem_Software.Library_Maintenance_System.business.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamo;

    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "titulo_id") 
    private Titulo tit;

    @OneToOne
    @JoinColumn(name="ejemplar_id")
    private Ejemplar ejemplar;

    public Prestamo() {
        // Constructor vacío
    }

    public Prestamo(Date fechaInicio, Date fechaFin, Long idPrestamo) {
    	this.fechaInicio=fechaInicio;
    	this.fechaFin=fechaFin;// Constructor vacío
    	this.idPrestamo=idPrestamo;
    }
    // Constructor con parámetros si se desea
    // ...

    // Getters y setters
    // ...

    public Long getId() {
        return idPrestamo;
    }

    public void setId(Long id) {
        this.idPrestamo = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Titulo getTitulo() {
        return tit;
    }

    public void setTitulo(Titulo titulo) {
        this.tit = titulo;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplares(Ejemplar ejemplares) {
        this.ejemplar = ejemplares;
    }
}
