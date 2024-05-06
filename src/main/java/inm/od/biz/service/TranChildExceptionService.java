package inm.od.biz.service;

import inm.od.biz.mapper.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TranChildExceptionService {

    private final CustomerService1 customerService1;
    private final CustomerService2 customerService2;
    private final CustomerService3 customerService3;
    private final CustomerService4 customerService4;

    @Transactional
    public void insertErrorCustomer() {
        customerService1.insertProduct1(
                ProductVo.builder()
                        .id(1)
                        .name("name1")
                        .stock(1000)
                        .build()
        );
        customerService2.insertProduct2(
                ProductVo.builder()
                        .id(1)
                        .name("name2")
                        .stock(2000)
                        .build()
        );
        customerService3.insertProduct3(
                ProductVo.builder()
                        .id(1)
                        .name("name3")
                        .stock(3000)
                        .build()
        );
        customerService4.insertProduct4(
                ProductVo.builder()
                        .id(1)
                        .name("name3")
                        .stock(4000)
                        .build()
        );
        ProductVo vo = customerService1.selectProduct1(1);
        System.out.println("db1 커밋전 :: " + vo);
        ProductVo vo2 = customerService2.selectProduct2(1);
        System.out.println("db2 커밋전 :: " + vo2);
        ProductVo vo3 = customerService3.selectProduct3(1);
        System.out.println("db3 커밋전 :: " + vo3);
        ProductVo vo4 = customerService4.selectProduct4(1);
        System.out.println("db4 커밋전 :: " + vo4);
        if (true)
            throw new IllegalArgumentException("부모 에러");
    }


}
