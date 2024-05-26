package inm.or.common.validation;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/getNumber")
    public UserDto getNumber(@Valid UserDto userDto) {
        // 비즈니스 로직 처리 (예제에서는 생략)
        return userDto;
    }

    @GetMapping("/getNumber2")
    public UserDto2 getNumber2(@Valid UserDto2 userDto) {
        // 비즈니스 로직 처리 (예제에서는 생략)
        return userDto;
    }
}