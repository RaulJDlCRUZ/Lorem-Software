package Lorem_Software.Library_Maintenance_System.business.controller;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Lorem_Software.Library_Maintenance_System.business.entity.Titulo;
import Lorem_Software.Library_Maintenance_System.persistance.EjemplarDAO;
import Lorem_Software.Library_Maintenance_System.persistance.TituloDAO;

public class EjemplarControllerTest {

	@Autowired
	private static EjemplarController ejemplarController;
	@Autowired
	private static TituloDAO tituloDAO = Mockito.mock(TituloDAO.class);
	private static EjemplarDAO ejemplarDAO = Mockito.mock(EjemplarDAO.class);	
	private static Model model;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeAll");
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterAll");
	}

	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("@BeforeEach");
		ejemplarController = Mockito.mock(EjemplarController.class);
		model = Mockito.mock(Model.class);
	}

	@AfterEach
	public void tearDown() throws Exception {
		System.out.println("@AfterEach");
	}
	
	@Test
	public final void testListarEjemplares() {
		assertNotNull(ejemplarDAO.findAll());
	}

	@Test
	public final void testAltaEjemplar() {
		assertNotNull(tituloDAO.findAll());
	}

	@Test
	public final void testEjemplarSubmit() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public final void testEliminarTitulo() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

}
