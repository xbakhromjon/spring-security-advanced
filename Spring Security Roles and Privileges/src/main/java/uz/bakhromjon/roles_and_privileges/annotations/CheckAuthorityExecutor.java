package uz.bakhromjon.roles_and_privileges.annotations;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uz.bakhromjon.roles_and_privileges.auth.roleDetails.RoleDetails;
import uz.bakhromjon.roles_and_privileges.auth.userDetails.UserDetailsImpl;
import uz.bakhromjon.roles_and_privileges.enums.AccessDeniedException;
import uz.bakhromjon.roles_and_privileges.enums.EPrivilege;
import uz.bakhromjon.roles_and_privileges.enums.ERole;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Aspect
public class CheckAuthorityExecutor {
    @Before(value = "@annotation(checkAuthority)")
    public void checkAuthority(CheckAuthority checkAuthority) throws AccessDeniedException {
        // TODO: 14.01.2023 Anonymous User
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetailsImpl session = (UserDetailsImpl) principal;
        List<RoleDetails> roleDetails = session.getRoles();
        Set<ERole> sessionRoles = roleDetails.stream().map(RoleDetails::getName).collect(Collectors.toSet());
        Set<EPrivilege> sessionPrivileges = RoleDetails.getAllPrivileges(roleDetails);

        Set<ERole> accessedRoles = Set.of(checkAuthority.roles());
        Set<EPrivilege> accessedPrivileges = Set.of(checkAuthority.privileges());

        boolean access = false;
        if (checkRoles(sessionRoles, accessedRoles)) {
            access = true;
        } else {
            access = checkPrivileges(sessionPrivileges, accessedPrivileges);
        }

        if (!access) {
            AccessDeniedException.throwException("ACCESS_DENIED", null);
        }
    }

    private boolean checkRoles(Set<ERole> sessionRoles, Set<ERole> accessedRoles) {
        for (ERole currentRole : sessionRoles) {
            if (accessedRoles.contains(currentRole)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPrivileges(Set<EPrivilege> sessionPrivileges, Set<EPrivilege> accessedPrivileges) {
        for (EPrivilege currentPrivileges : sessionPrivileges) {
            if (accessedPrivileges.contains(currentPrivileges)) {
                return true;
            }
        }
        return false;
    }
}
