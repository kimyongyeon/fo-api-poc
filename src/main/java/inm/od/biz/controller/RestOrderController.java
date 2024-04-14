package inm.od.biz.controller;

//import com.kyy.cu.common.ComLogger;
import com.kyy.cu.common.ComLogger;
import inm.od.biz.api.OrderApi;
import inm.od.biz.dto.OrderListResponseDto;
import inm.od.biz.dto.OrderResponseDto;
import inm.od.biz.service.OrderInnerService;
import inm.od.biz.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestOrderController {

    private final ComLogger comLogger;
    private final OrderService orderService;
    private final OrderInnerService orderInnerService;
    private final OrderApi orderApi;

    @GetMapping("tran")
    public OrderListResponseDto tran() {
        return orderInnerService.tran();
    }

    @GetMapping("/getOrder")
    public OrderResponseDto getOrder() {
        comLogger.error("getOrder Error!");
        OrderResponseDto orderResponseDto = new OrderResponseDto(1, "GetOrder Success!");
        return orderResponseDto;
    }

    @GetMapping("/getOrderList")
    public OrderResponseDto getOrderList() {
        comLogger.error("getOrderList Error!");
        OrderResponseDto orderResponseDto = new OrderResponseDto(1, "GetOrderList Success!");
        return orderResponseDto;
    }

    @GetMapping("/order")
    public OrderListResponseDto order() {
        return OrderListResponseDto.builder()
                .orderList(List.of(orderApi.getOrder().getData(), orderApi.getOrderList().getData()))
                .build();
    }
}
