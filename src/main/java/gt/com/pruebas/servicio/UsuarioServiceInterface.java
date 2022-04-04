package gt.com.pruebas.servicio;

import gt.com.pruebas.domain.Usuario;
import java.util.List;

/**
 *
 * @author Erick E. Osoy
 */
public interface UsuarioServiceInterface {
    
    public List<Usuario> listarUsuarios();
    
    public void guardarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
    
    public Usuario encontrarUsuario(Usuario usuario);
    
}
