package uz.bakhromjon.roles_and_privileges.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.roles_and_privileges.enums.EPrivilege;
import uz.bakhromjon.roles_and_privileges.enums.ERole;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole name;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ElementCollection(targetClass = EPrivilege.class)
    @CollectionTable(name = "role_permission", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "permissions", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<EPrivilege> privileges;


    public Role(Long id, ERole name, Set<EPrivilege> privileges) {
        this.id = id;
        this.name = name;
        this.privileges = privileges;
    }
}

