package inm.od.biz.service;

import inm.od.biz.mapper.vo.CustomerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TranChildExceptionService {

    private final CustomerService1 customerService1;
    private final CustomerService2 customerService2;
    private final CustomerService3 customerService3;
    private final CustomerService4 customerService4;

    private void init() {
        customerService1.deleteErrorCustomerAll();
        customerService2.deleteErrorCustomerAll();
        customerService3.deleteErrorCustomerAll();
        customerService4.deleteErrorCustomerAll();
    }

    @Transactional
    public void insertErrorCustomer() {

        try {
            init();
            customerService1.insertErrorCustomer1(
                    CustomerVo.builder()
                            .id(1)
                            .name("name1")
                            .email("email1")
                            .build()
            );
            customerService2.insertErrorCustomer2(
                    CustomerVo.builder()
                            .id(1)
                            .name("name2")
                            .email("email2")
                            .build()
            );
            customerService3.insertErrorCustomer3(
                    CustomerVo.builder()
                            .id(1)
                            .name("name3")
                            .email("email3")
                            .build()
            );
            customerService4.insertErrorCustomer4(
                    CustomerVo.builder()
                            .id(1)
                            .name("name4")
                            .email("email4")
                            .build()
            );

            CustomerVo customerVo = customerService1.selectErrorCustomer1(1);
            System.out.println("db1 커밋전 :: " + customerVo);
            CustomerVo customerVo2 = customerService2.selectErrorCustomer2(1);
            System.out.println("db2 커밋전 :: " + customerVo2);
            CustomerVo customerVo3 = customerService3.selectErrorCustomer3(1);
            System.out.println("db3 커밋전 :: " + customerVo3);
            CustomerVo customerVo4 = customerService4.selectErrorCustomer4(1);
            System.out.println("db4 커밋전 :: " + customerVo4);

            throw new IllegalArgumentException("부모 에러");


        } catch (Exception e) {
            System.out.println("부모 에러 :: " + e.getMessage());
        }

    }


}
