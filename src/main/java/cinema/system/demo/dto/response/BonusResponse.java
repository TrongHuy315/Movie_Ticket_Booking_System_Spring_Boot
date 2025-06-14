package cinema.system.demo.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BonusResponse {
    private LocalDate date;

    private LocalTime beginTime;

    private LocalTime endTime;

    private Float percent;
}
