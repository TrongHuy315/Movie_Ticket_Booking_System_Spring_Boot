package cinema.system.demo.dto.response;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SeatResponse {
    @NotBlank
    private Integer x;

    @NotBlank
    private Integer y;

    private Boolean isEmpty;

    private Boolean isChildren;
}
