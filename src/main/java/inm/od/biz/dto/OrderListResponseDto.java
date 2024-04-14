package inm.od.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class OrderListResponseDto {
    List<OrderResponseDto> orderList;
}
