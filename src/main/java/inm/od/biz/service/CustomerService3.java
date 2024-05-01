package inm.od.biz.service;

import inm.od.biz.mapper.mapper3.CustomerMapper3;
import inm.od.biz.mapper.mapper4.CustomerMapper4;
import inm.od.biz.mapper.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class, transactionManager = "transactionManager3")
@Transactional
public class CustomerService3 {
    @Autowired
    private CustomerMapper3 customerMapper3;


    ////////////////////////////////
    // 비정상 케이스
    ////////////////////////////////
    public void deleteErrorCustomer3(int id) {
        customerMapper3.deleteErrorCustomer(id);
    }

    public CustomerVo selectErrorCustomer3(int id) {
        return customerMapper3.selectErrorCustomer(id);
    }

//    @Transactional(transactionManager = "transactionManager3")
    public void insertErrorCustomer3(CustomerVo customerVo) {
        customerMapper3.insertErrorCustomer(customerVo);
//        if (true)
//            throw new RuntimeException("CustomerService3.insertErrorCustomer3");

    }

    public void deleteErrorCustomerAll() {
        customerMapper3.deleteErrorCustomerAll();
    }
}

