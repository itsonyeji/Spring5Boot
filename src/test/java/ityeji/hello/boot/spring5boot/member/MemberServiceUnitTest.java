package ityeji.hello.boot.spring5boot.member;

import ityeji.hello.boot.spring5boot.dao.MemberDAOImpl;
import ityeji.hello.boot.spring5boot.model.Member;
import ityeji.hello.boot.spring5boot.service.MemberService;
import ityeji.hello.boot.spring5boot.service.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)  /*자동으로 h2 데이터베이스를 사용하려고함. 내가 쓰는 데이터베이스로 조정해야함. replace속성으로*/
@Import({MemberServiceImpl.class, MemberDAOImpl.class})    /*이걸 써야 autowired에 주입이 됨*/
public class MemberServiceUnitTest {

    @Autowired private MemberService msrv;

    @Test
    @DisplayName("MemberService save Test")   /*명시될 test의 이름*/
    void saveMember(){
        Member m = new Member(null, "", "","", "", "","","","","",null);
        boolean result = msrv.saveMember(m);
        System.out.println(result);
        assertEquals(result, true);
    }
    @Test
    @DisplayName("MemberDAO read Test")
    void readMember(){
        List<Member> results = msrv.readMember();
        System.out.println(results);
        assertNotNull(results);
    }

    @Test
    @DisplayName("MemberService readOneMember Test")
    void readOneMember(){
        Member m = new Member();
        m.setUserid("abc123");
        m.setPasswd("987xyz");

        Member result = msrv.readOneMember(m);

        System.out.println(result);
        assertNotNull(result);
    }


}
