package Lorem_Software.Library_Maintenance_System.business.entity;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TituloTest {
	
	private static Titulo titulo;
	private static Set<Autor> misAutores = new HashSet<>();
	private static Set<Autor> masAutores = new HashSet<>();
	private static Set<Ejemplar> misEjs = new HashSet<>();
	private static Set<Ejemplar> masEjs = new HashSet<>();
	
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
		titulo = new Titulo("Libro de prueba", "978013A15");
		titulo.setId((long) 700); //lo agregamos a mano, ya que el ID toma su valor por la BD
		misEjs.add(new Ejemplar());
		misEjs.add(new Ejemplar());
		misAutores.add(new Autor("Fulanito I", "El Sabio"));
		misAutores.add(new Autor("Menganito II", "El Grande"));
		// los autores tampoco pertenecen al constructor; parámetro opcional
		titulo.setAutores(misAutores);
		titulo.setEjemplares(misEjs);
	}

	@AfterEach
	public void tearDown() throws Exception {
		System.out.println("@AfterEach");
	}

	@Test
	void testTitulo() {
		// Podemos comparar sus atributos. Comparar todo el objeto resultará inutil (diferente referencia)
		Titulo t = new Titulo("Libro de prueba", "978013A15");
		assertTrue(t.getTitulo().equals(titulo.getTitulo()) && t.getISBN().equals(titulo.getISBN()));
	}

	@Test
	public final void testGetId() {
		assertTrue(titulo.getId()==700);
	}
	
	@Test
	public final void testSetId() {
		Long l = (long) 300000;
		titulo.setId(l);
		assertEquals(l, titulo.getId());
	}

	@Test
	void testGetISBN() {
		assertEquals("978013A15",titulo.getISBN());
	}

	@Test
	void testSetISBN() {
		String isbn = "978-83-934893-4-3";
		titulo.setISBN(isbn);
		assertEquals(isbn,titulo.getISBN());
	}

	@Test
	void testGetTitulo() {
		assertEquals("Libro de prueba",titulo.getTitulo());
	}

	@Test
	void testSetTitulo() {
		String t = "Otro posible título de prueba";
		titulo.setTitulo(t);
		assertEquals(t,titulo.getTitulo());
	}

	@Test
	void testGetNumReserva() {
		fail("Not yet implemented");
	}

	@Test
	void testSetNumReserva() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAutores() {
		assertEquals(misAutores,titulo.getAutores());
	}

	@Test
	void testSetAutores() {
		masAutores.add(new Autor("Dani","Carvajal"));
		masAutores.add(new Autor("Sergio","Ramos"));
		titulo.setAutores(masAutores);
		assertEquals(masAutores,titulo.getAutores());
	}

	@Test
	void testGetEjemplares() {
		assertEquals(misEjs,titulo.getEjemplares());
	}

	@Test
	void testSetEjemplares() {
		fail("Not yet implemented");
	}

}
