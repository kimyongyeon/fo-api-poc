package inm.od.biz.service;

import inm.od.biz.mapper.mapper1.CustomerMapper1;
import inm.od.biz.mapper.vo.CustomerVo;
import inm.od.biz.mapper.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService1 {

    private final CustomerMapper1 customerMapper1;

    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 10)
    public void insertProduct1(ProductVo vo) {
        customerMapper1.insertProduct(vo);
    }
    public ProductVo selectProduct1(int id) {
        return customerMapper1.selectProduct(id);
    }
    public void updateProduct1(int id) {
        customerMapper1.updateProduct(id);
    }
    public void deleteProduct1(int id) {
        customerMapper1.deleteProduct(id);
    }


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
