package cinema.system.demo.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private String fullName;

    private Integer age;

    private String email;

    private String phone;

    private String password;

    private String cccd;
}
