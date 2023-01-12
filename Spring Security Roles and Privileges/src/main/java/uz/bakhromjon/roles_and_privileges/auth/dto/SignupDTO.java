package uz.bakhromjon.roles_and_privileges.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 31/10/22, Mon, 21:58
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignupDTO {
    private String phone;
    private String name;
}
