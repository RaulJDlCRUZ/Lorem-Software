package Lorem_Software.Library_Maintenance_System.business.controller;

import java.util.Collections;
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

import Lorem_Software.Library_Maintenance_System.business.entity.Autor;
import Lorem_Software.Library_Maintenance_System.business.entity.Titulo;
import Lorem_Software.Library_Maintenance_System.persistance.AutorDAO;
import jakarta.persistence.PreRemove;

@Controller
public class AutorController {

	private static final Logger log = LoggerFactory.getLogger(AutorController.class);
	@Autowired
	private AutorDAO autorDAO;

	Autor autor;

	public AutorController() {
		super();
		this.autor = new Autor();
	}

	@GetMapping("/AltaAutor")
	public String altaAutor(Model model) {
		List<Autor> listadoAutores = autorDAO.findAll();
		Collections.sort(listadoAutores, new TitleComparator());

		model.addAttribute("titulo", "Lista de Autores");
		model.addAttribute("autor", new Autor());
		model.addAttribute("listautores", listadoAutores);

		return "autor/AltaAutor";
	}

	@PostMapping("/AltaAutor")
	public String autorSubmit(@ModelAttribute Autor autor, Model model, RedirectAttributes attribute) {
		this.autor = autor;
		model.addAttribute("autor", autor);
		Autor savedAutor = autorDAO.save(autor);
		log.info("Saved autor: {} ", savedAutor);
		attribute.addFlashAttribute("success", "El autor se ha creado con éxito");
		return "redirect:/AltaAutor";
	}

	@GetMapping("/AltaAutor/edit/{id}")
	public String formularioEditarAutor(@PathVariable("id") long id, Model model) {
		Optional<Autor> autorEditar = autorDAO.findById(id);
		model.addAttribute("autor", autorEditar);
		return "autor/AltaAutor";
	}

	@PostMapping("/AltaAutor/update/{id}")
	public String actualizarAutor(@PathVariable("id") long id, Autor autor, RedirectAttributes attribute) {
		autorDAO.save(autor);
		attribute.addFlashAttribute("info", "El autor ha sido modificado");
		return "redirect:/AltaAutor";
	}

	@GetMapping("/AltaAutor/delete/{id}")
	public String deleteAutor(@PathVariable("id") long id, RedirectAttributes attribute) {
		suprimirAsociacionesAutorLibro(autorDAO.findById(id));
		autorDAO.deleteById(id);
		attribute.addFlashAttribute("warning", "El autor se ha eliminado");
		return "redirect:/AltaAutor";
	}

	@PreRemove
	private void suprimirAsociacionesAutorLibro(Optional<Autor> au) {
		if (!au.isEmpty()) {
			Autor a = au.get();
			for (Titulo t : a.getTitulos()) {
				t.getAutores().remove(a);
			}
		}
	}

	class TitleComparator implements java.util.Comparator<Autor> {
		@Override
		public int compare(Autor a, Autor b) {
			return a.getNombre().compareTo(b.getNombre());
		}
	}

	public AutorDAO getAutorDAO() {
		return autorDAO;
	}

	public void setAutorDAO(AutorDAO autorDAO) {
		this.autorDAO = autorDAO;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}