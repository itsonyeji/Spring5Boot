package ityeji.hello.boot.spring5boot.board;

import ityeji.hello.boot.spring5boot.dao.BoardDAO;
import ityeji.hello.boot.spring5boot.dao.BoardDAOImpl;
import ityeji.hello.boot.spring5boot.model.Board;
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
@Import(BoardDAOImpl.class)    /*이걸 써야 autowired에 주입이 됨*/
public class BoardDAOUnitTest {

    @Autowired private BoardDAO bdao;

    @Test
    @DisplayName("BoardDAO select Test")
    void selectBoard(){
        int cpg=1;
        int stnum=(cpg-1)*25;
        List<Board> results = bdao.selectBoard(stnum);

        //System.out.println(results);
        assertNotNull(results);
    }

    @Test
    @DisplayName("BoardDAO selectOne Test")
     void selectOneBoard(){
        String bno="2659";
        Board result = bdao.selectOneBoard(bno);

        assertNotNull(result);
    }

    @Test
    @DisplayName("BoardDAO insert Test")
    @Transactional
    void insertBoard(){
        Board b = new Board();
        b.setUserid("abc123");
        b.setTitle("테스트");
        b.setContents("테스트");
        b.setIpaddr("127.0.0.1");

        int result = bdao.insertBoard(b);
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("BoardDAO count Test")
    void countBoard(){
        int result = bdao.selectCountBoard();

        assertNotNull(result);
    }

    @Test
    @DisplayName("BoardDAO findBoard Test")
    void findBoard(){
        Map<String, Object> params = new HashMap<>();
        params.put("findtype", "titcont");
        params.put("findkey", "지진");
        params.put("stnum", 0);

        List<Board> results = bdao.selectFindBoard(params);
        assertNotNull(results);

    }

    @Test
    @DisplayName("BoardDAO countFindBoard Test")
    void countFindBoard(){
        Map<String, Object> params = new HashMap<>();
        params.put("findtype", "titcont");
        params.put("findkey", "지진");

        int result = bdao.countFindBoard(params);
        assertNotNull(result);

    }

}
