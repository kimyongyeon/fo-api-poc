package inm.or.biz.service;

//import com.kyy.cu.common.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
//    private final OrderApi orderApi;
//    private final InsertUserMapper insertUserMapper;
//    private final SelectUserMapper selectUserMapper;

//    public OrderListResponseDto tran() {
//        List<CustomerVo> customerVos = insertUserMapper.selectAllUsers();
//        OrderResponseDto orderResponseDto = new OrderResponseDto(1, "Success!");
//        for(CustomerVo customerVo : customerVos) {
//            orderResponseDto.setMessage(customerVo.getName());
//            orderResponseDto.setId(2);
//        }
//        return OrderListResponseDto.builder()
//                .orderList(List.of(orderResponseDto))
//                .build();
//    }
//
//    @Transactional
//    public void myMethod() {
//        outerMethod();
//        innerMethod();
//    }
//
//    private void outerMethod() {
//        insertUserMapper.selectAllUsers();
//    }
//
//    private void innerMethod() {
//        selectUserMapper.selectSlaveAllUsers();
//    }

//    public OrderListResponseDto getOrder() {
//        try {
//            var order = orderApi.getOrder();
//            var orderList = orderApi.getOrderList();
//            return OrderListResponseDto.builder()
//                    .orderList(List.of(order.getData(), orderList.getData()))
//                    .build();
//        } catch(FeignException e) {
//            throw new BusinessException("biz.od.feign.001");
//        }
//
//    }

}
