package az.cybernet.controller;

import az.cybernet.data.dto.request.UserRequestDto;
import az.cybernet.data.dto.response.UserResponseDto;
import az.cybernet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public HttpStatus save(@RequestBody UserRequestDto requestDto) {
        userService.save(requestDto);
        return HttpStatus.CREATED;
    }

    @PutMapping(path = "/{id}")
    public HttpStatus update(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {
        userService.update(id, requestDto);
        return HttpStatus.OK;
    }

    @DeleteMapping(path = "/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        userService.delete(id);
        return HttpStatus.OK;
    }
}
