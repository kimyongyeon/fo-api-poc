package inm.od.biz.api;

import com.kyy.cu.common.dto.CommonResponse;
import inm.od.biz.dto.OrderResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "OrderApi", url = "http://localhost:8080")
public interface OrderApi {
    @GetMapping("getOrder")
    CommonResponse<OrderResponseDto> getOrder();

    @GetMapping("getOrderList")
    CommonResponse<OrderResponseDto> getOrderList();
}
