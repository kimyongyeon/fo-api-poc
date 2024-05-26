package inm.or.common.validation;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @Null(message = "{Null.message}")
    @FieldName("널 필드")
    private String name;



    // Getters and Setters
    // ...
}


