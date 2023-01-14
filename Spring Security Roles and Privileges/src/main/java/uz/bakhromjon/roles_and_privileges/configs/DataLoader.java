package uz.bakhromjon.roles_and_privileges.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.bakhromjon.roles_and_privileges.entities.Role;
import uz.bakhromjon.roles_and_privileges.entities.User;
import uz.bakhromjon.roles_and_privileges.enums.EPrivilege;
import uz.bakhromjon.roles_and_privileges.enums.ERole;
import uz.bakhromjon.roles_and_privileges.repositories.UserRepository;

import java.util.List;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void run(String... args) {
        User user1 = new User(1L, "xbakhromjon@gmail.com", encoder.encode("123"),
                List.of(new Role(1L, ERole.USER, Set.of(EPrivilege.WRITE_USER))));

        User user2 = new User(2L, "xbakhromjon1@gmail.com", encoder.encode("123"),
                List.of(new Role(2L, ERole.USER, Set.of(EPrivilege.WRITE_MODERATOR))));
        /*EPrivilege.READ, EPrivilege.WRITE)*/
        userRepository.saveAll(List.of(user1, user2));
    }
}
