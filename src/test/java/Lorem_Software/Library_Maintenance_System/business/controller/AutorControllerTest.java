package Lorem_Software.Library_Maintenance_System.business.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import Lorem_Software.Library_Maintenance_System.business.entity.Autor;
import Lorem_Software.Library_Maintenance_System.persistance.AutorDAO;


class AutorControllerTest {

	@Autowired
	private static AutorController autorController;
	@Autowired
	private static AutorDAO autorDAO = mock(AutorDAO.class);
	private static Model model;
	private static RedirectAttributes attribute;
	private static Autor aa;
	
	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		autorController = new AutorController();
	}

	@AfterAll
	protected static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	protected void setUp() throws Exception {
		long id = (long) 11200;
		aa = new Autor("Pepe", "Martí");
		aa.setId(id);
		
		model = mock(Model.class);
		attribute = mock(RedirectAttributes.class);
		autorController.setAutorDAO(autorDAO);
		when(autorDAO.save(aa)).thenAnswer(i -> i.getArguments()[0]);
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}
	
	@Test
	void altaAutorTest() {
		String result = autorController.altaAutor(model);
		assertNotNull(result);
		assertEquals("autor/AltaAutor", result);
	}
	
	@Test
	final void testAutorSubmit() {
		Autor guardado = autorDAO.save(aa);
		assertNotNull(guardado);
		assertTrue(guardado.getId() > 0);
		assertEquals(aa, guardado);
		String result = autorController.autorSubmit(aa, model, attribute);
		assertEquals("redirect:/AltaAutor",result);
	}
	
	@Test
	final void testFormularioEditarAutor() {
		when(autorDAO.findById(aa.getId())).thenReturn(java.util.Optional.ofNullable(aa));
		
		Autor guardado = autorDAO.save(aa);
		assertNotNull(guardado);
		
		Optional <Autor> autor = autorDAO.findById(guardado.getId());
		assertFalse(autor.isEmpty());
		assertEquals(aa, autor.get());
		
		String result = autorController.formularioEditarAutor((long) aa.getId(), model);
		assertEquals("autor/AltaAutor", result);
	}
	
	@Test
	final void testActualizarAutor() {
		when(autorDAO.findById(aa.getId())).thenReturn(java.util.Optional.ofNullable(aa));
		
		Autor guardado = autorDAO.save(aa);
		assertNotNull(guardado);
		
		Optional <Autor> autor = autorDAO.findById(guardado.getId());
		assertFalse(autor.isEmpty());
		Autor ab = autor.get();
		ab.setNombre("Carmen");
		ab.setApellido("Jordá");
		
		Autor guardado2 = autorDAO.save(ab);
		assertEquals(aa.getId(),guardado2.getId());
		assertEquals(ab, guardado2);
	}
	
	@Test
	final void testDeleteAutor() {
		when(autorDAO.findById(aa.getId())).thenReturn(java.util.Optional.ofNullable(aa));
		Autor guardado = autorDAO.save(aa);
		assertNotNull(guardado);
		autorDAO.deleteById((long) guardado.getId());
		// no devuelve nada, con verificar que se ha ejecutado nos servirá
		verify(autorDAO, times(1)).deleteById((long) guardado.getId());
	}

}