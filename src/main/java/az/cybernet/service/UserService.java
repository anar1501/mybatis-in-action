package az.cybernet.service;

import az.cybernet.data.dto.request.UserRequestDto;
import az.cybernet.data.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> findAll();

    void save(UserRequestDto requestDto);

    void update(Long id, UserRequestDto requestDto);

    void delete(Long id);
}
