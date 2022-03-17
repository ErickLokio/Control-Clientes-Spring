package gt.com.pruebas.servicio;

import gt.com.pruebas.dao.IPersonaDAO;
import gt.com.pruebas.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Erick E. Osoy
 */

@Service
public class PersonaServiceImp implements PersonaService{

    @Autowired
    private IPersonaDAO personaDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDAO.findAll();
    }

    @Override
    @Transactional
    public void guardarPersona(Persona persona) {
        personaDAO.save(persona);
    }

    @Override
    @Transactional
    public void eliminarPersona(Persona persona) {
        personaDAO.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDAO.findById(persona.getIdPersona()).orElse(null);
    }
}
