package cinema.system.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheaterRequest {
    private String name;

    private String address;

    private Integer room_id;

    private Integer admin_id;

    private Integer bonus_id;
}
