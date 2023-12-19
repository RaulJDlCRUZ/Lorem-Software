package Lorem_Software.Library_Maintenance_System.business.entity;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EjemplarTest {
	
	private static Prestamo prestamo;
	private static Titulo tituloDeEjemplo;
	private static Ejemplar ejemplar;
	private static Reserva reserva;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
		tituloDeEjemplo = new Titulo("Libro de prueba 2", "978013B13");
		
		ejemplar = new Ejemplar();
		ejemplar.setTit(tituloDeEjemplo);
		ejemplar.setIdEjemplar((long) 12001012);
		
		prestamo = new Prestamo();
		prestamo.setIdPrestamo((long) 100);
		prestamo.setActivo(true);
		prestamo.setEjem(ejemplar);
		
		reserva = new Reserva();
		reserva.setEjem(ejemplar);
		reserva.setIdReserva((long) 7777);
		
		prestamo.setEjem(ejemplar);
		ejemplar.setPrestamo(prestamo);
		ejemplar.setReserva(reserva);
	}

	@AfterEach
	public void tearDown() throws Exception {
	}
	
	@Test
	public final void testEjemplar() {
		Ejemplar e = new Ejemplar();
		e.setTit(tituloDeEjemplo);
		assertTrue(e.getTit().equals(ejemplar.getTit()));
	}
	
	@Test
	public void testgetIdEjemplar() {
		assertEquals((long) 12001012, ejemplar.getIdEjemplar());
	}
	
	@Test
	public void testsetIdEjemplar() {
		ejemplar.setIdEjemplar((long) 85544);
		assertEquals((long) 85544, ejemplar.getIdEjemplar());
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
	
	@Test
	public final void testGetPrestamo() {
		assertEquals(prestamo,ejemplar.getPrestamo());
	}

	@Test
	public final void testSetPrestamo() {
		Prestamo prestamo2 = new Prestamo();
		prestamo2.setIdPrestamo((long) 200);
		prestamo2.setActivo(false);
		ejemplar.setPrestamo(prestamo2);
		assertEquals(prestamo2,ejemplar.getPrestamo());
	}
	
	@Test
	public void testgetReserva() {
		assertEquals(reserva,ejemplar.getReserva());
	}

	@Test
	public void testsetReserva() {
		Reserva reserva2 = new Reserva();
		reserva2.setEjem(ejemplar);
		reserva2.setIdReserva((long) 6677);
		ejemplar.setReserva(reserva2);
		assertEquals(reserva2,ejemplar.getReserva());
	}

}