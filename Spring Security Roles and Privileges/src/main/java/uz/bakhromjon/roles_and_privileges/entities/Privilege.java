package uz.bakhromjon.roles_and_privileges.entities;

import jakarta.persistence.*;
import uz.bakhromjon.roles_and_privileges.enums.EPrivilege;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EPrivilege name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

    public Privilege(Long id, EPrivilege name) {
        this.id = id;
        this.name = name;
    }
}

