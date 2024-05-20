package inm.or.biz.mapper.mapper1;

import inm.or.biz.mapper.vo.CustomerVo;
import inm.or.biz.mapper.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper1 {

    void insertProduct(ProductVo vo);
    ProductVo selectProduct(int id);
    void updateProduct(int id);
    void deleteProduct(int id);



    // 비정상 케이스
    void insertErrorCustomer(CustomerVo customerVo);
    CustomerVo selectErrorCustomer(int id);
    void deleteErrorCustomer(int id);


    void deleteErrorCustomerAll();

}
