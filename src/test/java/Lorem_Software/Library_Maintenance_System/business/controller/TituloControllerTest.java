package Lorem_Software.Library_Maintenance_System.business.controller;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Lorem_Software.Library_Maintenance_System.business.entity.Autor;
import Lorem_Software.Library_Maintenance_System.business.entity.Ejemplar;
import Lorem_Software.Library_Maintenance_System.business.entity.Titulo;
import Lorem_Software.Library_Maintenance_System.persistance.AutorDAO;
import Lorem_Software.Library_Maintenance_System.persistance.EjemplarDAO;
import Lorem_Software.Library_Maintenance_System.persistance.TituloDAO;

class TituloControllerTest {

	@Autowired
	private static TituloController tituloController;
	@Autowired
	private static TituloDAO tituloDAO = mock(TituloDAO.class);
	private static AutorDAO autorDAO = mock(AutorDAO.class);
	private static EjemplarDAO ejemplarDAO = mock(EjemplarDAO.class);
	private static Model model;
	private static Titulo tt;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tituloController = new TituloController();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		tt = new Titulo("Libro de prueba", "978013C35");
		tt.setId((long) 102220);
		model = mock(Model.class);
		tituloController.setTituloDAO(tituloDAO);
		tituloController.setAutorDAO(autorDAO);
		tituloController.setEjemplarDAO(ejemplarDAO);
		when(tituloDAO.save(tt)).thenAnswer(i -> i.getArguments()[0]);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testListarTitulosSin() {
		when(tituloDAO.findAll()).thenReturn(java.util.List.of());
		List<Titulo> listatitulos = tituloDAO.findAll();
		assertEquals(0, listatitulos.size());
	}
	
	@Test
	final void testListarTitulosCon() {
		when(tituloDAO.findAll()).thenReturn(java.util.List.of(tt));
		Titulo t = tituloDAO.save(tt);
		assertEquals(tt,t);
		List<Titulo> listatitulos2 = tituloDAO.findAll();
		assertNotEquals(0, listatitulos2.size());
	}

	@Test
	final void testAltaTitulo() {
		String result = tituloController.altaTitulo(model);
		assertNotNull(result);
		assertEquals("titulo/NuevoTitulo", result);
	}

	@Test
	final void testLibroSubmit() {		
		Titulo guardado = tituloDAO.save(tt);
		assertNotNull(guardado);
	}
	
	@Test
	final void testLibroSubmitConAutores() {
		Set<Autor> autores = new HashSet<>();
		autores.add(new Autor("Autor I", "Apellido I"));
		autores.add(new Autor("Autor II", "Apellido II"));
		tt.setAutores(autores);
		Titulo guardado = tituloDAO.save(tt);
		assertNotNull(guardado);
	}
	
	@Test
	final void testLibroSubmitConEjemplares() {
		Set<Ejemplar> ejemplares = new HashSet<>();
		Ejemplar e = new Ejemplar();
		e.setTit(tt);
		e.setIdEjemplar((long) 101);
		Ejemplar ee = new Ejemplar();
		ee.setTit(tt);
		ee.setIdEjemplar((long) 102);
		ejemplares.add(e);
		ejemplares.add(ee);
		tt.setEjemplares(ejemplares);
		Titulo guardado = tituloDAO.save(tt);
		assertNotNull(guardado);
	}

	@Test
	final void testFormularioEditarTitulo() {
		when(tituloDAO.findById(tt.getId())).thenReturn(java.util.Optional.ofNullable(tt));
		
		Titulo guardado = tituloDAO.save(tt);
		assertNotNull(guardado);
		
		Optional <Titulo> titulo = tituloDAO.findById(guardado.getId());
		assertFalse(titulo.isEmpty());
		assertEquals(tt, titulo.get());
		
		String result = tituloController.formularioEditarTitulo((long) tt.getId(), model);
		assertEquals("titulo/NuevoTitulo", result);
	}

	@Test
	final void testActualizarTitulo() {
		when(tituloDAO.findById(tt.getId())).thenReturn(java.util.Optional.ofNullable(tt));
		
		Titulo guardado = tituloDAO.save(tt);
		assertNotNull(guardado);
//		System.out.println("["+guardado.getId()+"] "+guardado.getNombre()+" "+guardado.getApellido());
		
		Optional <Titulo> titulo = tituloDAO.findById(guardado.getId());
		assertEquals(tt, titulo.get());
		Titulo tb = titulo.get();
		tb.setTitulo("Titulo de prueba");
		tb.setISBN("9780000000000");
		
		Titulo guardado2 = tituloDAO.save(tb);
		assertEquals(tt.getId(),guardado2.getId());
		assertEquals(tb, guardado2);
//		System.out.println("["+guardado2.getId()+"] "+guardado2.getNombre()+" "+guardado2.getApellido());
	}

	@Test
	final void testEliminarTitulo() {
		when(tituloDAO.findById(tt.getId())).thenReturn(java.util.Optional.ofNullable(tt));
		
		Titulo guardado = tituloDAO.save(tt);
		
		assertNotNull(guardado);
		tituloDAO.deleteById((long) guardado.getId());
		// no devuelve nada, con verificar que se ha ejecutado nos servirá
		verify(tituloDAO, times(1)).deleteById((long) guardado.getId());
	}

}