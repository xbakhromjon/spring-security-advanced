package uz.bakhromjon.roles_and_privileges.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bakhromjon.roles_and_privileges.annotations.CheckAuthority;
import uz.bakhromjon.roles_and_privileges.enums.EPrivilege;
import uz.bakhromjon.roles_and_privileges.enums.ERole;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/anonymous")
    public ResponseEntity<?> anonymous() {
        return ResponseEntity.ok("Anonymous");
    }


    @CheckAuthority(roles = ERole.USER, privileges = {})
    @GetMapping("/user")
    public ResponseEntity<?> user() {
        return ResponseEntity.ok("User");
    }

    @CheckAuthority(roles = ERole.MODERATOR, privileges = {EPrivilege.WRITE_MODERATOR})
    @GetMapping("/moderator")
    public ResponseEntity<?> moderator() {
        return ResponseEntity.ok("Moderator");
    }

}
