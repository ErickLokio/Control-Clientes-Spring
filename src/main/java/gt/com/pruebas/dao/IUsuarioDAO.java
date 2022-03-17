package gt.com.pruebas.dao;

import gt.com.pruebas.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Erick E. Osoy
 */
public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{
    Usuario findByUsername(String username);
}
