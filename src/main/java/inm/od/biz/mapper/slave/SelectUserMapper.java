package inm.od.biz.mapper.slave;

//import com.kyy.cu.common.annotation.SlaveMapper;
import inm.od.biz.vo.CustomerVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface SelectUserMapper {
    List<CustomerVo> selectSlaveAllUsers();
}
