package Lorem_Software.Library_Maintenance_System.business.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

// import org.hibernate.mapping.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.persistence.PreRemove;


import Lorem_Software.Library_Maintenance_System.business.entity.Prestamo;
import Lorem_Software.Library_Maintenance_System.business.entity.Ejemplar;
import Lorem_Software.Library_Maintenance_System.business.entity.Titulo;
import Lorem_Software.Library_Maintenance_System.persistance.EjemplarDAO;
import Lorem_Software.Library_Maintenance_System.persistance.TituloDAO;
import Lorem_Software.Library_Maintenance_System.persistance.PrestamoDAO;
import java.util.List;
import java.util.ArrayList;
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

	import Lorem_Software.Library_Maintenance_System.business.entity.Prestamo;
	import Lorem_Software.Library_Maintenance_System.business.entity.Titulo;
	import Lorem_Software.Library_Maintenance_System.persistance.PrestamoDAO;
	import Lorem_Software.Library_Maintenance_System.persistance.TituloDAO;

	import java.util.Collections;
	import java.util.List;

	@Controller
	public class PrestamoController {
	    private static final Logger log = LoggerFactory.getLogger(PrestamoController.class);

	    @Autowired
	    private PrestamoDAO prestamoDAO;

	    @Autowired
	    private TituloDAO tituloDAO;

	    @GetMapping("/ListarPrestamos")
	    public String listarPrestamos(Model model) {
	        List<Prestamo> listadoPrestamos = prestamoDAO.findAll();
	        model.addAttribute("titulo", "Listado de Préstamos");
	        model.addAttribute("prestamos", listadoPrestamos);
	        return "prestamo/ListarPrestamos";
	    }

	    @GetMapping("/AltaPrestamo")
	    public String altaPrestamo(Model model) {
	        model.addAttribute("prestamoHeader", "Registrar un Préstamo");
	        model.addAttribute("prestamo", new Prestamo());

	        List<Titulo> listadoTitulos = tituloDAO.findAll();

	        Collections.sort(listadoTitulos, new TitleComparator());
	        model.addAttribute("listadoTitulos", listadoTitulos);
	        return "prestamo/NuevoPrestamo";
	    }

	    @PostMapping("/AltaPrestamo")
	    public String prestamoSubmit(@ModelAttribute Prestamo prestamo, Model model) {
	        Long idTituloSeleccionado = prestamo.getTitulo().getId();

	        Optional<Titulo> tituloSeleccionado = tituloDAO.findById(idTituloSeleccionado);

	        if (tituloSeleccionado.isPresent()) {
	            Titulo titulo = tituloSeleccionado.get();
	            prestamo.setTitulo(titulo);
	            prestamoDAO.save(prestamo);
	            return "redirect:/ListarPrestamos";
	        } else {
	            
	            return "redirect:/AltaPrestamo";
	        }
	    }
	    
	    class TitleComparator implements java.util.Comparator<Titulo> {
			@Override
			public int compare(Titulo a, Titulo b) {
				return a.getTitulo().compareTo(b.getTitulo());
			}
		}

	}



