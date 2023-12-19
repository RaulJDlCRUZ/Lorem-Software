package Lorem_Software.Library_Maintenance_System.business.entity;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	
	private static Usuario usuario;
	private static Set<Reserva> reservas = new HashSet<>();
	private static Set<Prestamo> prestamos = new HashSet<>();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		usuario = new Usuario();
		Prestamo prestamo = new Prestamo();
		Prestamo prestamo1 = new Prestamo();
		
		prestamo1.setIdPrestamo((long) 624875);
		prestamo1.setFechaInicio(LocalDate.parse("2023-10-15"));
		prestamo1.setFechaFin(LocalDate.parse("2023-11-15"));
		prestamo1.setActivo(true);
		prestamo1.setUser(usuario);
		
		prestamo.setIdPrestamo((long) 40805);
		prestamo.setActivo(true);
		prestamo.setFechaInicio(LocalDate.parse("2023-09-23"));
		prestamo.setFechaFin(LocalDate.parse("2023-10-23"));
		prestamo.setUser(usuario);
		prestamos.add(prestamo);
		prestamos.add(prestamo1);
		
		usuario.setIdUsuario((long) 43855);
		usuario.setNombre("Luis");
		usuario.setApellidos("Jiménez");
		usuario.setFechaFinPenalizacion(LocalDate.parse("2023-12-17"));
		usuario.setPrestamos(prestamos);
		usuario.setReservas(reservas);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testUsuario() {
		Usuario newusr = new Usuario();
		newusr.setIdUsuario((long) 43855);
		newusr.setNombre("Luis");
		newusr.setApellidos("Jiménez");
		newusr.setFechaFinPenalizacion(LocalDate.parse("2023-12-17"));
		newusr.setPrestamos(prestamos);
		newusr.setReservas(reservas);
		
		assertEquals(newusr.getApellidos(),usuario.getApellidos());
		assertEquals(newusr.getFechaFinPenalizacion(),usuario.getFechaFinPenalizacion());
		assertEquals(newusr.getIdUsuario(),usuario.getIdUsuario());
		assertEquals(newusr.getNombre(),usuario.getNombre());
		assertEquals(newusr.getPrestamos(),prestamos);
		assertEquals(newusr.getReservas(),usuario.getReservas());
	}

	@Test
	void testGetIdUsuario() {
		assertEquals(usuario.getIdUsuario(),(long) 43855);
	}

	@Test
	void testSetIdUsuario() {
		usuario.setIdUsuario((long) 341);
		assertNotEquals(usuario.getIdUsuario(),(long) 43855);
		assertEquals(usuario.getIdUsuario(),(long) 341);
	}

	@Test
	void testGetNombre() {
		assertEquals("Luis", usuario.getNombre());
	}

	@Test
	void testSetNombre() {
		usuario.setNombre("Luisillo");
		assertNotEquals(usuario.getNombre(),"Luis");
		assertEquals("Luisillo",usuario.getNombre());
	}

	@Test
	void testGetApellidos() {
		assertEquals("Jiménez",usuario.getApellidos());
	}

	@Test
	void testSetApellidos() {
		usuario.setApellidos("Ximenez");
		assertNotEquals(usuario.getApellidos(),"Jiménez");
		assertEquals("Ximenez",usuario.getApellidos());
	}

	@Test
	void testGetFechaFinPenalizacion() {
		assertEquals(usuario.getFechaFinPenalizacion(),LocalDate.parse("2023-12-17"));
	}

	@Test
	void testSetFechaFinPenalizacion() {
		usuario.setFechaFinPenalizacion(LocalDate.parse("2024-12-17"));
		assertNotEquals(usuario.getFechaFinPenalizacion(),LocalDate.parse("2023-12-17"));
		assertEquals(usuario.getFechaFinPenalizacion(),LocalDate.parse("2024-12-17"));
	}

	@Test
	void testGetPrestamos() {
		assertEquals(usuario.getPrestamos(),prestamos);
	}

	@Test
	void testSetPrestamos() {
		Set<Prestamo> prestamos2 = new HashSet<>();
		usuario.setPrestamos(prestamos2);
		assertNotEquals(usuario.getPrestamos(),prestamos);
		assertEquals(usuario.getPrestamos(),prestamos2);
		
	}

	@Test
	void testGetReservas() {
		assertEquals(usuario.getReservas(),reservas);
	}

	@Test
	void testSetReservas() {
		Set<Reserva> reservas2 = new HashSet<>();
		Reserva reserva2 = new Reserva();
		reserva2.setIdReserva((long) 43855);
		reserva2.setFechaReserva(LocalDate.parse("2023-11-26"));
		reserva2.setUser(usuario);
		reservas2.add(reserva2);
		usuario.setReservas(reservas2);
		assertNotEquals(usuario.getReservas(),reservas);
		assertEquals(usuario.getReservas(),reservas2);
	}

}