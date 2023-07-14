package ityeji.hello.boot.spring5boot.pds;

import ityeji.hello.boot.spring5boot.model.Pds;
import ityeji.hello.boot.spring5boot.mybatis.PdsMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)  /*자동으로 h2 데이터베이스를 사용하려고함. 내가 쓰는 데이터베이스로 조정해야함. replace속성으로*/
public class PdsMapperUnitTest {

    @Autowired
    private PdsMapper pdsMapper;

    @Test
    @DisplayName("PdsMapper lastid Test")
    @Transactional
    void lastIdPds(){
        Pds b = new Pds();
        b.setUserid("abc123");
        b.setTitle("테스트");
        b.setContents("테스트");
        b.setIpaddr("127.0.0.1");

        pdsMapper.insertPds(b);
        int result =pdsMapper.lastPdsPno();
        assertNotNull(result);
    }
/*


    @Test
    @DisplayName("PdsMapper selectOne Test")
    void selectOnePds(){
        String bno ="2659";
        Pds result = pdsMapper.selectOnePds(bno);

        System.out.println(result);
        assertNotNull(result);
        }

    @Test
    @DisplayName("PdsMapper update Test")
    @Transactional
    void updatePds(){
        String bno="2659";

        int result = pdsMapper.updateViewPds(bno);
        assertEquals(result, 1);
    }
    @Test
    @DisplayName("PdsMapper countPage Test")
    void countPds(){
        int result = pdsMapper.selectCountPds();
        assertNotNull(result);

    }

    @Test
    @DisplayName("PdsMapper findPds Test")
    void findPds(){
        Map<String, Object> params = new HashMap<>();
        params.put("findtype", "titcont");
        params.put("findkey", "지진");
        params.put("stnum", 0);

        List<Pds> results = pdsMapper.selectFindPds(params);
        assertNotNull(results);

    }

    @Test
    @DisplayName("PdsMapper countfindPds Test")
    void countfindPds(){
        Map<String, Object> params = new HashMap<>();
        params.put("findtype", "title");
        params.put("findkey", "찹쌀떡");

        int result = pdsMapper.countFindPds(params);
        assertNotNull(result);

    }*/

}
