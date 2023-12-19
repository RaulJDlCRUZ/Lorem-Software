package Lorem_Software.Library_Maintenance_System.business.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Lorem_Software.Library_Maintenance_System.business.entity.Ejemplar;
import Lorem_Software.Library_Maintenance_System.business.entity.Prestamo;
import Lorem_Software.Library_Maintenance_System.business.entity.Reserva;
import Lorem_Software.Library_Maintenance_System.business.entity.Titulo;
import Lorem_Software.Library_Maintenance_System.business.entity.Usuario;
import Lorem_Software.Library_Maintenance_System.persistance.EjemplarDAO;
import Lorem_Software.Library_Maintenance_System.persistance.PrestamoDAO;
import Lorem_Software.Library_Maintenance_System.persistance.ReservaDAO;
import Lorem_Software.Library_Maintenance_System.persistance.UsuarioDAO;

class PrestamoReservaControllerTest {
	
	@Autowired
	private static PrestamoReservaController prController;
	@Autowired
	private static PrestamoDAO prestamoDAO = mock(PrestamoDAO.class);
	@Autowired
	private static ReservaDAO reservaDAO = mock(ReservaDAO.class);
	@Autowired
	private static UsuarioDAO usuarioDAO = mock(UsuarioDAO.class);
	@Autowired
	private static EjemplarDAO ejemplarDAO = Mockito.mock(EjemplarDAO.class);	
	private static Model model;
	private static Ejemplar ee;
	private static Prestamo pp;
	private static Reserva rr;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		prController = new PrestamoReservaController();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		Set<Prestamo> sp = new HashSet<Prestamo>();
		Usuario uu = new Usuario();
		
		uu.setIdUsuario((long) 1231);
		uu.setNombre("Jose");
		uu.setApellidos("Julián");
		uu.setPrestamos(sp);
		
		pp = new Prestamo();
		pp.setActivo(true);
		pp.setFechaInicio(LocalDate.parse("2023-03-12"));
		pp.setFechaFin(LocalDate.parse("2023-04-12"));
		pp.setUser(uu);
		sp.add(pp);
		
		ee = new Ejemplar();
		ee.setTit(new Titulo("Título de prueba","978000001"));
		ee.setIdEjemplar((long) 102);
		
		pp.setEjem(ee);
		ee.setPrestamo(pp);
		
		model = Mockito.mock(Model.class);
		prController.setPrestamoDAO(prestamoDAO);
		prController.setUsuarioDAO(usuarioDAO);
		prController.setReservaDAO(reservaDAO);
		prController.setEjemplarDAO(ejemplarDAO);
		
		when(usuarioDAO.save(uu)).thenAnswer(i -> i.getArguments()[0]);
		when(ejemplarDAO.save(ee)).thenAnswer(i -> i.getArguments()[0]);
		when(prestamoDAO.save(pp)).thenAnswer(i -> i.getArguments()[0]);
		when(reservaDAO.save(rr)).thenAnswer(i -> i.getArguments()[0]);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testListarEjemplaresdePrestamos() {
		List<Ejemplar> listaejemplares = ejemplarDAO.findAll();
		assertEquals(0,listaejemplares.size());
		Ejemplar guardado = ejemplarDAO.save(ee);
		when(ejemplarDAO.findAll()).thenReturn(java.util.List.of(ee));
		listaejemplares = ejemplarDAO.findAll();
		assertNotEquals(0,listaejemplares.size());
	}
	
	@Test
	final void testComprobarPenalizacionesEjemplaresDesdeActual() {
		assertNotNull(ee.getPrestamo());
		assertTrue(LocalDate.now().isAfter(ee.getPrestamo().getFechaFin().plusMonths(3)));
		Usuario usr = ee.getPrestamo().getUser();
		assertTrue(usr.getFechaFinPenalizacion()==null || usr.getFechaFinPenalizacion().isBefore(LocalDate.now()));
		usr.setFechaFinPenalizacion(LocalDate.now().plusYears(3));
		assertEquals(LocalDate.now().plusYears(3),usr.getFechaFinPenalizacion());
	}
	
	@Test
	final void testComprobarPenalizacionesEjemplaresAcumular() {
		assertNotNull(ee.getPrestamo());
		assertTrue(LocalDate.now().isAfter(ee.getPrestamo().getFechaFin().plusMonths(3)));
		Usuario usr = ee.getPrestamo().getUser();
		usr.setFechaFinPenalizacion(LocalDate.parse("2024-01-07"));
		assertFalse(usr.getFechaFinPenalizacion()==null || usr.getFechaFinPenalizacion().isBefore(LocalDate.now()));
		LocalDate orig = usr.getFechaFinPenalizacion();
		usr.setFechaFinPenalizacion(orig.plusYears(3));
		assertEquals(orig.plusYears(3),usr.getFechaFinPenalizacion());
	}

	@Test
	final void testAltaPrestamo() {
		assertNotNull(ejemplarDAO.findAll());
		assertNotNull(usuarioDAO.findAll());
        String result = prController.altaPrestamo(model);
        assertEquals("prestamoreserva/NuevoPrestamo",result);
	}

	@Test
	final void testPrestamoSubmitUsuarioPenalizado() {
		pp.getUser().setFechaFinPenalizacion(LocalDate.parse("2024-01-07"));
		assertTrue(pp.getUser().getFechaFinPenalizacion() != null && pp.getUser().getFechaFinPenalizacion().isAfter(LocalDate.now()));
	}
	
	@Test
	final void testPrestamoSubmitSinReserva() {
		assertFalse(pp.getUser().getFechaFinPenalizacion() != null && pp.getUser().getFechaFinPenalizacion().isAfter(LocalDate.now()));
		Prestamo guardado = prestamoDAO.save(pp);
		assertNotNull(guardado);
		assertEquals(pp, guardado);
	}
	
	@Test
	final void testPrestamoSubmitConReservaMismoUsrNoPenalty() {
		rr = new Reserva();
		rr.setUser(pp.getUser());
		rr.setFechaReserva(null);
		rr.setEjem(ee);
		ee.setReserva(rr);
		Reserva guardada = reservaDAO.save(rr);
		assertFalse(pp.getUser().getFechaFinPenalizacion() != null && pp.getUser().getFechaFinPenalizacion().isAfter(LocalDate.now()));
		assertTrue(pp.getEjem().getReserva().getUser().getNombre()==pp.getUser().getNombre()&&pp.getEjem().getReserva().getUser().getApellidos()==pp.getUser().getApellidos());
		reservaDAO.delete(rr);
		Prestamo guardado = prestamoDAO.save(pp);
		assertNotNull(guardado);
		assertEquals(pp, guardado);
	}
	
	@Test
	final void testPrestamoSubmitConReservaDistintoUsr() {
		Usuario nu = new Usuario();
		nu.setNombre("Dimitri");
		nu.setApellidos("Vegas");
		rr = new Reserva();
		rr.setUser(nu);
		rr.setFechaReserva(LocalDate.parse("2023-12-29"));
		rr.setEjem(ee);
		ee.setReserva(rr);
		Reserva guardada = reservaDAO.save(rr);
		assertFalse(pp.getUser().getFechaFinPenalizacion() != null && pp.getUser().getFechaFinPenalizacion().isAfter(LocalDate.now()));
		assertFalse(pp.getEjem().getReserva().getUser().getNombre()==pp.getUser().getNombre()&&pp.getEjem().getReserva().getUser().getApellidos()==pp.getUser().getApellidos());
		assertTrue(pp.getEjem().getReserva().getFechaReserva()!=null && pp.getEjem().getReserva().getFechaReserva().isAfter(LocalDate.now()));
	}

	@Test
	final void testAltaReserva() {
		assertNotNull(ejemplarDAO.findAll());
		String result = prController.altaReserva(model);
		assertEquals("prestamoreserva/NuevaReserva",result);
	}

	@Test
	final void testReservaSubmit() {
		rr.setFechaReserva(LocalDate.now().plusDays(5));
		assertFalse(rr.getUser().getFechaFinPenalizacion() == null && !rr.getUser().getFechaFinPenalizacion().isAfter(LocalDate.now()));
		Reserva guardada = reservaDAO.save(rr);
		assertEquals(guardada,rr);
	}

	@Test
	final void testDevolverPrestamoSinPenalty() {
		when(prestamoDAO.findById(pp.getIdPrestamo())).thenReturn(java.util.Optional.ofNullable(pp));
		Optional<Prestamo> prestamo = prestamoDAO.findById(pp.getIdPrestamo());
		assertFalse(prestamo.isEmpty());
		LocalDate FechaDevuelto = LocalDate.now();
		Prestamo devuelto = prestamo.get();
		devuelto.setFechaFin(FechaDevuelto.plusDays(1)); //!!
		Usuario usuario = devuelto.getUser();
		assertFalse(FechaDevuelto.isAfter(devuelto.getFechaFin()));
		prestamoDAO.deleteById(pp.getIdPrestamo());
		
	}
	
	@Test
	final void testDevolverPrestamoPenalty() {
		when(prestamoDAO.findById(pp.getIdPrestamo())).thenReturn(java.util.Optional.ofNullable(pp));
		Optional<Prestamo> prestamo = prestamoDAO.findById(pp.getIdPrestamo());
		assertFalse(prestamo.isEmpty());
		LocalDate FechaDevuelto = LocalDate.now();
		Prestamo devuelto = prestamo.get();
		Usuario usuario = devuelto.getUser();
		assertTrue(FechaDevuelto.isAfter(devuelto.getFechaFin()));
		assertTrue(usuario.getFechaFinPenalizacion()==null || usuario.getFechaFinPenalizacion().isBefore(LocalDate.now()));
		usuario.setFechaFinPenalizacion(FechaDevuelto.plusDays(3*ChronoUnit.DAYS.between(devuelto.getFechaFin(), FechaDevuelto)));
		Usuario modificado = usuarioDAO.save(usuario);
		prestamoDAO.deleteById(pp.getIdPrestamo());
	}
	
	@Test
	final void testDevolverPrestamoPenaltyAcumulativo() {
		when(prestamoDAO.findById(pp.getIdPrestamo())).thenReturn(java.util.Optional.ofNullable(pp));
		Optional<Prestamo> prestamo = prestamoDAO.findById(pp.getIdPrestamo());
		assertFalse(prestamo.isEmpty());
		LocalDate FechaDevuelto = LocalDate.now();
		Prestamo devuelto = prestamo.get();
		Usuario usuario = devuelto.getUser();
		// para aplicar una acumulación de penalización, debe de existir antes:
		usuario.setFechaFinPenalizacion(FechaDevuelto.plusDays(6));
		assertTrue(FechaDevuelto.isAfter(devuelto.getFechaFin()));
		assertFalse(usuario.getFechaFinPenalizacion()==null || usuario.getFechaFinPenalizacion().isBefore(LocalDate.now()));	
		assertTrue(usuario.getFechaFinPenalizacion().isAfter(LocalDate.now()));
		usuario.setFechaFinPenalizacion(usuario.getFechaFinPenalizacion().plusDays(3*ChronoUnit.DAYS.between(devuelto.getFechaFin(), FechaDevuelto)));
		Usuario modificado = usuarioDAO.save(usuario);
		prestamoDAO.deleteById(pp.getIdPrestamo());
	}
	@Test
	final void testCancelarReserva() {
		when(reservaDAO.findById(rr.getIdReserva())).thenReturn(java.util.Optional.ofNullable(rr));
		Optional<Reserva> reservaopcional = reservaDAO.findById(rr.getIdReserva());
		assertFalse(reservaopcional.isEmpty());
		Reserva reserva = reservaopcional.get();
		Usuario usuario = reserva.getUser();
		assertTrue(usuario.getFechaFinPenalizacion()==null || usuario.getFechaFinPenalizacion().isBefore(LocalDate.now()));
		usuario.setFechaFinPenalizacion(LocalDate.now().plusWeeks(1));
		Usuario guardado = usuarioDAO.save(usuario);
		reservaDAO.deleteById(rr.getIdReserva());
	}
	
	@Test
	final void testCancelarReservaAcumulado() {
		when(reservaDAO.findById(rr.getIdReserva())).thenReturn(java.util.Optional.ofNullable(rr));
		Optional<Reserva> reservaopcional = reservaDAO.findById(rr.getIdReserva());
		assertFalse(reservaopcional.isEmpty());
		Reserva reserva = reservaopcional.get();
		Usuario usuario = reserva.getUser();
		usuario.setFechaFinPenalizacion(LocalDate.parse("2024-01-01"));
		assertFalse(usuario.getFechaFinPenalizacion()==null || usuario.getFechaFinPenalizacion().isBefore(LocalDate.now()));
		assertTrue(usuario.getFechaFinPenalizacion().isAfter(LocalDate.now()));
		usuario.setFechaFinPenalizacion(usuario.getFechaFinPenalizacion().plusWeeks(1));
		Usuario guardado = usuarioDAO.save(usuario);
		reservaDAO.deleteById(rr.getIdReserva());
	}
}