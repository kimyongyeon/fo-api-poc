package inm.od.biz.mapper.master;

//import com.kyy.cu.common.annotation.MasterMapper;
import inm.od.biz.vo.CustomerVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface InsertUserMapper {

    List<CustomerVo> selectAllUsers();

    void insertUser(String name);
}
