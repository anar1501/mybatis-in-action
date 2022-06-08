package az.cybernet.mapper;

import az.cybernet.data.dto.response.UserResponseDto;
import az.cybernet.data.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityToDto {
    EntityToDto INSTANCE = Mappers.getMapper(EntityToDto.class);
//    @Mapping(target = "id", ignore = true)
    UserResponseDto toDto(User entity);
}
