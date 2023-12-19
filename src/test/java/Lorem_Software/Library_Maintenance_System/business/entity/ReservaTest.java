package Lorem_Software.Library_Maintenance_System.business.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {
	
	private static Reserva reserva;
	private static Usuario usuario;
	private static Ejemplar ejemplar;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		usuario = new Usuario();
		usuario.setNombre("Nombre");
		usuario.setApellidos("Apellido de prueba");
		usuario.setIdUsuario((long) 12323);
		
		ejemplar = new Ejemplar();
		ejemplar.setIdEjemplar((long) 21311);
		
		reserva = new Reserva();
		reserva.setIdReserva((long) 10000);
		reserva.setFechaReserva(LocalDate.parse("2024-01-20"));
		
		ejemplar.setReserva(reserva);
		reserva.setUser(usuario);
		reserva.setEjem(ejemplar);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testReserva() {
		Reserva r = new Reserva();
		r.setIdReserva((long) 10000);
		r.setFechaReserva(LocalDate.parse("2024-01-20"));
		r.setUser(usuario);
		r.setEjem(ejemplar);
		
		assertEquals(r.getIdReserva(),reserva.getIdReserva());
		assertEquals(r.getFechaReserva(),reserva.getFechaReserva());
		assertEquals(r.getUser(),reserva.getUser());
		assertEquals(r.getEjem(),reserva.getEjem());
	}

	@Test
	void testGetIdReserva() {
		assertEquals(reserva.getIdReserva(),(long) 10000);
	}

	@Test
	void testSetIdReserva() {
		reserva.setIdReserva((long) 20000);
		assertEquals(reserva.getIdReserva(),(long) 20000);
	}

	@Test
	void testGetFechaReserva() {
		assertEquals(reserva.getFechaReserva(),LocalDate.parse("2024-01-20"));
	}

	@Test
	void testSetFechaReserva() {
		reserva.setFechaReserva(LocalDate.parse("2025-05-20"));
		assertEquals(reserva.getFechaReserva(),LocalDate.parse("2025-05-20"));
	}

	@Test
	void testGetEjem() {
		assertEquals(reserva.getEjem(),ejemplar);
	}

	@Test
	void testSetEjem() {
		Ejemplar ee = new Ejemplar();
		ee.setTit(new Titulo("Otro", "521352431"));
		ee.setIdEjemplar((long) 488);
		reserva.setEjem(ee);
		assertEquals(reserva.getEjem(),ee);
	}

	@Test
	void testGetUser() {
		assertEquals(reserva.getUser(),usuario);
	}

	@Test
	void testSetUser() {
		Usuario uuu = new Usuario();
		uuu.setIdUsuario((long) 2168643);
		uuu.setFechaFinPenalizacion(LocalDate.parse("2026-01-01"));
		uuu.setNombre("Paco");
		uuu.setApellidos("González");
		reserva.setUser(uuu);
		assertEquals(uuu,reserva.getUser());
	}

}