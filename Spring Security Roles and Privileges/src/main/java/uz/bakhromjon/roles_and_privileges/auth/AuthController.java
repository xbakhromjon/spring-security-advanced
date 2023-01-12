package uz.bakhromjon.roles_and_privileges.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bakhromjon.roles_and_privileges.auth.dto.LoginDTO;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 31/10/22, Mon, 21:54
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO loginRequest) throws BadCredentialsException {
        return service.authenticateUser(loginRequest);
    }


}





