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

import Lorem_Software.Library_Maintenance_System.business.entity.Autor;
import Lorem_Software.Library_Maintenance_System.persistance.AutorDAO;

public class AutorControllerTest {
	
	@Autowired
	private static AutorController autorController;
	@Autowired
	private static AutorDAO autorDAO = Mockito.mock(AutorDAO.class);
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
		autorController = Mockito.mock(AutorController.class);
		model = Mockito.mock(Model.class);
	}

	@AfterEach
	public void tearDown() throws Exception {
		System.out.println("@AfterEach");
	}

	@Test
	public final void testAltaAutor() {
		String result = autorController.altaAutor(model);
		assertEquals(result, "autor/AltaAutor");
	}

	@Test
	public final void testAutorSubmit() {
		Autor aa = new Autor("Pepe", "Martí");
		when(autorDAO.save(aa)).thenAnswer(i -> i.getArguments()[0]);
		Autor guardado = autorDAO.save(aa);
		assertNotNull(guardado);
	}

	@Test
	public final void testFormularioEditarAutor() {
		long id = (long) 1;
		Optional<Autor> autor = autorDAO.findById(id);
		assertNotNull(autor);
		//!
		String result = autorController.formularioEditarAutor(id, model);
		assertEquals(result, "autor/AltaAutor");
	}

	@Test
	public final void testActualizarAutor() {
		Autor aa = new Autor("Carmen", "Jordá");
		when(autorDAO.save(aa)).thenAnswer(i -> i.getArguments()[0]);
		Autor guardado = autorDAO.save(aa);
		assertNotNull(guardado);
	}

	@Test
	public final void testDeleteAutor() {
		Autor aaa = new Autor("Daniil", "Kyvat");
		aaa.setId((long) 10000);
		Autor guardado_1 = autorDAO.save(aaa);
		autorDAO.deleteById((long) guardado_1.getId());
		assertNull(autorDAO.findById(aaa.getId()));
	}

}
