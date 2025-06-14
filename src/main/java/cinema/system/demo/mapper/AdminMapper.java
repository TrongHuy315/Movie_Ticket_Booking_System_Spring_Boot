package cinema.system.demo.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cinema.system.demo.dto.request.AdminRequest;
import cinema.system.demo.dto.response.AdminResponse;
import cinema.system.demo.model.Admin;

public interface AdminMapper {
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    @Mapping(source = "bank.name", target = "bank_name")
    @Mapping(source = "bank.stk", target = "stk")
    AdminResponse toDto(final Admin admin);

    Admin toModel(final AdminRequest adminRequest);
}
