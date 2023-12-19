package Lorem_Software.Library_Maintenance_System.business.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import Lorem_Software.Library_Maintenance_System.business.entity.Ejemplar;
import Lorem_Software.Library_Maintenance_System.business.entity.Titulo;
import Lorem_Software.Library_Maintenance_System.persistance.EjemplarDAO;
import Lorem_Software.Library_Maintenance_System.persistance.TituloDAO;

@Controller
public class EjemplarController {
    private static final Logger log = LoggerFactory.getLogger(EjemplarController.class);
    final int MAX_ELEMENTS = 20;

    @Autowired
    private EjemplarDAO ejemplarDAO;

    @Autowired
    private TituloDAO tituloDAO;

    Ejemplar ejemplar;
    
    public EjemplarController() {
    	super();
    	this.ejemplar=new Ejemplar();
    }

    @GetMapping("/ListarEjemplares/{idTitulo}")
    public String listarEjemplares(@PathVariable("idTitulo") long idTitulo, Model model){
        List<Ejemplar> ejemplaresProv = ejemplarDAO.findAll();
        List<Ejemplar> ejemplares =new ArrayList<Ejemplar>();
        String TituloName="";

        for(Ejemplar e:ejemplaresProv){
            if(e.getTit().getId().equals(idTitulo)){
                TituloName=e.getTit().getTitulo();
                ejemplares.add(e);
            }
        }

        model.addAttribute("ListEjemplarHeader", "Lista de Ejemplares de "+ TituloName);
        model.addAttribute("ejemplares", ejemplares);

        return "ejemplar/ListarEjemplares";
    }

    @GetMapping("/AltaEjemplar")
    public String altaEjemplar(Model model) {
        //Atributo para título de la página
        model.addAttribute("ejemplarheader", "Añadir un Ejemplar");

        //Atributo de Ejemplar vacío para el formulario
        model.addAttribute("ejemplares", new Ejemplar());

        //Atributo lista de Títulos, para mostrar en el selector
        List<Titulo> listadoTitulos = tituloDAO.findAll();

        //Ordenamos la lista por el nombre del Título
        Collections.sort(listadoTitulos, new TitleComparator());
        model.addAttribute("listatitulos", listadoTitulos);

        return "ejemplar/NuevoEjemplar";
    }

    @PostMapping("/AltaEjemplar")
    public String ejemplarSubmit(@ModelAttribute Ejemplar ejemplar, Model model, RedirectAttributes attribute) {
        log.info("El id del ejemplar es"+ejemplar.getIdEjemplar());
        this.ejemplar = ejemplar;
        model.addAttribute("ejemplar", ejemplar);
        ejemplarDAO.save(ejemplar);
        attribute.addFlashAttribute("success", "El ejemplar se ha dado correctamente de alta");
        return "redirect:/ListarTitulos";
    }

    @GetMapping("/AltaEjemplar/delete/{IdPrestamo}")
	public String eliminarTitulo(@PathVariable("IdPrestamo") long IdPrestamo, RedirectAttributes attribute){
        if(ejemplarDAO.findById(IdPrestamo).get().getPrestamo()!=null || ejemplarDAO.findById(IdPrestamo).get().getReserva() != null){
            attribute.addFlashAttribute("error", "No se puede eliminar el ejemplar porque está prestado o tiene una reserva");
            return "redirect:/ListarEjemplares/"+ejemplarDAO.findById(IdPrestamo).get().getTit().getId();
        }
		ejemplarDAO.deleteById(IdPrestamo);
        attribute.addFlashAttribute("warning", "El ejemplar ha sido eliminado");
		return "redirect:/ListarTitulos";
	}

    class TitleComparator implements java.util.Comparator<Titulo> {
		@Override
		public int compare(Titulo a, Titulo b) {
			return a.getTitulo().compareTo(b.getTitulo());
		}
	}

	public EjemplarDAO getEjemplarDAO() {
		return ejemplarDAO;
	}

	public void setEjemplarDAO(EjemplarDAO ejemplarDAO) {
		this.ejemplarDAO = ejemplarDAO;
	}

	public TituloDAO getTituloDAO() {
		return tituloDAO;
	}

	public void setTituloDAO(TituloDAO tituloDAO) {
		this.tituloDAO = tituloDAO;
	}

	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}

}
