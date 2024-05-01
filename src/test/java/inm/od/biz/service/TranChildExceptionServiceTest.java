package inm.od.biz.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TranChildExceptionServiceTest {

    @Autowired
    private TranChildExceptionService tranChildExceptionService;
    @Autowired
    private CustomerService1 customerService1;
    @Autowired
    private CustomerService2 customerService2;
    @Autowired
    private CustomerService3 customerService3;
    @Autowired
    private CustomerService4 customerService4;


    @Test
//    @Transactional
    void insertErrorCustomer2() {
        try {
            tranChildExceptionService.insertErrorCustomer();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("CustomerService1.selectErrorCustomer1(1) = " + customerService1.selectErrorCustomer1(1));
            System.out.println("CustomerService2.selectErrorCustomer2(1) = " + customerService2.selectErrorCustomer2(1));
            System.out.println("CustomerService3.selectErrorCustomer3(1) = " + customerService3.selectErrorCustomer3(1));
            System.out.println("CustomerService4.selectErrorCustomer4(1) = " + customerService4.selectErrorCustomer4(1));
        }

    }
}