package uz.bakhromjon.roles_and_privileges.enums;

import org.springframework.security.core.GrantedAuthority;

public enum EPrivilege implements GrantedAuthority {
    WRITE_USER,
    WRITE_MODERATOR,
    READ;


    @Override
    public String getAuthority() {
        return name();
    }
}

