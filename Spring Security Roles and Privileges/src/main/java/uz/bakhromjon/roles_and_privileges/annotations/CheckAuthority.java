package uz.bakhromjon.roles_and_privileges.annotations;

import uz.bakhromjon.roles_and_privileges.enums.EPrivilege;
import uz.bakhromjon.roles_and_privileges.enums.ERole;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckAuthority {
    EPrivilege[] privileges();
    ERole[] roles();

}
