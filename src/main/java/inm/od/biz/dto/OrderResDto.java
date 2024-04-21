package inm.od.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OrderResDto {
    private int id;
    private String message;
    private String name;
    private String email;
}
