package uz.bakhromjon.roles_and_privileges.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.roles_and_privileges.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // TODO: 14.01.2023 u.roles.privileges ga join fetch qilish
    @Query("select u from User u JOIN FETCH u.roles where u.email = :email")
    Optional<User> findByEmail(String email);
}
