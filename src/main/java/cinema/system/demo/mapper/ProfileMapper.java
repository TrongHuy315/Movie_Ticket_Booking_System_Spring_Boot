package cinema.system.demo.mapper;

import org.mapstruct.Mapper;

import cinema.system.demo.dto.response.ProfileResponse;
import cinema.system.demo.model.Profile;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileResponse toDto(final Profile profile);
}
