package uz.bakhromjon.roles_and_privileges.auth.userDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.bakhromjon.roles_and_privileges.auth.roleDetails.RoleDetails;
import uz.bakhromjon.roles_and_privileges.auth.userDetails.UserDetailsImpl;
import uz.bakhromjon.roles_and_privileges.entities.Role;
import uz.bakhromjon.roles_and_privileges.entities.User;
import uz.bakhromjon.roles_and_privileges.enums.EPrivilege;
import uz.bakhromjon.roles_and_privileges.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 31/10/22, Mon, 21:48
 **/
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsImpl loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
        return build(user);
    }

    public UserDetailsImpl build(User user) {

        return new UserDetailsImpl(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                RoleDetails.mapFromRole(user.getRoles()));
    }

}


