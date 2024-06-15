package inm.or.biz.dao;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.HashMap;
import java.util.Map;

public class MemberDao extends SqlSessionDaoSupport {
    public MemberDto selectMemberDtoById(int id) {
        getSqlSession().select("MemberDto.selectAll", (ResultHandler<MemberDto>) resultContext -> {
            MemberDto MemberDto = resultContext.getResultObject();
            // 결과 처리 로직 작성
        });

        Map<String, Object> params = new HashMap<>();
        params.put("name", "John");
        RowBounds rowBounds = new RowBounds(0, 10);
        getSqlSession().select("MemberDto.selectByCondition", params, rowBounds, (ResultHandler<MemberDto>) resultContext -> {
            MemberDto MemberDto = resultContext.getResultObject();
            // 결과 처리 로직 작성
        });

        return new MemberDto();
    }

}
