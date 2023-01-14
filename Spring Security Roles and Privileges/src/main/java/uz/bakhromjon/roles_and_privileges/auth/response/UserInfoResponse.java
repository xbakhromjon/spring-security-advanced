package uz.bakhromjon.roles_and_privileges.auth.response;

import uz.bakhromjon.roles_and_privileges.entities.Role;

import java.util.Collection;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class UserInfoResponse {
    private Long id;
    private String username;
    private String email;
    private Collection<Role> roles;

    public UserInfoResponse(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }


}
