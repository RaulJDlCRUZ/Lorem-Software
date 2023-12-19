package Lorem_Software.Library_Maintenance_System.business.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Lorem_Software.Library_Maintenance_System.business.entity.Ejemplar;
import Lorem_Software.Library_Maintenance_System.business.entity.Titulo;
import Lorem_Software.Library_Maintenance_System.persistance.EjemplarDAO;
import Lorem_Software.Library_Maintenance_System.persistance.TituloDAO;

class EjemplarControllerTest {

	@Autowired
	private static EjemplarController ejemplarController;
	@Autowired
	private static TituloDAO tituloDAO = Mockito.mock(TituloDAO.class);
	private static EjemplarDAO ejemplarDAO = Mockito.mock(EjemplarDAO.class);	
	private static Model model;
	private static Ejemplar ee;
	private static Titulo tt;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ejemplarController = new EjemplarController();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		tt = new Titulo("Título de prueba","978000001");
		tt.setId((long) 100001);
		ee = new Ejemplar();
		ee.setTit(tt);
		ee.setIdEjemplar((long) 101);
		model = Mockito.mock(Model.class);
		ejemplarController.setTituloDAO(tituloDAO);
		ejemplarController.setEjemplarDAO(ejemplarDAO);
		when(ejemplarDAO.save(ee)).thenAnswer(i -> i.getArguments()[0]);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	final void testListarEjemplaresParaUnTitulo() {
		Ejemplar guardado = ejemplarDAO.save(ee);
		when(ejemplarDAO.findAll()).thenReturn(java.util.List.of(ee));
        List<Ejemplar> ejemplaresProv = ejemplarDAO.findAll();
        List<Ejemplar> ejemplares =new ArrayList<Ejemplar>();
        String TituloName="";

        for(Ejemplar e:ejemplaresProv){
            if(e.getTit().getId().equals(tt.getId())){
                TituloName=e.getTit().getTitulo();
                ejemplares.add(e);
            }
        }
        
        assertFalse(ejemplares.isEmpty());
//        System.out.println(ejemplares.getFirst().getIdEjemplar()+" "+ejemplares.getFirst().getTit().getTitulo());
        String result = ejemplarController.listarEjemplares(tt.getId(), model);
        assertEquals("ejemplar/ListarEjemplares", result);
	}

	@Test
	final void testAltaEjemplar() {
		String result = ejemplarController.altaEjemplar(model);
		assertNotNull(result);
		assertEquals("ejemplar/NuevoEjemplar", result);
	}

	@Test
	final void testEjemplarSubmit() {
		Ejemplar guardado = ejemplarDAO.save(ee);
		assertNotNull(guardado);
	}

	@Test
	final void testEliminarTitulo() {
		when(ejemplarDAO.findById(ee.getIdEjemplar())).thenReturn(java.util.Optional.ofNullable(ee));
		
		Ejemplar guardado = ejemplarDAO.save(ee);
		
		assertNotNull(guardado);
		ejemplarDAO.deleteById((long) guardado.getIdEjemplar());
		// no devuelve nada, con verificar que se ha ejecutado nos servirá
		verify(ejemplarDAO, times(1)).deleteById((long) guardado.getIdEjemplar());
	}

}