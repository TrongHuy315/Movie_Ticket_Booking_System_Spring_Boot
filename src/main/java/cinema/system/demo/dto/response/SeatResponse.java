package cinema.system.demo.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatResponse {
    @NotBlank
    private Integer x;

    @NotBlank
    private Integer y;

    private Boolean isEmpty;

    private Boolean isChildren;
}
