package inm.or.biz.controller;

import inm.or.biz.api.OrderApi;
import inm.or.biz.dto.OrderResDto;
import inm.or.biz.service.OrderInnerService;
import inm.or.biz.service.OrderService;
import inm.or.common.feign.ApiServiceClient;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class RestOrderController {

    private final OrderService orderService;
    private final OrderInnerService orderInnerService;
    private final OrderApi orderApi;

    private final ApiServiceClient apiServiceClient;

    /**
     * 인증필요: http GET http://localhost:8080/api/feignSome Cookie:Authorization=Bearer%20example-token X-Use-Token:true
     * 불필요: http GET http://localhost:8080/api/feignSome Cookie:Authorization=Bearer%20example-token
     *
     */
    @GetMapping("/feignSome")
    public void feignSome() {
        apiServiceClient.getSomeData();
    }

    @GetMapping("/rcvFeignSome")
    public void rcvFeignSome(HttpServletRequest request) {
        log.info("rcvFeignSome");
        log.info("request.getHeader(\"Authorization\") : " + request.getHeader("Authorization"));

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
