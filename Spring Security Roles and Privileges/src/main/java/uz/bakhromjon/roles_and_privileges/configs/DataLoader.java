package uz.bakhromjon.roles_and_privileges.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.bakhromjon.roles_and_privileges.entities.Privilege;
import uz.bakhromjon.roles_and_privileges.entities.Role;
import uz.bakhromjon.roles_and_privileges.entities.User;
import uz.bakhromjon.roles_and_privileges.enums.EPrivilege;
import uz.bakhromjon.roles_and_privileges.enums.ERole;
import uz.bakhromjon.roles_and_privileges.repositories.UserRepository;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(1L, "xbakhromjon@gmail.com", encoder.encode("123"),
                List.of(new Role(1L, ERole.USER, List.of(new Privilege(1L, EPrivilege.READ)))));

        User user2 = new User(2L, "xbakhromjon1@gmail.com", encoder.encode("123"),
                List.of(new Role(2L, ERole.USER, List.of(new Privilege(2L, EPrivilege.READ), new Privilege(3L, EPrivilege.WRITE)))));
        userRepository.saveAll(List.of(user1, user2));
    }
}
