package gt.com.pruebas.web;

import gt.com.pruebas.domain.Persona;
import gt.com.pruebas.servicio.PersonaService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 
 * @author Erick E. Osoy
 */
@Controller
public class ControladorInicio {
    
    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        List<Persona> personas =  personaService.listarPersonas();
        model.addAttribute("personas", personas);
        
        Double saldoTotal = 0D;
        for(Persona p: personas){
            saldoTotal += p.getSaldo();
        }
        
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        
        
        return "index";
    }
    
    @GetMapping("/agregarPersona")
    public String agregarPersona(Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardarPersona(@Valid Persona persona, Errors errores){
        
        //preguntamos si en el formulario modificar hemos detectado errores
        if(errores.hasErrors()){
            return "modificar";
        }
        // sino se reciben errores procedemos a guardar 
        personaService.guardarPersona(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editarPersona/{idPersona}")
    public String editarPersona(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminarPersona/{idPersona}")
    public String eliminarPersona(Persona persona){
        personaService.eliminarPersona(persona);
        return "redirect:/";
    }

}
