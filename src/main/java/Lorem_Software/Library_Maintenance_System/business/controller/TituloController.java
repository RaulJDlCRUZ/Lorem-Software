package Lorem_Software.Library_Maintenance_System.business.controller;

import java.util.List;
import java.util.Optional;
import java.util.Collections;
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

import Lorem_Software.Library_Maintenance_System.business.entity.Titulo;
import Lorem_Software.Library_Maintenance_System.business.entity.Autor;
import Lorem_Software.Library_Maintenance_System.business.entity.Ejemplar;

import Lorem_Software.Library_Maintenance_System.persistance.TituloDAO;
import Lorem_Software.Library_Maintenance_System.persistance.AutorDAO;
import Lorem_Software.Library_Maintenance_System.persistance.EjemplarDAO;

@Controller
public class TituloController {
	private static final Logger log = LoggerFactory.getLogger(TituloController.class);
	@Autowired
	private TituloDAO tituloDAO;
	@Autowired
	private AutorDAO autorDAO;
	@Autowired
	private EjemplarDAO ejemplarDAO;

	Titulo titulo=new Titulo(); //TODO hacer la inicialización en constructor

	/* Constante para permitir ordenamiento de titulos. 0=no, 1=si */
	final int __NAME__SORT = 1;

	@GetMapping("/ListarTitulos")
	public String listarTitulos(Model model){
		List<Titulo> listadoTitulos = tituloDAO.findAll();
		if (__NAME__SORT == 1) {
			Collections.sort(listadoTitulos, new TitleComparator());
		}

		model.addAttribute("titulo", "Listado de Títulos");
		model.addAttribute("titulos", listadoTitulos);
		return "titulo/ListarTitulos";
	}

	@GetMapping("/guardarTitulo")
	public String altaTitulo(Model model) {
		// Atributo para título de la página
		model.addAttribute("tituloheader", "Dar de alta un Título");
		// Atributo de título bibliotecario vacío, para el formulario
		model.addAttribute("titulo", new Titulo());
		// Atributo de lista de autores, para poder mostrarlos en la tabla
		List<Autor> listadoAutores = autorDAO.findAll();
		// Ordenamos la lista por nombre
		Collections.sort(listadoAutores, new AutorComparator());
		

		model.addAttribute("listautores", listadoAutores);
		log.info(tituloDAO.findAll().toString());
		log.info(autorDAO.findAll().toString());
		return "titulo/NuevoTitulo";
	}

	@PostMapping("/guardarTitulo")
	public String libroSubmit(@ModelAttribute Titulo titulo, Model model, RedirectAttributes attribute) {
		this.titulo = titulo;
		model.addAttribute("titulo", titulo);
		/* En este punto tengo que tener el autor (ya incluido en dropdown en titulo) */
		Titulo savedTitulo = tituloDAO.save(titulo);
		log.info("Saved title: " + savedTitulo);
		/* Añadir 1 ejemplar de manera predeterminada */
		Ejemplar ejemplar = new Ejemplar();
		ejemplar.setTit(savedTitulo);
		ejemplarDAO.save(ejemplar);
		attribute.addFlashAttribute("success", "Título creado correctamente");
		return "redirect:/ListarTitulos";
	}

	@GetMapping("/guardarTitulo/edit/{id}")
	public String formularioEditarTitulo(@PathVariable("id") long id, Model model) {
		Optional<Titulo> titulo = tituloDAO.findById(id);
		List<Autor> listadoAutores = autorDAO.findAll();
		Collections.sort(listadoAutores, new AutorComparator());
		model.addAttribute("titulo", titulo);
		// Aunque vaya a editar el título, me llevo todos los autores, para poderlos cambiar
		model.addAttribute("listautores", listadoAutores);
		return "titulo/NuevoTitulo";
	}

	@PostMapping("/guardarTitulo/update/{id}")
	public String actualizarTitulo(@PathVariable("id") long id, Titulo titulo, RedirectAttributes attribute) {
		tituloDAO.save(titulo);
		attribute.addFlashAttribute("success", "Título modificado correctamente");
		return "ListarTitulos";
	}

	@GetMapping("delete/{id}")
	public String eliminarTitulo(@PathVariable("id") long idTitulo, RedirectAttributes attribute){
		/*
		Se obtiene el título con id específico, y se guarda momentáneamente en una lista para
		poder iterar sobre los ejemplares, para guardarlos así en una lista. Así, podemos quitar
		los ejemplares uno a uno antes de borrar el título
		*/
		Titulo t = tituloDAO.findById(idTitulo).get();
		for(Ejemplar ej:t.getEjemplares()){
			if(ej.getPrestamo()!=null){
				System.out.println("Noc Noc");
				attribute.addFlashAttribute("error", "No se puede eliminar el título porque tiene un ejemplar prestado");
				return "redirect:/ListarTitulos";
			}
		}
		List<Long> ids = List.of(Long.valueOf(idTitulo));
		List<Ejemplar> ejemplareslibro = ejemplarDAO.findAllById(ids);
		for (Ejemplar e : ejemplareslibro)
			ejemplarDAO.delete(e);

		tituloDAO.delete(t);
		attribute.addFlashAttribute("warning", "Título eliminado correctamente");
		return "redirect:/ListarTitulos";
	}

	class AutorComparator implements java.util.Comparator<Autor> {
		@Override
		public int compare(Autor a, Autor b) {
			return a.getNombre().compareTo(b.getNombre());
		}
	}

	class TitleComparator implements java.util.Comparator<Titulo> {
		@Override
		public int compare(Titulo a, Titulo b) {
			return a.getTitulo().compareTo(b.getTitulo());
		}
	}

	
}
