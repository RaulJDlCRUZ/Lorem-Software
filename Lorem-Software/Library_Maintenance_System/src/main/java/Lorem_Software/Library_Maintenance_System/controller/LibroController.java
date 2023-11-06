package es.uclm.library.business.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import es.uclm.library.business.entity.Libro;
import es.uclm.library.business.entity.Autor;
import es.uclm.library.persistence.LibroDAO;

@Controller
public class LibroController {
	private static final Logger log = LoggerFactory.getLogger(LibroController.class);
	@Autowired
	private LibroDAO libroDAO;
	
	@GetMapping("/guardarLibro")
	public String altaTitulo(@ModelAttribute String Titulo, String ISBN, String[] autores, Model model) {
	Libro Nuevo = new Libro(Titulo,ISBN,autores);
	libroDAO.save(Nuevo);
	log.info("Libro guardado: " + Nuevo.getTitulo());
	return Titulo;
	}
	
	//@PostMapping("/libro")
	//public String libroSubmit(@ModelAttribute Libro libro, Model model) {
	//model.addAttribute("libro", libro);
	//Libro savedLibro = libroDAO.save(libro);
	//log.info("Saved libro: " + savedLibro);
	//return "result";
	//}
	
}
