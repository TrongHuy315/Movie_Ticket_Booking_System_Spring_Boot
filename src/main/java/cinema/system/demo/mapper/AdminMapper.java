package cinema.system.demo.mapper;

import org.mapstruct.Mapper;

import cinema.system.demo.dto.request.AdminRequest;
import cinema.system.demo.dto.response.AdminResponse;
import cinema.system.demo.model.Admin;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    AdminResponse toDto(final Admin admin);

    Admin toModel(final AdminRequest adminRequest);
}
