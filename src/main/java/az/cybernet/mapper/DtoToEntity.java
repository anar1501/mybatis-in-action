package az.cybernet.mapper;

import az.cybernet.data.dto.request.UserRequestDto;
import az.cybernet.data.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DtoToEntity {
    DtoToEntity INSTANCE = Mappers.getMapper(DtoToEntity.class);
    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestDto response);
}
