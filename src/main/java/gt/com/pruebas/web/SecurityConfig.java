package gt.com.pruebas.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 *
 * @author Erick E. Osoy
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserDetailsService useDetailsService;
    
    @Bean
    public BCryptPasswordEncoder passowordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    
    public void Configuration(AuthenticationManagerBuilder build) throws Exception{
        build.userDetailsService(useDetailsService).passwordEncoder(passowordEncoder());
    }

    
    
    // AUTORIZACION DE USUARIOS
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
            .antMatchers("/editarPersona/**", "/agregarPersona/**", "/eliminarPersona")
                .hasRole("ADMIN")
            .antMatchers("/")
                .hasAnyRole("ADMIN", "USER")  
            .and()
                .formLogin()
                .loginPage("/login")
            // redireccionamos a la pagina de error    
            .and()
                .exceptionHandling().accessDeniedPage("/errores/403")
        ;
    }
    
}
