package uz.bakhromjon.roles_and_privileges.enums;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.HashMap;

@AllArgsConstructor
public class AccessDeniedException extends IOException {
    private HttpStatus httpStatus;
    private Object data;


    public AccessDeniedException(String message, Object data) {
        super(message);
        this.httpStatus = HttpStatus.FORBIDDEN;
        this.data = data;
    }

    public static void throwException(String message, String key, Object keyValue) throws AccessDeniedException {
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, keyValue);
        throw new AccessDeniedException(message, map);
    }

    public static void throwException(String message, Object data) throws AccessDeniedException {
        throw new AccessDeniedException(message, data);
    }
}
