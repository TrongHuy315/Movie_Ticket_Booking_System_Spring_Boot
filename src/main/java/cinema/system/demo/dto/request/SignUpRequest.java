package cinema.system.demo.dto.request;

import lombok.Data;

@Data
public class SignUpRequest {
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private Integer age;
}
