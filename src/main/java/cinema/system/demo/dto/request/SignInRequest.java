package cinema.system.demo.dto.request;

import lombok.Data;

@Data
public class SignInRequest {
    private String email;
    private String password;
}
