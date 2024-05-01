package inm.od.biz.mapper.mapper2;

import inm.od.biz.mapper.vo.CustomerVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper2 {


    // 비정상 케이스
    void insertErrorCustomer(CustomerVo customerVo);
    CustomerVo selectErrorCustomer(int id);
    void deleteErrorCustomer(int id);

    void deleteErrorCustomerAll();
}
