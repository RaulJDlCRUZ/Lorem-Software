package Lorem_Software.Library_Maintenance_System.business.controller;


import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Lorem_Software.Library_Maintenance_System.business.entity.Autor;
import Lorem_Software.Library_Maintenance_System.business.entity.Titulo;
import Lorem_Software.Library_Maintenance_System.persistance.TituloDAO;
import Lorem_Software.Library_Maintenance_System.persistance.AutorDAO;

public class TituloControllerTest {

	@Autowired
	private static TituloController tituloController;
	@Autowired
	private static TituloDAO tituloDAO = Mockito.mock(TituloDAO.class);
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
		tituloController = Mockito.mock(TituloController.class);
		model = Mockito.mock(Model.class);
	}

	@AfterEach
	public void tearDown() throws Exception {
		System.out.println("@AfterEach");
	}

	@Test
	public final void testListarTitulos() {
		assertNotNull(tituloDAO.findAll());
	}

	@Test
	public final void testAltaTitulo() {
		assertNotNull(autorDAO.findAll());
		String result = tituloController.altaTitulo(model);
		assertEquals(result, "titulo/NuevoTitulo");
	}

	@Test
	public final void testLibroSubmit() {
		Titulo tt = new Titulo("Libro de prueba", "978013C35");
		Set<Autor> autores = new HashSet<>();
		autores.add(new Autor("Autor I", "Apellido I"));
		autores.add(new Autor("Autor II", "Apellido II"));
		tt.setAutores(autores);
		when(tituloDAO.save(tt)).thenAnswer(i -> i.getArguments()[0]);
		Titulo guardado = tituloDAO.save(tt);
		assertNotNull(guardado);
	}
	
	@Test
	public final void testLibroSubmitSinAutores() {
		Titulo ttt = new Titulo("Libro de prueba 2", "978014L85");
		when(tituloDAO.save(ttt)).thenAnswer(i -> i.getArguments()[0]);
		Titulo guardado = tituloDAO.save(ttt);
		assertNotNull(guardado);
	}

	@Test
	public final void testFormularioEditarTitulo() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public final void testActualizarTitulo() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public final void testEliminarTitulo() {
		Titulo t = new Titulo("Libro de borrado", "00000000");
		t.setId((long) 100);
		Titulo guardado_1 = tituloDAO.save(t);
		tituloDAO.deleteById((long) guardado_1.getId());
		assertNull(tituloDAO.findById(t.getId()));
	}

}
