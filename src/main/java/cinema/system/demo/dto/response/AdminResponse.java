package cinema.system.demo.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponse {
    private String groupName;

    private String email;

    private String phone;

    private String password;

    private Float priceForChildren;

    private TheaterResponse theater;

    private String bank_name;

    private String stk;

    private List<BonusResponse> bonus;
}
