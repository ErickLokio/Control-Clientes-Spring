package gt.com.pruebas.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Erick E. Osoy
 */
public class EncriptarPassword {
    public static void main(String[] args){
        
        String password = "luisa22";
        System.out.println("PASSWORD ORIGINA :" +password);
        System.out.println("PASSWORD ENCRIPTADA :" +encriptarPassword(password));
    }
    
    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
