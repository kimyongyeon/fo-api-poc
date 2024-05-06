package inm.od.biz.mapper.mapper4;

import inm.od.biz.mapper.vo.CustomerVo;
import inm.od.biz.mapper.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper4 {

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
