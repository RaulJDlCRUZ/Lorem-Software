package Lorem_Software.Library_Maintenance_System.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import Lorem_Software.Library_Maintenance_System.business.entity.Libro;
import Lorem_Software.Library_Maintenance_System.business.entity.Autor;
import Lorem_Software.Library_Maintenance_System.persistance.LibroDAO;

@Controller
public class LibroController {
	private static final Logger log = LoggerFactory.getLogger(LibroController.class);
	@Autowired
	private LibroDAO libroDAO;

	@GetMapping("/guardarLibro")
	public String altaTitulo(Model model) {
		model.addAttribute("libro", new Libro());
		log.info(libroDAO.findAll().toString());
		return "libro";
	}

	@PostMapping("/guardarLibro")
	public String libroSubmit(@ModelAttribute Libro libro, Model model) {
	model.addAttribute("libro", libro);
	Libro savedLibro = libroDAO.save(libro);
	log.info("Saved libro: " + savedLibro);
	return "result";
	}

}
