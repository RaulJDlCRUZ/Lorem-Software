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

import Lorem_Software.Library_Maintenance_System.business.entity.Titulo;
import Lorem_Software.Library_Maintenance_System.business.entity.Autor;
import Lorem_Software.Library_Maintenance_System.persistance.AutorDAO;
import Lorem_Software.Library_Maintenance_System.persistance.TituloDAO;

@Controller
public class TituloController {
	private static final Logger log = LoggerFactory.getLogger(TituloController.class);
	@Autowired
	private TituloDAO tituloDAO;

	@Autowired
	private AutorDAO autorDAO;

	Titulo titulo=new Titulo(); //TODO hacer la inicialización en constructor

	@GetMapping("/guardarTitulo")
	public String altaTitulo(Model model) {
		// Atributo para título de la página
		model.addAttribute("tituloheader", "Dar de alta un Título");
		// Atributo de título bibliotecario vacío, para el formulario
		model.addAttribute("titulo", new Titulo());
		// Atributo de lista de autores, para poder mostrarlos en la tabla
		List<Autor> listadoAutores = autorDAO.findAll();
		model.addAttribute("listautores", listadoAutores);
		log.info(tituloDAO.findAll().toString());
		log.info(autorDAO.findAll().toString());
		return "titulo";
	}

	@PostMapping("/guardarTitulo")
	public String libroSubmit(@ModelAttribute Titulo titulo, Model model) {
		this.titulo = titulo;
		model.addAttribute("libro", titulo);
		/* En este punto tengo que tener el autor <- llamo a agregarAutor */
		Titulo savedTitulo = tituloDAO.save(titulo);
		log.info("Saved title: " + savedTitulo);
		return "result";
	}

	// @PostMapping("/agregarAutorNuevo")
	// private String agregarAutorNuevo() {
	// 	autorNuevo = new Autor(/*campos que vienen de la intfaz de usuario*/);
	// 	Autor autor = autorDAO.saveAutor(autorNuevo);
	// 	titulo.addAutor(autor);
	// 	return "titulo";
	// }

	// @PostMapping("/AltaAutor")
	// private String agregarAutor(@ModelAttribute Autor autor) {

	// 	Autor savedAutor = autorDAO.save(autor);
	// 	log.info("Saved autor: " + savedAutor);
	// 	// titulo.addAutor(autor);
	// 	return "titulo";
	// }

}
