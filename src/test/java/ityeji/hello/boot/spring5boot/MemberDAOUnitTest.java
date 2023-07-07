package ityeji.hello.boot.spring5boot;

import ityeji.hello.boot.spring5boot.dao.MemberDAO;
import ityeji.hello.boot.spring5boot.dao.MemberDAOImpl;
import ityeji.hello.boot.spring5boot.model.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@MybatisTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)  /*자동으로 h2 데이터베이스를 사용하려고함. 내가 쓰는 데이터베이스로 조정해야함. replace속성으로*/
@Import(MemberDAOImpl.class)    /*이걸 써야 autowired에 주입이 됨*/
public class MemberDAOUnitTest {

    @Autowired private MemberDAO mdao;

    @Test
    @DisplayName("MemberDAO insert Test")   /*명시될 test의 이름*/
    void insertMember(){
        Member m = new Member(null, "", "", "", "","","","","",null);
        int result = mdao.insertMember(m);
        System.out.println(result);
        assertEquals(result, 1);
    }

}
