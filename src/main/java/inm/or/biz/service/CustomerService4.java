package inm.or.biz.service;

import inm.or.biz.mapper.mapper4.CustomerMapper4;
import inm.or.biz.mapper.vo.CustomerVo;
import inm.or.biz.mapper.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService4 {
    @Autowired
    private CustomerMapper4 customerMapper4;

    @Transactional
    public void insertProduct4(ProductVo vo) {
        customerMapper4.insertProduct(vo);
    }
    public ProductVo selectProduct4(int id) {
        return customerMapper4.selectProduct(id);
    }
    public void updateProduct4(int id) {
        customerMapper4.updateProduct(id);
    }
    public void deleteProduct4(int id) {
        customerMapper4.deleteProduct(id);
    }

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
