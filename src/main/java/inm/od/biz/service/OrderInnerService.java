package inm.od.biz.service;

import com.kyy.cu.common.ComLogger;
import inm.od.biz.dto.OrderListResponseDto;
import inm.od.biz.dto.OrderResponseDto;
import inm.od.biz.mapper.master.InsertUserMapper;
import inm.od.biz.mapper.slave.SelectUserMapper;
import inm.od.biz.vo.CustomerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderInnerService {
    private final InsertUserMapper insertUserMapper;

    private final SelectUserMapper selectUserMapper;
    private final ComLogger comLogger;

    @Transactional
    public OrderListResponseDto tran() {
        List<CustomerVo> customerVos1 = selectUserMapper.selectSlaveAllUsers();
        comLogger.error(customerVos1.toString());
        List<CustomerVo> customerVos = insertUserMapper.selectAllUsers();
        OrderResponseDto orderResponseDto = new OrderResponseDto(1, "Success!");
        for(CustomerVo customerVo : customerVos) {
            orderResponseDto.setMessage(customerVo.getName());
            orderResponseDto.setId(2);
        }
        return OrderListResponseDto.builder()
                .orderList(List.of(orderResponseDto))
                .build();
    }
}
