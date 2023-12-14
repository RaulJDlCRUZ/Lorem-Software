package Lorem_Software.Library_Maintenance_System.business.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
// import java.util.List;
// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdPrestamo;

    @Column
    private LocalDate fechaInicio;

    @Column
    private LocalDate fechaFin;

    @Column
    private boolean activo;

    @OneToOne
    @JoinColumn(name="ejemplar_id")
    private Ejemplar ejem;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario user;

    public Prestamo() {

    }

    public long getIdPrestamo() {
        return IdPrestamo;
    }

    public void setIdPrestamo(long idPrestamo) {
        IdPrestamo = idPrestamo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Ejemplar getEjem() {
        return ejem;
    }

    public void setEjem(Ejemplar ejemplar) {
        this.ejem = ejemplar;
    }

    public Usuario getUser(){
        return user;
    }

    public void setUser(Usuario usuario){
        this.user = usuario;
    }

}
