package cinema.system.demo.dto.request;

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
public class ShowRequest {
    private LocalDate date;

    private LocalTime beginTime;

    private LocalTime endTime;

    private Integer room_id;

    private Integer movie_id;
}
