package Lorem_Software.Library_Maintenance_System.business.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Lorem_Software.Library_Maintenance_System.business.entity.Usuario;
import Lorem_Software.Library_Maintenance_System.persistance.UsuarioDAO;

class UsuarioControllerTest {
	
	@Autowired
	private static UsuarioController usuarioController;
	@Autowired
	private static UsuarioDAO usuarioDAO = mock(UsuarioDAO.class);
	private static Model model;
	private static Usuario ss;

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		usuarioController = new UsuarioController();
	}

	@AfterAll
	protected static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	protected void setUp() throws Exception {
		ss = new Usuario();
		ss.setNombre("Paco");
		ss.setApellidos("González");
		ss.setIdUsuario((long) 19999);
		
		model = mock(Model.class);
		usuarioController.setUsuarioDAO(usuarioDAO);
		when(usuarioDAO.save(ss)).thenAnswer(i -> i.getArguments()[0]);
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}

	@Test
	final void testAltaUsuario() {
		String result = usuarioController.altaUsuario(model);
		assertNotNull(result);
		assertEquals("usuario/AltaUsuario", result);
	}

	@Test
	final void testUsuarioSubmit() {
		Usuario guardado = usuarioDAO.save(ss);
		assertNotNull(guardado);
		assertTrue(guardado.getIdUsuario() > 0);
		assertEquals(ss, guardado);
	}

	@Test
	final void testFormularioEditarUsuario() {
		when(usuarioDAO.findById(ss.getIdUsuario())).thenReturn(java.util.Optional.ofNullable(ss));
		
		Usuario guardado = usuarioDAO.save(ss);
		assertNotNull(guardado);
//		System.out.println("["+guardado.getIdUsuario()+"] "+guardado.getNombre()+" "+guardado.getApellidos());
		
		Optional <Usuario> usuario = usuarioDAO.findById(guardado.getIdUsuario());
		assertFalse(usuario.isEmpty());
		assertEquals(ss, usuario.get());
		
		String result = usuarioController.formularioEditarUsuario((long) ss.getIdUsuario(), model);
		assertEquals("usuario/AltaUsuario", result);
	}

	@Test
	final void testActualizarUsuario() {
		when(usuarioDAO.findById(ss.getIdUsuario())).thenReturn(java.util.Optional.ofNullable(ss));
		
		Usuario guardado = usuarioDAO.save(ss);
		assertNotNull(guardado);
//		System.out.println("["+guardado.getIdUsuario()+"] "+guardado.getNombre()+" "+guardado.getApellidos());
		
		Optional <Usuario> usuario = usuarioDAO.findById(guardado.getIdUsuario());
		assertFalse(usuario.isEmpty());
		Usuario sb = usuario.get();
		
		sb.setNombre("Carmen");
		sb.setApellidos("Jordá");
		sb.setIdUsuario((long) 121313);
		
		Usuario guardado2 = usuarioDAO.save(sb);
		assertEquals(ss.getIdUsuario(),guardado2.getIdUsuario());
		assertEquals(sb, guardado2);
//		System.out.println("["+guardado2.getIdUsuario()+"] "+guardado2.getNombre()+" "+guardado2.getApellidos());
	}

	@Test
	final void testDeleteUsuario() {
		when(usuarioDAO.findById(ss.getIdUsuario())).thenReturn(java.util.Optional.ofNullable(ss));
		Usuario guardado = usuarioDAO.save(ss);
		assertNotNull(guardado);
		usuarioDAO.deleteById((long) guardado.getIdUsuario());
		// no devuelve nada, con verificar que se ha ejecutado nos servirá
		verify(usuarioDAO, times(1)).deleteById((long) guardado.getIdUsuario());
	}

}