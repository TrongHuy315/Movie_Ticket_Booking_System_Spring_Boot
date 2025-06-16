package cinema.system.demo.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class UserResponse {
    private String fullName;

    private Integer age;

    private String phone;

    private String email;

    private ProfileResponse profile;

    private List<SeatResponse> seat;
}
