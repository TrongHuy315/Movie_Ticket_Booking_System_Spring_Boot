package cinema.system.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminRequest {
    private String groupName;

    private String email;

    private String phone;

    private String password;

    private Float priceForChildren;
}
