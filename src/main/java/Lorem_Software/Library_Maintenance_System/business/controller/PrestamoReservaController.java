package Lorem_Software.Library_Maintenance_System.business.controller;

import java.util.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Lorem_Software.Library_Maintenance_System.persistance.*;
import Lorem_Software.Library_Maintenance_System.business.entity.*;

@Controller
public class PrestamoReservaController {
    private static final Logger log = LoggerFactory.getLogger(PrestamoReservaController.class);

    @Autowired
    private PrestamoDAO prestamoDAO;
    
    @Autowired
    private ReservaDAO reservaDAO;

    @Autowired
    private EjemplarDAO ejemplarDAO;

    @Autowired
    private UsuarioDAO usuarioDAO;

    Prestamo prestamo = new Prestamo();
    Reserva reserva = new Reserva();

    @GetMapping("/ListarEjemplares")
    public String listarPrestamos(Model model){
        List<Ejemplar> listadoEjemplares = ejemplarDAO.findAll();
        Collections.sort(listadoEjemplares, new EjemplarComparator());
        model.addAttribute("titulo", "Catálogo de Ejemplares");
        model.addAttribute("ejemplares", listadoEjemplares);
        return "prestamoreserva/ListarPrestamosReservas";
    }

    @GetMapping("/HacerPrestamo")
    public String altaPrestamo(Model model){
        model.addAttribute("prestamoHeader", "Realizar un Préstamo");
        model.addAttribute("prestamos", new Prestamo());
        List<Ejemplar> listaEjemplares = ejemplarDAO.findAll();
        Collections.sort(listaEjemplares, new EjemplarComparator());
        model.addAttribute("listaEjemplares", listaEjemplares);
        List<Usuario> listaUsuarios = usuarioDAO.findAll();
        Collections.sort(listaUsuarios, new UsuarioComparator());
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "prestamoreserva/NuevoPrestamo";
    }

    @PostMapping("/HacerPrestamo")
    public String prestamoSubmit(@ModelAttribute Prestamo prestamo, Model model,RedirectAttributes attribute){
        this.prestamo = prestamo;
        log.info("El id del ejemplar es "+this.prestamo.getEjem().getIdEjemplar());
        this.prestamo.setFechaInicio(LocalDate.now());
        this.prestamo.setFechaFin(this.prestamo.getFechaInicio().plusMonths(1));
        this.prestamo.setActivo(true);
        if(this.prestamo.getUser().getFechaFinPenalizacion() != null && this.prestamo.getUser().getFechaFinPenalizacion().isAfter(this.prestamo.getFechaFin())){
            attribute.addFlashAttribute("error", this.prestamo.getUser().getNombre()+" "+ this.prestamo.getUser().getApellidos()+
            " no puede tomar prestado ejemplares hasta el "+this.prestamo.getUser().getFechaFinPenalizacion());
            return "redirect:/ListarEjemplares";
        }
        if(this.prestamo.getEjem().getReserva().getUser().getNombre()!=this.prestamo.getUser().getNombre()&&this.prestamo.getEjem().getReserva().getUser().getApellidos()!=this.prestamo.getUser().getApellidos()){
            if(this.prestamo.getEjem().getReserva().getFechaReserva()!=null && this.prestamo.getEjem().getReserva().getFechaReserva().isAfter(LocalDate.now())){
                attribute.addFlashAttribute("error", this.prestamo.getUser().getNombre()+" "+this.prestamo.getUser().getApellidos()+" no puede coger prestado este ejemplar porque está reservado por "+
                this.prestamo.getEjem().getReserva().getUser().getNombre()+" "+this.prestamo.getEjem().getReserva().getUser().getApellidos());
                return "redirect:/ListarEjemplares";
            }else{
                attribute.addFlashAttribute("warning", "La reserva asociada al ejemplar ha caducado. El usuario de la reserva ha recibido una penalización de 1 semana");
                Usuario usuarioPenalizado = this.prestamo.getEjem().getReserva().getUser();
                if(usuarioPenalizado.getFechaFinPenalizacion()==null || usuarioPenalizado.getFechaFinPenalizacion().isBefore(LocalDate.now())){
                    usuarioPenalizado.setFechaFinPenalizacion(LocalDate.now().plusWeeks(1));
                }else if(usuarioPenalizado.getFechaFinPenalizacion().isAfter(LocalDate.now())){
                    usuarioPenalizado.setFechaFinPenalizacion(usuarioPenalizado.getFechaFinPenalizacion().plusWeeks(1));
                }
                usuarioDAO.save(usuarioPenalizado);
            }
        }
        prestamoDAO.save(this.prestamo);
        reservaDAO.delete(this.prestamo.getEjem().getReserva());
        attribute.addFlashAttribute("success", "El préstamo se ha realizado correctamente");
        attribute.addFlashAttribute("info", "La reserva asociada al ejemplar "+this.prestamo.getEjem().getTit().getTitulo() + " - " +
        this.prestamo.getEjem().getIdEjemplar() + " se ha eliminado puesto que " + this.prestamo.getUser().getNombre() + " " +
        this.prestamo.getUser().getApellidos()+" ha tomado prestado el ejemplar");
        return "redirect:/ListarEjemplares";
    }
    
    @GetMapping("/HacerReserva")
    public String altaReserva(Model model){
        model.addAttribute("reservaHeader", "Realizar una reserva");
        model.addAttribute("reservas", new Prestamo());
        
        List<Ejemplar> listaEjemplares = new LinkedList<Ejemplar>();
        for (Ejemplar e : ejemplarDAO.findAll()) {
        	if (e.getPrestamo() == null)
        		listaEjemplares.add(e);
        }
        
        Collections.sort(listaEjemplares, new EjemplarComparator());
        model.addAttribute("listaEjemplares", listaEjemplares);
        List<Usuario> listaUsuarios = usuarioDAO.findAll();
        Collections.sort(listaUsuarios, new UsuarioComparator());
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "prestamoreserva/NuevaReserva";
    }

    @PostMapping("/HacerReserva")
    public String reservaSubmit(@ModelAttribute Reserva reserva, Model model,RedirectAttributes attribute){
        this.reserva = reserva;
        
        log.info("El id del ejemplar es "+this.reserva.getEjem().getIdEjemplar());
        
        this.reserva.setFechaReserva(LocalDate.now().plusMonths(1));

        if(this.reserva.getUser().getFechaFinPenalizacion() != null && this.reserva.getUser().getFechaFinPenalizacion().isAfter(LocalDate.now())){
            attribute.addFlashAttribute("error", this.reserva.getUser().getNombre()+" "+ this.reserva.getUser().getApellidos()+
            " no puede realizar reservas hasta el "+this.reserva.getUser().getFechaFinPenalizacion());
            return "redirect:/ListarEjemplares";
        }
        
        reservaDAO.save(this.reserva);
        attribute.addFlashAttribute("success", "La reserva se ha realizado correctamente a nombre de " + this.reserva.getUser().getNombre() + 
        " " + this.reserva.getUser().getApellidos());
        return "redirect:/ListarEjemplares";
    }

    @GetMapping("/ListarEjemplares/devolverPrestamo/{IdPrestamo}")
    public String devolverPrestamo(@PathVariable("IdPrestamo") long IdPrestamo, RedirectAttributes attribute){
        LocalDate FechaDevuelto = LocalDate.now();

        Usuario usuarioPrestamo = usuarioDAO.findById(prestamoDAO.findById(IdPrestamo).get().getUser().getIdUsuario()).get();
        Prestamo prestamoDevolver = prestamoDAO.findById(IdPrestamo).get();

        if(FechaDevuelto.isAfter(prestamoDevolver.getFechaFin())){
            if(usuarioPrestamo.getFechaFinPenalizacion()==null || usuarioPrestamo.getFechaFinPenalizacion().isBefore(LocalDate.now())){
                usuarioPrestamo.setFechaFinPenalizacion(FechaDevuelto.plusDays(3*ChronoUnit.DAYS.between(prestamoDevolver.getFechaFin(), FechaDevuelto)));
            }else if(usuarioPrestamo.getFechaFinPenalizacion().isAfter(LocalDate.now())){
                usuarioPrestamo.setFechaFinPenalizacion(usuarioPrestamo.getFechaFinPenalizacion().plusDays(3*ChronoUnit.DAYS.between(prestamoDevolver.getFechaFin(), FechaDevuelto)));
            }
            usuarioDAO.save(usuarioPrestamo);
            attribute.addFlashAttribute("error", "El usuario "+usuarioPrestamo.getNombre()+" "+usuarioPrestamo.getApellidos()+
            " ha recibido una penalización por devolución tardía de "+ChronoUnit.DAYS.between(prestamoDevolver.getFechaFin(), FechaDevuelto)+
            " días hasta el "+ usuarioPrestamo.getFechaFinPenalizacion());
        }

        prestamoDAO.deleteById(IdPrestamo);
        attribute.addFlashAttribute("info", "El préstamo ha sido devuelto satisfactoriamente");
        return "redirect:/ListarEjemplares";
    }

    @GetMapping("/ListarEjemplares/cancelarReserva/{IdReserva}")
    public String cancelarReserva(@PathVariable("IdReserva") long IdReserva, RedirectAttributes attribute){

        Usuario usuarioReserva = usuarioDAO.findById(reservaDAO.findById(IdReserva).get().getUser().getIdUsuario()).get();

        attribute.addFlashAttribute("warning", "Por cancelar una reserva se te aplica una penalización de 1 semanas");
        if(usuarioReserva.getFechaFinPenalizacion()==null || usuarioReserva.getFechaFinPenalizacion().isBefore(LocalDate.now())){
            usuarioReserva.setFechaFinPenalizacion(LocalDate.now().plusWeeks(1));
        }else if(usuarioReserva.getFechaFinPenalizacion().isAfter(LocalDate.now())){
            usuarioReserva.setFechaFinPenalizacion(usuarioReserva.getFechaFinPenalizacion().plusWeeks(1));
        }
        usuarioDAO.save(usuarioReserva);
        reservaDAO.deleteById(IdReserva);
        attribute.addFlashAttribute("info", "Reserva cancelada correctamente");
        return "redirect:/ListarEjemplares";
    }

    class EjemplarComparator implements java.util.Comparator<Ejemplar>{
        @Override
        public int compare(Ejemplar a, Ejemplar b){
            return a.getTit().getTitulo().compareTo(b.getTit().getTitulo());
        }
    }

    class UsuarioComparator implements java.util.Comparator<Usuario>{
        @Override
        public int compare(Usuario a, Usuario b){
            return a.getNombre().compareTo(b.getNombre());
        }

    }
}
