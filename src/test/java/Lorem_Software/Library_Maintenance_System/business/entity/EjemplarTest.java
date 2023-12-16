package Lorem_Software.Library_Maintenance_System.business.entity;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EjemplarTest {
	
	private static Titulo tituloDeEjemplo;
	private static Ejemplar ejemplar;

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
		ejemplar = new Ejemplar();
		tituloDeEjemplo = new Titulo("Libro de prueba 2", "978013B13");
		ejemplar.setTit(tituloDeEjemplo);
	}

	@AfterEach
	public void tearDown() throws Exception {
		System.out.println("@AfterEach");
	}
	
	@Test
	public final void testEjemplar() {
		Ejemplar e = new Ejemplar();
		e.setTit(tituloDeEjemplo); //sin esto, fallará al no tener un titulo vinculado
		assertTrue(e.getTit().equals(ejemplar.getTit()));
	}

	@Test
	public final void testGetIdPrestamo() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public final void testSetIdPrestamo() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public final void testGetTit() {
		assertEquals(tituloDeEjemplo,ejemplar.getTit());
	}

	@Test
	public final void testSetTit() {
		Titulo tt = new Titulo("Otro título para un ejemplar", "978.00.1A");
		ejemplar.setTit(tt);
		assertEquals(tt, ejemplar.getTit());
	}

}
