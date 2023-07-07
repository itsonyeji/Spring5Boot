package ityeji.hello.boot.spring5boot.dao;

import ityeji.hello.boot.spring5boot.model.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mdao") /*MemberDAOImpl의 줄임*/
public class MemberDAOImpl implements MemberDAO{

    // mybatis를 사용하기 위해 필요한 객체 DI
    @Autowired private SqlSession sqlSession;

    @Override
    public int insertMember(Member m) {
        // insert("insert관련맵핑", 매개변수)
        //"namespace.id"
        return sqlSession.insert("member.insertMember", m);/*"실제명", 매개변수이름*/
    }

    @Override
    public List<Member> selectMember() {
        return null;
    }
}
