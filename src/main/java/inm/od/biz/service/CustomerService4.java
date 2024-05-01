package inm.od.biz.service;

import inm.od.biz.mapper.mapper4.CustomerMapper4;
import inm.od.biz.mapper.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService4 {
    @Autowired
    private CustomerMapper4 customerMapper4;



    ////////////////////////////////
    // 비정상 케이스
    ////////////////////////////////
    public void deleteErrorCustomer4(int id) {
        customerMapper4.deleteErrorCustomer(id);
    }

    public CustomerVo selectErrorCustomer4(int id) {
        return customerMapper4.selectErrorCustomer(id);
    }

    public void insertErrorCustomer4(CustomerVo customerVo) {
        customerMapper4.insertErrorCustomer(customerVo);
//        throw new RuntimeException("CustomerService4.insertErrorCustomer4");
    }

    public void deleteErrorCustomerAll() {
        customerMapper4.deleteErrorCustomerAll();
    }
}
