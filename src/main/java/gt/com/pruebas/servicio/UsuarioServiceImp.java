package gt.com.pruebas.servicio;

import gt.com.pruebas.dao.IUsuarioDAO;
import gt.com.pruebas.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Erick E. Osoy
 */

@Service
public class UsuarioServiceImp implements UsuarioServiceInterface{

    @Autowired
    private IUsuarioDAO usuarioDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioDAO.findAll();
    }

    @Override
    @Transactional
    public void guardarUsuario(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    @Override
    @Transactional
    public void eliminarUsuario(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }

    @Override
    @Transactional
    public Usuario encontrarUsuario(Usuario usuario) {
        return usuarioDAO.findById(usuario.getIdUsuario()).orElse(null);
    }
    
}
