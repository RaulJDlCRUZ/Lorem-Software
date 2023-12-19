package Lorem_Software.Library_Maintenance_System.business.entity;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutorTest {
	
	private static Autor autor;
	private static Set<Titulo> titulos = new HashSet<>();
	private static Set<Titulo> masTitulos = new HashSet<>();

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
		autor = new Autor("Leandro", "Paredes");
		autor.setId((long) 4000); //lo agregamos a mano, ya que el ID toma su valor por la BD
		titulos.add(new Titulo("Primer Libro", "978001"));
		titulos.add(new Titulo("Segundo Libro", "978010"));
		titulos.add(new Titulo("Tercer Libro", "978100"));
		// los titulos tampoco pertenecen al constructor; parámetro opcional
		autor.setTitulos(titulos);
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public final void testAutor() {
		// Podemos comparar sus atributos. Comparar todo el objeto resultará inutil (diferente referencia)
		Autor b = new Autor("Leandro", "Paredes");
		assertTrue( b.getNombre().equals(autor.getNombre()) && b.getApellido().equals(autor.getApellido()) );
	}

	@Test
	public final void testGetId() {
		assertNotNull(autor.getId());
	}
	
	@Test
	public final void testSetId() {
		Long l = (long) 500000;
		autor.setId(l);
		assertEquals(l, autor.getId());
	}

	@Test
	public final void testGetNombre() {
		assertEquals("Leandro", autor.getNombre());
	}

	@Test
	public final void testSetNombre() {
		String n = "Bryan";
		autor.setNombre(n);
		assertEquals(n,autor.getNombre());
	}

	@Test
	public final void testGetApellido() {
		assertEquals("Paredes", autor.getApellido());
	}

	@Test
	public final void testSetApellido() {
		String a = "Tarradellas";
		autor.setApellido(a);
		assertEquals(a,autor.getApellido());
	}

	@Test
	public final void testGetTitulos() {
		Set<Titulo> st = autor.getTitulos();
		assertEquals(titulos,st);
	}

	@Test
	final void testSetTitulos() {
		masTitulos.add(new Titulo("El Otro I","977001"));
		masTitulos.add(new Titulo("El Otro II","977002"));
		autor.setTitulos(masTitulos);
		assertEquals(masTitulos,autor.getTitulos());
	}

}