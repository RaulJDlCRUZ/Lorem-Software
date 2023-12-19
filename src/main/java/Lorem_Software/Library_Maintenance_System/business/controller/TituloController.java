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
import Lorem_Software.Library_Maintenance_System.business.entity.Ejemplar;
import Lorem_Software.Library_Maintenance_System.business.entity.Titulo;
import Lorem_Software.Library_Maintenance_System.persistance.AutorDAO;
import Lorem_Software.Library_Maintenance_System.persistance.EjemplarDAO;
import Lorem_Software.Library_Maintenance_System.persistance.TituloDAO;

@Controller
public class TituloController {
	private static final Logger log = LoggerFactory.getLogger(TituloController.class);
	@Autowired
	private TituloDAO tituloDAO;
	@Autowired
	private AutorDAO autorDAO;
	@Autowired
	private EjemplarDAO ejemplarDAO;

	Titulo titulo;

	public TituloController() {
		super();
		this.titulo = new Titulo();
	}

	@GetMapping("/ListarTitulos")
	public String listarTitulos(Model model) {
		List<Titulo> listadoTitulos = tituloDAO.findAll();
		Collections.sort(listadoTitulos, new TitleComparator());

		model.addAttribute("titulo", "Listado de Títulos");
		model.addAttribute("titulos", listadoTitulos);
		return "titulo/ListarTitulos";
	}

	@GetMapping("/guardarTitulo")
	public String altaTitulo(Model model) {
		model.addAttribute("tituloheader", "Dar de alta un Título");
		model.addAttribute("titulo", new Titulo());
		List<Autor> listadoAutores = autorDAO.findAll();
		Collections.sort(listadoAutores, new AutorComparator());

		model.addAttribute("listautores", listadoAutores);
		return "titulo/NuevoTitulo";
	}

	@PostMapping("/guardarTitulo")
	public String libroSubmit(@ModelAttribute Titulo titulo, Model model, RedirectAttributes attribute) {
		this.titulo = titulo;
		model.addAttribute("titulo", titulo);
		Titulo savedTitulo = tituloDAO.save(titulo);
		log.info("Saved title: {}", savedTitulo);
		Ejemplar ejemplar = new Ejemplar();
		ejemplar.setTit(savedTitulo);
		ejemplarDAO.save(ejemplar);
		attribute.addFlashAttribute("success", "Título creado correctamente");
		return "redirect:/ListarTitulos";
	}

	@GetMapping("/guardarTitulo/edit/{id}")
	public String formularioEditarTitulo(@PathVariable("id") long id, Model model) {
		Optional<Titulo> tituloEditar = tituloDAO.findById(id);
		List<Autor> listadoAutores = autorDAO.findAll();
		Collections.sort(listadoAutores, new AutorComparator());
		model.addAttribute("titulo", tituloEditar);
		model.addAttribute("listautores", listadoAutores);
		return "titulo/NuevoTitulo";
	}

	@PostMapping("/guardarTitulo/update/{id}")
	public String actualizarTitulo(@PathVariable("id") long id, Titulo tituloEditar, RedirectAttributes attribute) {
		tituloDAO.save(tituloEditar);
		attribute.addFlashAttribute("success", "Título modificado correctamente");
		return "ListarTitulos";
	}

	@GetMapping("delete/{id}")
	public String eliminarTitulo(@PathVariable("id") long idTitulo, RedirectAttributes attribute) {
		Optional<Titulo> tituloOpt = tituloDAO.findById(idTitulo);
		if(tituloOpt.isPresent()){
			Titulo t = tituloOpt.get();
			for (Ejemplar ej : t.getEjemplares()) {
				if (ej.getPrestamo() != null || ej.getReserva() != null) {
					attribute.addFlashAttribute("error",
							"No se puede eliminar el título porque tiene un ejemplar prestado o una reserva asociada");
					return "redirect:/ListarTitulos";
				}
			}
			List<Long> ids = List.of(Long.valueOf(idTitulo));
			List<Ejemplar> ejemplareslibro = ejemplarDAO.findAllById(ids);
			for (Ejemplar e : ejemplareslibro)
				ejemplarDAO.delete(e);
	
			tituloDAO.delete(t);
			attribute.addFlashAttribute("warning", "Título eliminado correctamente");
		}
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

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public TituloDAO getTituloDAO() {
		return tituloDAO;
	}

	public void setTituloDAO(TituloDAO tituloDAO) {
		this.tituloDAO = tituloDAO;
	}

	public AutorDAO getAutorDAO() {
		return autorDAO;
	}

	public void setAutorDAO(AutorDAO autorDAO) {
		this.autorDAO = autorDAO;
	}

	public EjemplarDAO getEjemplarDAO() {
		return ejemplarDAO;
	}

	public void setEjemplarDAO(EjemplarDAO ejemplarDAO) {
		this.ejemplarDAO = ejemplarDAO;
	}
}