package Lorem_Software.Library_Maintenance_System.business.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Lorem_Software.Library_Maintenance_System.business.entity.Prestamo;
import Lorem_Software.Library_Maintenance_System.business.entity.Reserva;
import Lorem_Software.Library_Maintenance_System.business.entity.Usuario;
import Lorem_Software.Library_Maintenance_System.persistance.PrestamoDAO;
import Lorem_Software.Library_Maintenance_System.persistance.ReservaDAO;
import Lorem_Software.Library_Maintenance_System.persistance.UsuarioDAO;
import jakarta.persistence.PreRemove;

@Controller
public class UsuarioController {
    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private PrestamoDAO prestamoDAO;

    @Autowired
    private ReservaDAO reservaDAO;

    Usuario usuario;

    public UsuarioController() {
        super();
        this.usuario = new Usuario();
    }

    @GetMapping("/AltaUsuario")
    public String altaUsuario(Model model) {
        List<Usuario> listadoUsuarios = usuarioDAO.findAll();
        Collections.sort(listadoUsuarios, new UsuarioComparator());

        model.addAttribute("usuarioHeader", "Listado de Usuarios");
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("listaUsuarios", listadoUsuarios);

        log.info(usuarioDAO.findAll().toString());
        return "usuario/AltaUsuario";
    }

    @PostMapping("/AltaUsuario")
    public String usuarioSubmit(@ModelAttribute Usuario usuario, Model model) {
        this.usuario = usuario;
        model.addAttribute("usuario", usuario);
        usuarioDAO.save(this.usuario);
        return "redirect:/AltaUsuario";
    }

    @GetMapping("/AltaUsuario/edit/{IdUsuario}")
    public String formularioEditarUsuario(@PathVariable("IdUsuario") long idUsuario, Model model) {
        Optional<Usuario> usuarioEditar = usuarioDAO.findById(idUsuario);
        model.addAttribute("usuario", usuarioEditar);
        return "usuario/AltaUsuario";
    }

    @PostMapping("/AltaUsuario/update/{IdUsuario}")
    public String actualizarUsuario(@PathVariable("IdUsuario") long idUsuario, Usuario usuario) {
        usuarioDAO.save(usuario);
        return "redirect:/AltaUsuario";
    }

    @GetMapping("/AltaUsuario/delete/{IdUsuario}")
    public String deleteUsuario(@PathVariable("IdUsuario") long id) {

        suprimirAsociacionesPrestamo(usuarioDAO.findById(id));
        suprimirAsociacionesReserva(usuarioDAO.findById(id));
        usuarioDAO.deleteById(id);
        return "redirect:/AltaUsuario";
    }

    @PreRemove
    private void suprimirAsociacionesPrestamo(Optional<Usuario> us) {
        if(!us.isEmpty()){
            Usuario u = us.get();
            for (Prestamo p : u.getPrestamos()) {
                prestamoDAO.deleteById(p.getIdPrestamo());
            }
        }
    }

    @PreRemove
    private void suprimirAsociacionesReserva(Optional<Usuario> us) {
        if(!us.isEmpty()){
            Usuario u = us.get();
            for (Reserva r : u.getReservas()) {
                reservaDAO.deleteById(r.getIdReserva());
            }
        }
    }

    class UsuarioComparator implements java.util.Comparator<Usuario> {
        @Override
        public int compare(Usuario a, Usuario b) {
            return a.getNombre().compareTo(b.getNombre());
        }
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public PrestamoDAO getPrestamoDAO() {
        return prestamoDAO;
    }

    public void setPrestamoDAO(PrestamoDAO prestamoDAO) {
        this.prestamoDAO = prestamoDAO;
    }

    public ReservaDAO getReservaDAO() {
        return reservaDAO;
    }

    public void setReservaDAO(ReservaDAO reservaDAO) {
        this.reservaDAO = reservaDAO;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}