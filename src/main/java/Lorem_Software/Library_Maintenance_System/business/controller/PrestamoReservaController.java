package Lorem_Software.Library_Maintenance_System.business.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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

import Lorem_Software.Library_Maintenance_System.business.entity.Ejemplar;
import Lorem_Software.Library_Maintenance_System.business.entity.Prestamo;
import Lorem_Software.Library_Maintenance_System.business.entity.Reserva;
import Lorem_Software.Library_Maintenance_System.business.entity.Usuario;
import Lorem_Software.Library_Maintenance_System.persistance.EjemplarDAO;
import Lorem_Software.Library_Maintenance_System.persistance.PrestamoDAO;
import Lorem_Software.Library_Maintenance_System.persistance.ReservaDAO;
import Lorem_Software.Library_Maintenance_System.persistance.UsuarioDAO;

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

    Prestamo prestamo;
    Reserva reserva;

    public PrestamoReservaController() {
        super();
        this.prestamo = new Prestamo();
        this.reserva = new Reserva();
    }

    @GetMapping("/ListarEjemplares")
    public String listarPrestamos(Model model, RedirectAttributes attribute) {
        model.addAttribute("titulo", "Catálogo de Ejemplares");

        for (Ejemplar e : ejemplarDAO.findAll()) {

            if (e.getPrestamo() != null && LocalDate.now().isAfter(e.getPrestamo().getFechaFin().plusMonths(3))) {
                log.error(
                        "{} {} lleva más de 3 meses de retraso en la devolucón del préstamo de {} - {} , por lo que se le penalizará con 3 años sin poder tomar prestado ni reservar",
                        e.getPrestamo().getUser().getNombre(), e.getPrestamo().getUser().getApellidos(),
                        e.getTit().getTitulo(), e.getIdEjemplar());

                Usuario usuarioPenalizar = e.getPrestamo().getUser();

                if (e.getPrestamo().getUser().getFechaFinPenalizacion() == null
                        || e.getPrestamo().getUser().getFechaFinPenalizacion().isBefore(LocalDate.now())) {
                    usuarioPenalizar.setFechaFinPenalizacion(LocalDate.now().plusYears(3));
                } else {
                    usuarioPenalizar
                            .setFechaFinPenalizacion(usuarioPenalizar.getFechaFinPenalizacion().plusYears(3));
                }
                log.error(
                        "El ejemplar {} - {} será eliminado del sistema dado que si el usuario se ha retrasado tanto tiempo se considerará como ejemplar perdido",
                        e.getTit().getTitulo(), e.getIdEjemplar());
                prestamoDAO.deleteById(e.getPrestamo().getIdPrestamo());
                if (e.getReserva() != null) {
                    reservaDAO.deleteById(e.getReserva().getIdReserva());
                }
                ejemplarDAO.delete(e);
            }
        }

        List<Ejemplar> listadoEjemplares = ejemplarDAO.findAll();
        Collections.sort(listadoEjemplares, new EjemplarComparator());
        model.addAttribute("ejemplares", listadoEjemplares);
        return "prestamoreserva/ListarPrestamosReservas";
    }

    @GetMapping("/HacerPrestamo")
    public String altaPrestamo(Model model) {
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
    public String prestamoSubmit(@ModelAttribute Prestamo prestamo, Model model, RedirectAttributes attribute) {
        this.prestamo = prestamo;
        this.prestamo.setFechaInicio(LocalDate.now());
        this.prestamo.setFechaFin(this.prestamo.getFechaInicio().plusMonths(1));
        this.prestamo.setActivo(true);
        if (this.prestamo.getUser().getFechaFinPenalizacion() != null
                && this.prestamo.getUser().getFechaFinPenalizacion().isAfter(LocalDate.now())) {
            attribute.addFlashAttribute("error",
                    this.prestamo.getUser().getNombre() + " " + this.prestamo.getUser().getApellidos() +
                            " no puede tomar prestado ejemplares hasta el "
                            + this.prestamo.getUser().getFechaFinPenalizacion());
            return "redirect:/ListarEjemplares";
        }
        if (this.prestamo.getEjem().getReserva() != null) {
            if (!this.prestamo.getEjem().getReserva().getUser().getNombre().equals(this.prestamo.getUser().getNombre())
                    && !this.prestamo.getEjem().getReserva().getUser().getApellidos().equals(this.prestamo.getUser()
                            .getApellidos())) {
                if (this.prestamo.getEjem().getReserva().getFechaReserva() != null
                        && this.prestamo.getEjem().getReserva().getFechaReserva().isAfter(LocalDate.now())) {
                    attribute.addFlashAttribute("error",
                            this.prestamo.getUser().getNombre() + " " + this.prestamo.getUser().getApellidos()
                                    + " no puede coger prestado este ejemplar porque está reservado por " +
                                    this.prestamo.getEjem().getReserva().getUser().getNombre() + " "
                                    + this.prestamo.getEjem().getReserva().getUser().getApellidos());
                    return "redirect:/ListarEjemplares";
                } else {
                    attribute.addFlashAttribute("warning",
                            "La reserva asociada al ejemplar ha caducado. El usuario de la reserva ha recibido una penalización de 1 semana");
                    Usuario usuarioPenalizado = this.prestamo.getEjem().getReserva().getUser();
                    if (usuarioPenalizado.getFechaFinPenalizacion() == null
                            || usuarioPenalizado.getFechaFinPenalizacion().isBefore(LocalDate.now())) {
                        usuarioPenalizado.setFechaFinPenalizacion(LocalDate.now().plusWeeks(1));
                    } else if (usuarioPenalizado.getFechaFinPenalizacion().isAfter(LocalDate.now())) {
                        usuarioPenalizado
                                .setFechaFinPenalizacion(usuarioPenalizado.getFechaFinPenalizacion().plusWeeks(1));
                    }
                    usuarioDAO.save(usuarioPenalizado);
                }
            }
            reservaDAO.delete(this.prestamo.getEjem().getReserva());
            attribute.addFlashAttribute("info",
                    "La reserva asociada al ejemplar " + this.prestamo.getEjem().getTit().getTitulo() + " - " +
                            this.prestamo.getEjem().getIdEjemplar() + " se ha eliminado puesto que "
                            + this.prestamo.getUser().getNombre() + " " +
                            this.prestamo.getUser().getApellidos() + " ha tomado prestado el ejemplar");
        }
        prestamoDAO.save(this.prestamo);
        attribute.addFlashAttribute("success", "El préstamo se ha realizado correctamente");
        return "redirect:/ListarEjemplares";
    }

    @GetMapping("/HacerReserva")
    public String altaReserva(Model model) {
        model.addAttribute("reservaHeader", "Realizar una reserva");
        model.addAttribute("reservas", new Prestamo());

        List<Ejemplar> listaEjemplares = new LinkedList<>();
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
    public String reservaSubmit(@ModelAttribute Reserva reserva, Model model, RedirectAttributes attribute) {
        this.reserva = reserva;
        this.reserva.setFechaReserva(LocalDate.now().plusDays(5));

        if (this.reserva.getUser().getFechaFinPenalizacion() != null
                && this.reserva.getUser().getFechaFinPenalizacion().isAfter(LocalDate.now())) {
            attribute.addFlashAttribute("error",
                    this.reserva.getUser().getNombre() + " " + this.reserva.getUser().getApellidos() +
                            " no puede realizar reservas hasta el " + this.reserva.getUser().getFechaFinPenalizacion());
            return "redirect:/ListarEjemplares";
        }

        reservaDAO.save(this.reserva);
        attribute.addFlashAttribute("success",
                "La reserva se ha realizado correctamente a nombre de " + this.reserva.getUser().getNombre() +
                        " " + this.reserva.getUser().getApellidos());
        return "redirect:/ListarEjemplares";
    }

    @GetMapping("/ListarEjemplares/devolverPrestamo/{IdPrestamo}")
    public String devolverPrestamo(@PathVariable("IdPrestamo") long idPrestamo, RedirectAttributes attribute) {
        LocalDate fechaDevuelto = LocalDate.now();

        Optional<Prestamo> prestamoOpc = prestamoDAO.findById(idPrestamo);

        if (prestamoOpc.isPresent()){
            Prestamo prestamoDevolver = prestamoOpc.get();
            Optional<Usuario> usuarioOpc = usuarioDAO.findById(prestamoDevolver.getUser().getIdUsuario());
            if(usuarioOpc.isPresent()){
                Usuario usuarioPrestamo = usuarioOpc.get();
                if (fechaDevuelto.isAfter(prestamoDevolver.getFechaFin())) {
                    if (usuarioPrestamo.getFechaFinPenalizacion() == null
                            || usuarioPrestamo.getFechaFinPenalizacion().isBefore(LocalDate.now())) {
                        usuarioPrestamo.setFechaFinPenalizacion(fechaDevuelto
                                .plusDays(3 * ChronoUnit.DAYS.between(prestamoDevolver.getFechaFin(), fechaDevuelto)));
                    } else if (usuarioPrestamo.getFechaFinPenalizacion().isAfter(LocalDate.now())) {
                        usuarioPrestamo.setFechaFinPenalizacion(usuarioPrestamo.getFechaFinPenalizacion()
                                .plusDays(3 * ChronoUnit.DAYS.between(prestamoDevolver.getFechaFin(), fechaDevuelto)));
                    }
                    usuarioDAO.save(usuarioPrestamo);
                    attribute.addFlashAttribute("error",
                            "El usuario " + usuarioPrestamo.getNombre() + " " + usuarioPrestamo.getApellidos() +
                                    " ha recibido una penalización por devolución tardía de "
                                    + ChronoUnit.DAYS.between(prestamoDevolver.getFechaFin(), fechaDevuelto) +
                                    " días hasta el " + usuarioPrestamo.getFechaFinPenalizacion());
                }
            }
            prestamoDAO.deleteById(idPrestamo);
            attribute.addFlashAttribute("info", "El préstamo ha sido devuelto satisfactoriamente");
        }
        return "redirect:/ListarEjemplares";
    }

    @GetMapping("/ListarEjemplares/cancelarReserva/{IdReserva}")
    public String cancelarReserva(@PathVariable("IdReserva") long idReserva, RedirectAttributes attribute) {

        Optional<Reserva> reservaOpt = reservaDAO.findById(idReserva);
        if(reservaOpt.isPresent()){
            Reserva reservaCancelar = reservaOpt.get();
            Optional<Usuario> usuarioOpt = usuarioDAO.findById(reservaCancelar.getUser().getIdUsuario());
            if(usuarioOpt.isPresent()){
                Usuario usuarioReserva = usuarioOpt.get();
                attribute.addFlashAttribute("warning", "Por cancelar una reserva se te aplica una penalización de 1 semanas");
                if (usuarioReserva.getFechaFinPenalizacion() == null
                        || usuarioReserva.getFechaFinPenalizacion().isBefore(LocalDate.now())) {
                    usuarioReserva.setFechaFinPenalizacion(LocalDate.now().plusWeeks(1));
                } else if (usuarioReserva.getFechaFinPenalizacion().isAfter(LocalDate.now())) {
                    usuarioReserva.setFechaFinPenalizacion(usuarioReserva.getFechaFinPenalizacion().plusWeeks(1));
                }
                usuarioDAO.save(usuarioReserva);
            }
            reservaDAO.delete(reservaCancelar);
            attribute.addFlashAttribute("info", "Reserva cancelada correctamente");
        }
        return "redirect:/ListarEjemplares";
    }

    class EjemplarComparator implements java.util.Comparator<Ejemplar> {
        @Override
        public int compare(Ejemplar a, Ejemplar b) {
            return a.getTit().getTitulo().compareTo(b.getTit().getTitulo());
        }
    }

    class UsuarioComparator implements java.util.Comparator<Usuario> {
        @Override
        public int compare(Usuario a, Usuario b) {
            return a.getNombre().compareTo(b.getNombre());
        }

    }

    public PrestamoDAO getPrestamoDAO() {
        return prestamoDAO;
    }

    public void setPrestamoDAO(PrestamoDAO prestamoDAO) {
        this.prestamoDAO = prestamoDAO;
    }

    public ReservaDAO getReservaDAO() {
        return reservaDAO;
    }

    public void setReservaDAO(ReservaDAO reservaDAO) {
        this.reservaDAO = reservaDAO;
    }

    public EjemplarDAO getEjemplarDAO() {
        return ejemplarDAO;
    }

    public void setEjemplarDAO(EjemplarDAO ejemplarDAO) {
        this.ejemplarDAO = ejemplarDAO;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}