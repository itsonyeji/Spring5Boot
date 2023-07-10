package ityeji.hello.boot.spring5boot.dao;

import ityeji.hello.boot.spring5boot.model.Member;
import ityeji.hello.boot.spring5boot.model.Zipcode;
import ityeji.hello.boot.spring5boot.mybatis.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mdao") /*MemberDAOImpl의 줄임*/
@RequiredArgsConstructor    /*생성자를 자동으로 만들어줌*/
public class MemberDAOImpl implements MemberDAO{

    // mybatis를 사용하기 위해 필요한 객체 DI
    // 단, 생성자 주입 방식 사용!
    @Autowired
    final MemberMapper memberMapper;
    /*sql이 아닌 MemberMapper로 가져옴*/

    @Override
    public int insertMember(Member m) {
        // insert("insert관련맵핑", 매개변수)
        // sqlSession.insert("namespace.id", m)로 사용하는 방식보다는 편리
        //return sqlSession.insert("ityeji.hello.boot.spring5boot.mybatis.MemberMapper.insertMember", m); /*이거는 좀 길다.*/
        //return sqlSession.insert("MemberMapper.insertMember", m); /*이거는 좀 길다.*/
        return memberMapper.insertMember(m);  /*memberMapper로 만드는건 인터페이스파일 하나 더 만들어야하지만 깔끔*/
    }

    @Override
    public List<Member> selectMember() {

        return memberMapper.selectMember();
    }

    @Override
    public List<Zipcode> selectzip(String dong) {

        return memberMapper.findZipcode(dong);  //실제 메서드 이름
    }

    @Override
    public int selectOneUserid(String uid) {
        return memberMapper.selectOneUserid(uid);
    }


}
