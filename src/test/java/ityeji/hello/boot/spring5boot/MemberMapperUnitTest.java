package ityeji.hello.boot.spring5boot;

import ityeji.hello.boot.spring5boot.model.Member;
import ityeji.hello.boot.spring5boot.mybatis.MemberMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)  /*자동으로 h2 데이터베이스를 사용하려고함. 내가 쓰는 데이터베이스로 조정해야함. replace속성으로*/
public class MemberMapperUnitTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    @DisplayName("MemberMapper insert Test")   /*명시될 test의 이름*/
    void insertMember(){
        Member m = new Member(null, "", "","", "", "","","","","",null);
        int result = memberMapper.insertMember(m);
        System.out.println(result);
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("MemberMapper select Test")
    void selectMember(){
        List<Member> results = memberMapper.selectMember();
        System.out.println(results);
        assertNotNull(results);

    }
    @Test
        @DisplayName("MemberMapper selectOneMember Test")
        void selectOneMember(){
            Member m = new Member();
            m.setUserid("abc123");
            m.setPasswd("987xyz");

            Member result = memberMapper.selectOneMember(m);

            System.out.println(result);
            assertNotNull(result);

        }


}
