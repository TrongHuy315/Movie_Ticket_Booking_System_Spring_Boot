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
public class RoomResponse {
    private String name;

    private Integer row;

    private Integer column;

    private List<SeatResponse> seat;

    private ShowResponse show;
}
