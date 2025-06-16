package cinema.system.demo.mapper;

import org.mapstruct.Mapper;

import cinema.system.demo.dto.response.SeatResponse;
import cinema.system.demo.model.Seat;

@Mapper(componentModel = "spring")
public interface SeatMapper {
    SeatResponse toDto(final Seat seat);
}
