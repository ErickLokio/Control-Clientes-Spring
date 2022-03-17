package gt.com.pruebas.dao;

import gt.com.pruebas.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Erick E. Osoy
 */

public interface IPersonaDAO extends JpaRepository<Persona, Long>{
    
}
