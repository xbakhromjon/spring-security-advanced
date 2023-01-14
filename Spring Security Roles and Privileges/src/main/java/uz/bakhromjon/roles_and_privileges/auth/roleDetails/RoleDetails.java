package uz.bakhromjon.roles_and_privileges.auth.roleDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.roles_and_privileges.entities.Role;
import uz.bakhromjon.roles_and_privileges.enums.EPrivilege;
import uz.bakhromjon.roles_and_privileges.enums.ERole;

import java.util.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDetails {
    private ERole name;
    private Set<EPrivilege> privileges;

    public static List<RoleDetails> mapFromRole(List<Role> roles) {
        List<RoleDetails> roleDetails = new ArrayList<>();
        roles.forEach(role -> roleDetails.add(new RoleDetails(role.getName(), role.getPrivileges())));
        return roleDetails;
    }

    public static Set<EPrivilege> getAllPrivileges(List<RoleDetails> roleDetails) {
        Set<EPrivilege> privileges = new HashSet<>();
        roleDetails.forEach(item -> privileges.addAll(item.getPrivileges()));
        return privileges;
    }
}
