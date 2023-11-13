package Lorem_Software.Library_Maintenance_System.business.controller;
import java.util.Collections;
import java.util.List;
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

import Lorem_Software.Library_Maintenance_System.business.controller.TituloController.TitleComparator;
import Lorem_Software.Library_Maintenance_System.business.entity.Autor;
import Lorem_Software.Library_Maintenance_System.business.entity.Titulo;
import Lorem_Software.Library_Maintenance_System.persistance.AutorDAO;

@Controller
public class AutorController {

	private static final Logger log = LoggerFactory.getLogger(TituloController.class);
    @Autowired
	private AutorDAO autorDAO;

    Autor autor=new Autor(); //TODO hacer la inicialización en constructor
	// CONSTANTE PARA ORDENAR POR NOMBRE O NO
	final int __NAME__SORT = 1;
    
	@GetMapping("/AltaAutor")
	public String altaAutor(Model model) {
        List<Autor> listadoAutores = autorDAO.findAll();
		// Ordenamos la lista por nombre
		if (__NAME__SORT == 1) {
			Collections.sort(listadoAutores, new TitleComparator());
		}

        model.addAttribute("titulo", "Lista de Autores");
        model.addAttribute("autor", new Autor());
        model.addAttribute("listautores", listadoAutores);

		log.info(autorDAO.findAll().toString());
		return "autor/AltaAutor";
	}
    
	@PostMapping("/AltaAutor")
	public String autorSubmit(@ModelAttribute Autor autor, Model model) {
        this.autor = autor;
		model.addAttribute("autor", autor);
		Autor savedAutor = autorDAO.save(autor);
		log.info("Saved autor: " + savedAutor);
		// titulo.addAutor(autor);
		return "autor/NuevoAutor";
	}

	@GetMapping("/AltaAutor/edit/{id}")
	public String formularioEditarAutor(@PathVariable("id") long id, Model model) {
		Optional<Autor> autor = autorDAO.findById(id);
		model.addAttribute("autor", autor);
		return "autor/NuevoAutor";
	}

	@PostMapping("/AltaAutor/update/{id}")
	public String actualizarAutor(@PathVariable("id") long id, Autor autor) {
		autorDAO.save(autor);
		return "autor/AltaAutor";
	}

	@GetMapping("/AltaAutor/delete/{id}")
	public String deleteAutor(@PathVariable("id") long id) {
		suprimirAsociacionesAutorLibro(autorDAO.findById(id));
		autorDAO.deleteById(id);
		return "redirect:/autor/AltaAutor";
	}

	@PreRemove
	private void suprimirAsociacionesAutorLibro(Optional<Autor> au) {
		// Método anterior a eliminación de autor por DAO (=PreRemove)
		// Revisa cada título asociado con autor y se elimina el vínculo, manteniendo el título
		Autor a = au.get();
		for (Titulo t : a.getTitulos()){
			t.getAutores().remove(a);
		}
	}//

	class TitleComparator implements java.util.Comparator<Autor> {
		@Override
		public int compare(Autor a, Autor b) {
			return a.getNombre().compareTo(b.getNombre());
		}
	}

}