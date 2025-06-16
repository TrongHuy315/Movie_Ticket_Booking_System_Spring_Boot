package cinema.system.demo.dto.response;

import java.util.List;

import lombok.Data;
@Data
public class AdminResponse {
    private String groupName;

    private String email;

    private String phone;

    private String password;

    private Float priceForChildren;
}
