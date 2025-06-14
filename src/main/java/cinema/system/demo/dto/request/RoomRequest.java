package cinema.system.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequest {
    @NotBlank
    private String name;

    private Integer row;

    private Integer column;

    @NotBlank
    private Integer theater_id;
}
