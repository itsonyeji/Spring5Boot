package ityeji.hello.boot.spring5boot.pds;

import ityeji.hello.boot.spring5boot.dao.PdsDAO;
import ityeji.hello.boot.spring5boot.dao.PdsDAOImpl;
import ityeji.hello.boot.spring5boot.model.Pds;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)  /*자동으로 h2 데이터베이스를 사용하려고함. 내가 쓰는 데이터베이스로 조정해야함. replace속성으로*/
@Import(PdsDAOImpl.class)    /*이걸 써야 autowired에 주입이 됨*/
public class PdsDAOUnitTest {

    @Autowired private PdsDAO pdao;

    @Test
    @DisplayName("PdsDAO select Test")
    void selectPds(){
        int cpg=1;
        int stnum=(cpg-1)*25;
        List<Pds> results = pdao.selectPds(stnum);

        assertNotNull(results);
    }

    @Test
    @DisplayName("PdsDAO selectOne Test")
     void selectOnePds(){
        String pno="10";
        Pds result = pdao.selectOnePds(pno);

        assertNotNull(result);
    }
/*
    @Test
    @DisplayName("PdsDAO insert Test")
    @Transactional
    void insertPds(){
        Pds b = new Pds();
        b.setUserid("abc123");
        b.setTitle("테스트");
        b.setContents("테스트");
        b.setIpaddr("127.0.0.1");

        int result = pdao.insertPds(b);
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("PdsDAO count Test")
    void countPds(){
        int result = pdao.selectCountPds();

        assertNotNull(result);
    }

    @Test
    @DisplayName("PdsDAO findPds Test")
    void findPds(){
        Map<String, Object> params = new HashMap<>();
        params.put("findtype", "titcont");
        params.put("findkey", "지진");
        params.put("stnum", 0);

        List<Pds> results = pdao.selectFindPds(params);
        assertNotNull(results);

    }

    @Test
    @DisplayName("PdsDAO countFindPds Test")
    void countFindPds(){
        Map<String, Object> params = new HashMap<>();
        params.put("findtype", "titcont");
        params.put("findkey", "지진");

        int result = pdao.countFindPds(params);
        assertNotNull(result);

    }*/

}
