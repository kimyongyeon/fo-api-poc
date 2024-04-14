package inm.od.biz.mapper.master;

import com.kyy.cu.common.annotation.MasterMapper;
import inm.od.biz.vo.CustomerVo;

import java.util.List;

@MasterMapper
public interface InsertUserMapper {

    List<CustomerVo> selectAllUsers();

    void insertUser(String name);
}
