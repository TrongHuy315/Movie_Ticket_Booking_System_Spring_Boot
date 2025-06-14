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
public class SeatRequest {
    @NotBlank
    private Integer x;

    @NotBlank
    private Integer y;

    private Boolean isEmpty;

    private Boolean isChildren;

    @NotBlank
    private Integer room_id;

    private Integer user_id;
}
