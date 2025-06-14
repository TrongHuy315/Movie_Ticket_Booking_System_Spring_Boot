package cinema.system.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cinema.system.demo.dto.request.UserRequest;
import cinema.system.demo.dto.response.UserResponse;
import cinema.system.demo.model.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "cccd", target = "profile.cccd")
    User toModel(final UserRequest userRequest);

    @Mapping(source = "profile.cccd", target = "cccd")
    UserResponse toDto(final User user);
}
