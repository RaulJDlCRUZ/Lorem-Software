package Lorem_Software.Library_Maintenance_System.business.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdUsuario;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column
    private LocalDate fechaFinPenalizacion;

    @OneToMany(mappedBy = "user")
    private Set<Prestamo> prestamos;

    @OneToMany(mappedBy = "user")
    private Set<Reserva> reservas;

    public Usuario(){

    }

    public long getIdUsuario(){
        return IdUsuario;
    }

    public void setIdUsuario(long id){
        this.IdUsuario = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellidos(){
        return apellidos;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public LocalDate getFechaFinPenalizacion(){
        return fechaFinPenalizacion;
    }

    public void setFechaFinPenalizacion(LocalDate nFecha){
        this.fechaFinPenalizacion = nFecha;
    }

    public Set<Prestamo> getPrestamos(){
        return prestamos;
    }

    public void setPrestamos(Set<Prestamo> nPrestamos){
        this.prestamos = nPrestamos;
    }

    public Set<Reserva> getReservas(){
        return reservas;
    }

    public void setReservas(Set<Reserva> nReservas){
        this.reservas = nReservas;
    }

}
