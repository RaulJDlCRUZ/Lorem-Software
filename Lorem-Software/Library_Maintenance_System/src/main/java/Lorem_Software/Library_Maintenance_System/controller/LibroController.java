package es.uclm.library.business.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import es.uclm.library.business.entity.Libro;
import es.uclm.library.persistence.LibroDAO;

@Controller
public class LibroController {
	private static final Logger log = LoggerFactory.getLogger(LibroController.class);
	@Autowired
	private LibroDAO libroDAO;
	
	@GetMapping("/libro")
	public String libroForm(Model model) {
	model.addAttribute("libro", new Libro());
	log.info(libroDAO.findAll().toString());
	return libroDAO.toString();
	}
	
	@PostMapping("/libro")
	public String libroSubmit(@ModelAttribute Libro libro, Model model) {
	model.addAttribute("libro", libro);
	Libro savedLibro = libroDAO.save(libro);
	log.info("Saved libro: " + savedLibro);
	return "result";
	}
	
}
