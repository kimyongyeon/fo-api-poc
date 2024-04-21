package inm.od.biz.api;

//import com.kyy.cu.common.dto.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "OrderApi", url = "http://localhost:8080")
public interface OrderApi {
//    @GetMapping("getOrder")
//    CommonResponse<OrderResponseDto> getOrder();
//
//    @GetMapping("getOrderList")
//    CommonResponse<OrderResponseDto> getOrderList();
}
