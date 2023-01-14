package uz.bakhromjon.roles_and_privileges.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.valueToTree(new Test(1, "str"));
        ((ObjectNode) node).put("label", "2007");
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Test {
        private Integer p1;
        private String p2;
    }
}
