package az.cybernet.service.impl;

import az.cybernet.data.dto.request.UserRequestDto;
import az.cybernet.data.dto.response.UserResponseDto;
import az.cybernet.data.entity.User;
import az.cybernet.exception.UserNotFoundException;
import az.cybernet.mapper.DtoToEntity;
import az.cybernet.mapper.UserMapper;
import az.cybernet.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static az.cybernet.mapper.EntityToDto.INSTANCE;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Transactional
    @Override
    public List<UserResponseDto> findAll() {
        return userMapper.findAll().stream().map(INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(UserRequestDto requestDto) {
        userMapper.insert(DtoToEntity.INSTANCE.toEntity(requestDto));
    }

    @SneakyThrows
    @Override
    public void update(Long id, UserRequestDto requestDto) {
        User userById = userMapper.selectById(id).orElseThrow(UserNotFoundException::new);
        userById.setId(id);
        userById.setName(requestDto.getName());
        userById.setSalary(requestDto.getSalary());
        userMapper.update(userById);
    }

    @Override
    public void delete(Long id) {
        User user = userMapper.selectById(id).orElseThrow(UserNotFoundException::new);
        userMapper.delete(user);
    }

}
