package uz.bakhromjon.roles_and_privileges.auth.userDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.bakhromjon.roles_and_privileges.auth.roleDetails.RoleDetails;
import uz.bakhromjon.roles_and_privileges.enums.EPrivilege;

import java.util.*;


@Setter
@Getter
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails, Authentication {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String email;

    private String password;

    private List<RoleDetails> roles;

    public UserDetailsImpl(Long id, String email, String password,
                           List<RoleDetails> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<EPrivilege> privileges = new HashSet<>();
        roles.forEach(role -> privileges.addAll(role.getPrivileges()));
        return privileges;
    }

    @Override
    public Object getCredentials() {
        return password;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return email;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public String getName() {
        return null;
    }

}
