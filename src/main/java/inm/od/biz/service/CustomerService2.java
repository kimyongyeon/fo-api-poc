package inm.od.biz.service;

import inm.od.biz.mapper.mapper2.CustomerMapper2;
import inm.od.biz.mapper.vo.CustomerVo;
import inm.od.biz.mapper.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class, transactionManager = "transactionManager2")
public class CustomerService2 {

    @Autowired
    private CustomerMapper2 customerMapper2;

    @Transactional
    public void insertProduct2(ProductVo vo) {
        customerMapper2.insertProduct(vo);
    }
    public ProductVo selectProduct2(int id) {
        return customerMapper2.selectProduct(id);
    }
    public void updateProduct2(int id) {
        customerMapper2.updateProduct(id);
    }
    public void deleteProduct2(int id) {
        customerMapper2.deleteProduct(id);
    }

    ////////////////////////////////
    // 비정상 케이스
    ////////////////////////////////
    public void deleteErrorCustomer2(int id) {
        customerMapper2.deleteErrorCustomer(id);
    }

    public CustomerVo selectErrorCustomer2(int id) {
        return customerMapper2.selectErrorCustomer(id);
    }

    public void insertErrorCustomer2(CustomerVo customerVo) {
        customerMapper2.insertErrorCustomer(customerVo);
    }

    public void deleteErrorCustomerAll() {
        customerMapper2.deleteErrorCustomerAll();
    }
}
