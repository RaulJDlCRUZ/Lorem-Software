package Lorem_Software.Library_Maintenance_System.business.controller;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.util.Collections;

import org.apache.derby.tools.sysinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Lorem_Software.Library_Maintenance_System.persistance.*;
import Lorem_Software.Library_Maintenance_System.business.entity.*;

@Controller
public class PrestamoController {
    private static final Logger log = LoggerFactory.getLogger(PrestamoController.class);

    @Autowired
    private PrestamoDAO prestamoDAO;

    @Autowired
    private EjemplarDAO ejemplarDAO;

    @Autowired
    private UsuarioDAO usuarioDAO;

    Prestamo prestamo = new Prestamo();

    @GetMapping("/ListarEjemplares")
    public String listarPrestamos(Model model){
        List<Ejemplar> listadoEjemplares = ejemplarDAO.findAll();
        Collections.sort(listadoEjemplares, new EjemplarComparator());
        

        model.addAttribute("titulo", "Listado de Ejemplares (Prestados o no)");
        model.addAttribute("ejemplares", listadoEjemplares);
        return "prestamo/ListarPrestamos";
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
        return "prestamo/NuevoPrestamo";
    }

    @PostMapping("/HacerPrestamo")
    public String prestamoSubmit(@ModelAttribute Prestamo prestamo, Model model){
        this.prestamo = prestamo;
        log.info("El id del ejemplar es "+this.prestamo.getEjem().getIdEjemplar());
        this.prestamo.setFechaInicio(LocalDate.now());
        this.prestamo.setFechaFin(this.prestamo.getFechaInicio().plusMonths(1));
        this.prestamo.setActivo(true);
        System.out.println("Id ejemplar: "+this.prestamo.getEjem().getIdEjemplar()+
        "\nFecha inicio: "+ this.prestamo.getFechaInicio()+
        "\nFecha fin: "+ this.prestamo.getFechaFin()+
        "\nActivo: " + this.prestamo.isActivo() +
        "\nUsuario: "+ this.prestamo.getUser().getNombre() +" "+ this.prestamo.getUser().getApellidos());
        prestamoDAO.save(this.prestamo);
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
