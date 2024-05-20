package inm.or.biz.controller;

import inm.or.biz.api.OrderApi;
import inm.or.biz.dto.OrderResDto;
import inm.or.biz.service.OrderInnerService;
import inm.or.biz.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tony.ai.common.exception.BusinessException;
import tony.ai.common.util.MessageUtil;

@RestController
@RequiredArgsConstructor
@Log4j2
public class RestOrderController {

    private final OrderService orderService;
    private final OrderInnerService orderInnerService;
    private final OrderApi orderApi;

    @GetMapping("tran")
    public void tran() {
        String greeting = MessageUtil.getMessage("greeting");

        new BusinessException("greeting");
        new BusinessException("greeting", "fuck you");
        log.info(greeting);
    }

    @GetMapping("/getOrder")
    public OrderResDto getOrder() {
        OrderResDto orderResponseDto = new OrderResDto(1, "GetOrder Success!", "홍길동", "test@gmail.com");
        return orderResponseDto;
    }

    @GetMapping("/getOrderList")
    public OrderResDto getOrderList() {
//        comLogger.error("getOrderList Error!");
        OrderResDto orderResponseDto = new OrderResDto(1, "GetOrderList Success!", "김수지", "test2@gamil.com");
        return orderResponseDto;
    }

}
