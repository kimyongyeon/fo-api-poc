package inm.od.biz.controller;

//import com.kyy.cu.common.ComLogger;
//import com.kyy.cu.common.ComLogger;
import inm.od.biz.api.OrderApi;
import inm.od.biz.dto.OrderResDto;
import inm.od.biz.service.OrderInnerService;
import inm.od.biz.service.OrderService;
import inm.od.common.sys.common.context.ApiResponseContext;
import inm.od.common.sys.common.log.ComLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestOrderController {

    private final ComLogger comLogger;
    private final OrderService orderService;
    private final OrderInnerService orderInnerService;
    private final OrderApi orderApi;

//    @GetMapping("tran")
//    public OrderListResponseDto tran() {
//        return orderInnerService.tran();
//    }

    @GetMapping("/getOrder")
    public OrderResDto getOrder() {
        comLogger.info("getOrder Success start!");
        OrderResDto orderResponseDto = new OrderResDto(1, "GetOrder Success!", "홍길동", "test@gmail.com");
        ApiResponseContext.setTransactionId(orderResponseDto);
        comLogger.info("getOrder Success end!");
        return orderResponseDto;
    }

    @GetMapping("/getOrderList")
    public OrderResDto getOrderList() {
//        comLogger.error("getOrderList Error!");
        OrderResDto orderResponseDto = new OrderResDto(1, "GetOrderList Success!", "김수지", "test2@gamil.com");
        return orderResponseDto;
    }

//    @GetMapping("/order")
//    public OrderListResponseDto order() {
//        return OrderListResponseDto.builder()
//                .orderList(List.of(orderApi.getOrder().getData(), orderApi.getOrderList().getData()))
//                .build();
//    }
}
