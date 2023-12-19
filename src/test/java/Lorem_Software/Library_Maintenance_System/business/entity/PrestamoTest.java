package Lorem_Software.Library_Maintenance_System.business.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrestamoTest {
	
	private static Prestamo prestamo;
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
		usuario.setApellidos("Apellido de ejemplo");
		
		ejemplar = new Ejemplar();
		ejemplar.setIdEjemplar((long) 122345);
		ejemplar.setTit(new Titulo("El Libro", "978002"));
		
		prestamo = new Prestamo();
		prestamo.setActivo(true);
		prestamo.setFechaInicio(LocalDate.parse("2023-12-20"));
		prestamo.setFechaFin(LocalDate.parse("2024-01-20"));
		prestamo.setIdPrestamo((long) 50000);
		prestamo.setUser(usuario);
		prestamo.setEjem(ejemplar);
		
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrestamo() {
		Prestamo p = new Prestamo();
		p.setActivo(true);
		p.setFechaInicio(LocalDate.parse("2023-12-20"));
		p.setFechaFin(LocalDate.parse("2024-01-20"));
		p.setIdPrestamo((long) 50000);
		p.setUser(usuario);
		p.setEjem(ejemplar);
		
		assertEquals(p.getEjem(),prestamo.getEjem());
		assertEquals(p.getFechaInicio(),prestamo.getFechaInicio());
		assertEquals(p.getFechaFin(),prestamo.getFechaFin());
		assertEquals(p.getIdPrestamo(),prestamo.getIdPrestamo());
	}

	@Test
	public void testGetIdPrestamo() {
		assertEquals(prestamo.getIdPrestamo(), (long) 50000);
	}

	@Test
	public void testSetIdPrestamo() {
		prestamo.setIdPrestamo((long) 60000);
		assertEquals(prestamo.getIdPrestamo(), (long) 60000);
	}

	@Test
	public void testGetFechaInicio() {
		assertEquals(prestamo.getFechaInicio(),LocalDate.parse("2023-12-20"));
	}

	@Test
	public void testSetFechaInicio() {
		prestamo.setFechaInicio(LocalDate.parse("2023-11-21"));
		assertEquals(prestamo.getFechaInicio(),LocalDate.parse("2023-11-21"));
	}

	@Test
	public void testGetFechaFin() {
		assertEquals(prestamo.getFechaFin(),LocalDate.parse("2024-01-20"));
	}

	@Test
	public void testSetFechaFin() {
		prestamo.setFechaFin(LocalDate.parse("2023-12-21"));
		assertEquals(prestamo.getFechaFin(),LocalDate.parse("2023-12-21"));
	}

	@Test
	public void testIsActivo() {
		assertEquals(prestamo.isActivo(),true);
	}

	@Test
	public void testSetActivo() {
		prestamo.setActivo(false);
		assertEquals(prestamo.isActivo(),false);
	}

	@Test
	public void testGetEjem() {
		assertEquals(prestamo.getEjem(),ejemplar);
	}

	@Test
	public void testSetEjem() {
		Ejemplar e2 = new Ejemplar();
		e2.setTit(new Titulo("Titulo II", "9786256"));
		prestamo.setEjem(e2);
		assertEquals(prestamo.getEjem(),e2);
	}

	@Test
	public void testGetUser() {
		assertEquals(usuario,prestamo.getUser());
	}

	@Test
	public void testSetUser() {
		Usuario u2 = new Usuario();
		u2.setNombre("Nombre 2");
		u2.setIdUsuario((long) 4556);
		prestamo.setUser(u2);
		assertEquals(u2,prestamo.getUser());
	}

}