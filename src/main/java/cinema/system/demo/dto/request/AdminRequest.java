package cinema.system.demo.dto.request;

import lombok.Data;

@Data
public class AdminRequest {
    private String groupName;

    private String email;

    private String phone;

    private String password;

    private Float priceForChildren;
}
