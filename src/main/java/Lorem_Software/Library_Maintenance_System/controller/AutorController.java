package Lorem_Software.Library_Maintenance_System.controller;
import java.util.List;
// import org.hibernate.mapping.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import Lorem_Software.Library_Maintenance_System.business.entity.Autor;
import Lorem_Software.Library_Maintenance_System.persistance.AutorDAO;

@Controller
public class AutorController {

	private static final Logger log = LoggerFactory.getLogger(TituloController.class);
    @Autowired
	private AutorDAO autorDAO;

    Autor autor=new Autor(); //TODO hacer la inicialización en constructor
    
	@GetMapping("/AltaAutor")
	public String altaAutor(Model model) {
        List<Autor> listadoAutores = autorDAO.findAll();

        model.addAttribute("titulo", "Lista de Autores");
        model.addAttribute("autor", new Autor());
        model.addAttribute("listautores", listadoAutores);

		log.info(autorDAO.findAll().toString());
		return "autor";
	}
    
	@PostMapping("/AltaAutor")
	public String autorSubmit(@ModelAttribute Autor autor, Model model) {
        this.autor = autor;
		model.addAttribute("autor", autor);

		Autor savedAutor = autorDAO.save(autor);
		log.info("Saved autor: " + savedAutor);
		// titulo.addAutor(autor);
		return "autor";
	}

}