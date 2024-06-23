package inm.or.biz.api;

//import com.kyy.cu.common.dto.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "OrderApi", url = "http://localhost:8080")
public interface OrderApi {
//    @GetMapping("getOrder")
//    CommonResponse<OrderResponseDto> getOrder();
//
//    @GetMapping("getOrderList")
//    CommonResponse<OrderResponseDto> getOrderList();

    @GetMapping("getURLList")
    List<String> getURLList(String serverUrl);
}
