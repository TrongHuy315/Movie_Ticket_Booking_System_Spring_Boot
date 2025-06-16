package cinema.system.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import cinema.system.demo.dto.request.UserRequest;
import cinema.system.demo.dto.response.UserResponse;
import cinema.system.demo.model.User;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class, SeatMapper.class})
public interface UserMapper {
    @Mapping(source = "cccd", target = "profile.cccd")
    User toModel(final UserRequest userRequest);

    UserResponse toDto(final User user);
}
