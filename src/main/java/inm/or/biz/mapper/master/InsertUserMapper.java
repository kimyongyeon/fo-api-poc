package inm.or.biz.mapper.master;

//import com.kyy.cu.common.annotation.MasterMapper;
import inm.or.biz.mapper.vo.CustomerVo;

import java.util.List;

//@Mapper
public interface InsertUserMapper {

    List<CustomerVo> selectAllUsers();

    void insertUser(String name);
}
