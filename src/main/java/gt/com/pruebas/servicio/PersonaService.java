package gt.com.pruebas.servicio;

import gt.com.pruebas.domain.Persona;
import java.util.List;

/**
 *
 * @author Erick E. Osoy
 */
public interface PersonaService {
    
    public List<Persona> listarPersonas();
    
    public void guardarPersona(Persona persona);
    
    public void eliminarPersona(Persona persona);
    
    public Persona encontrarPersona(Persona persona);
}
