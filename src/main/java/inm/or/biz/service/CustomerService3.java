package inm.or.biz.service;

import inm.or.biz.mapper.mapper3.CustomerMapper3;
import inm.or.biz.mapper.vo.CustomerVo;
import inm.or.biz.mapper.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class, transactionManager = "transactionManager3")
@Transactional
public class CustomerService3 {
    @Autowired
    private CustomerMapper3 customerMapper3;

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertProduct3(ProductVo vo) {
        customerMapper3.insertProduct(vo);
//        throw new RuntimeException("CustomerService3.insertProduct3");
    }
    public ProductVo selectProduct3(int id) {
        return customerMapper3.selectProduct(id);
    }
    public void updateProduct3(int id) {
        customerMapper3.updateProduct(id);
    }
    public void deleteProduct3(int id) {
        customerMapper3.deleteProduct(id);
    }

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

