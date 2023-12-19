package Lorem_Software.Library_Maintenance_System.business.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReservaTest {
	
	private static Reserva reserva;
	private static Usuario usuario;
	private static Ejemplar ejemplar;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
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
	public void tearDown() throws Exception {
	}

	@Test
	public void testReserva() {
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
	public void testGetIdReserva() {
		assertEquals(reserva.getIdReserva(),(long) 10000);
	}

	@Test
	public void testSetIdReserva() {
		reserva.setIdReserva((long) 20000);
		assertEquals(reserva.getIdReserva(),(long) 20000);
	}

	@Test
	public void testGetFechaReserva() {
		assertEquals(reserva.getFechaReserva(),LocalDate.parse("2024-01-20"));
	}

	@Test
	public void testSetFechaReserva() {
		reserva.setFechaReserva(LocalDate.parse("2025-05-20"));
		assertEquals(reserva.getFechaReserva(),LocalDate.parse("2025-05-20"));
	}

	@Test
	public void testGetEjem() {
		assertEquals(reserva.getEjem(),ejemplar);
	}

	@Test
	public void testSetEjem() {
		Ejemplar ee = new Ejemplar();
		ee.setTit(new Titulo("Otro", "521352431"));
		ee.setIdEjemplar((long) 488);
		reserva.setEjem(ee);
		assertEquals(reserva.getEjem(),ee);
	}

	@Test
	public void testGetUser() {
		assertEquals(reserva.getUser(),usuario);
	}

	@Test
	public void testSetUser() {
		Usuario uuu = new Usuario();
		uuu.setIdUsuario((long) 2168643);
		uuu.setFechaFinPenalizacion(LocalDate.parse("2026-01-01"));
		uuu.setNombre("Paco");
		uuu.setApellidos("González");
		reserva.setUser(uuu);
		assertEquals(uuu,reserva.getUser());
	}

}