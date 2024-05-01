package inm.od.biz.service;

import inm.od.biz.mapper.mapper1.CustomerMapper1;
import inm.od.biz.mapper.vo.CustomerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService1 {

    private final CustomerMapper1 customerMapper1;


    ////////////////////////////////
    // 비정상 케이스
    ////////////////////////////////
    public void deleteErrorCustomer1(int id) {
        customerMapper1.deleteErrorCustomer(id);
    }
    public CustomerVo selectErrorCustomer1(int id) {
        return customerMapper1.selectErrorCustomer(id);
    }

    public void insertErrorCustomer1(CustomerVo vo) {
        customerMapper1.insertErrorCustomer(vo);
    }
    public void deleteErrorCustomerAll() {
        customerMapper1.deleteErrorCustomerAll();
    }
}
