package inm.or.biz.mapper.slave;

//import com.kyy.cu.common.annotation.SlaveMapper;
import inm.or.biz.mapper.vo.CustomerVo;

import java.util.List;

//@Mapper
public interface SelectUserMapper {
    List<CustomerVo> selectSlaveAllUsers();
}
