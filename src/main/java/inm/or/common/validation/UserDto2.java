package inm.or.common.validation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto2 {

    @Null(message = "{Null.message}")
    @FieldName("널 필드")
    private String name;

    @NotNull(message = "{NotNull.message}")
    @FieldName("전화번호")
    private String phone;

    @Size(min = 1, max = 10, message = "{Size.message}")
    @FieldName("주소")
    private String address;



    // Getters and Setters
    // ...
}


