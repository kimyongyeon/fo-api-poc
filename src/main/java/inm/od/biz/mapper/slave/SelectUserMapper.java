package inm.od.biz.mapper.slave;

import com.kyy.cu.common.annotation.SlaveMapper;
import inm.od.biz.vo.CustomerVo;

import java.util.List;

@SlaveMapper
public interface SelectUserMapper {
    List<CustomerVo> selectSlaveAllUsers();
}
