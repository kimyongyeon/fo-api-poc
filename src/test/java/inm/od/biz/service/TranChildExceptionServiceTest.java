package inm.od.biz.service;

import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void setUp() {
        customerService1.deleteProduct1(1);
        customerService2.deleteProduct2(1);
        customerService3.deleteProduct3(1);
        customerService4.deleteProduct4(1);
    }
    @Test
    void insertErrorCustomer2() {
        try {
            tranChildExceptionService.insertErrorCustomer();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("db1 :: " + customerService1.selectProduct1(1));
            System.out.println("db2 :: " + customerService2.selectProduct2(1));
            System.out.println("db3 :: " + customerService3.selectProduct3(1));
            System.out.println("db4 :: " + customerService4.selectProduct4(1));

        }

    }
}