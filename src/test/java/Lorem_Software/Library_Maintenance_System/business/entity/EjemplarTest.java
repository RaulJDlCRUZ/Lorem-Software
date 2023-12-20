package Lorem_Software.Library_Maintenance_System.business.entity;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EjemplarTest {
	
	private static Prestamo prestamo;
	private static Titulo tituloDeEjemplo;
	private static Ejemplar ejemplar;
	private static Reserva reserva;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
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
	void tearDown() throws Exception {
	}
	
	@Test
	final void testEjemplar() {
		Ejemplar e = new Ejemplar();
		e.setTit(tituloDeEjemplo);
		assertEquals(e.getTit(), ejemplar.getTit());
	}
	
	@Test
	void testgetIdEjemplar() {
		assertEquals((long) 12001012, ejemplar.getIdEjemplar());
	}
	
	@Test
	void testsetIdEjemplar() {
		ejemplar.setIdEjemplar((long) 85544);
		assertEquals((long) 85544, ejemplar.getIdEjemplar());
	}

	@Test
	final void testGetTit() {
		assertEquals(tituloDeEjemplo,ejemplar.getTit());
	}
	
	@Test
	final void testSetTit() {
		Titulo tt = new Titulo("Otro título para un ejemplar", "978.00.1A");
		ejemplar.setTit(tt);
		assertEquals(tt, ejemplar.getTit());
	}
	
	@Test
	final void testGetPrestamo() {
		assertEquals(prestamo,ejemplar.getPrestamo());
	}

	@Test
	final void testSetPrestamo() {
		Prestamo prestamo2 = new Prestamo();
		prestamo2.setIdPrestamo((long) 200);
		prestamo2.setActivo(false);
		ejemplar.setPrestamo(prestamo2);
		assertEquals(prestamo2,ejemplar.getPrestamo());
	}
	
	@Test
	void testgetReserva() {
		assertEquals(reserva,ejemplar.getReserva());
	}

	@Test
	void testsetReserva() {
		Reserva reserva2 = new Reserva();
		reserva2.setEjem(ejemplar);
		reserva2.setIdReserva((long) 6677);
		ejemplar.setReserva(reserva2);
		assertEquals(reserva2,ejemplar.getReserva());
	}

}