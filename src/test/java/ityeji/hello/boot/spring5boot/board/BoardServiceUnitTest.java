package ityeji.hello.boot.spring5boot.board;

import ityeji.hello.boot.spring5boot.dao.BoardDAOImpl;
import ityeji.hello.boot.spring5boot.model.Board;
import ityeji.hello.boot.spring5boot.service.BoardService;
import ityeji.hello.boot.spring5boot.service.BoardServiceImpl;
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
@Import({BoardServiceImpl.class, BoardDAOImpl.class})    /*이걸 써야 autowired에 주입이 됨*/
public class BoardServiceUnitTest {

    @Autowired private BoardService bsrv;

    @Test
    @DisplayName("BoardService save Test")
    void saveBoard(){
        Board b = new Board();
        b.setUserid("abc123");
        b.setTitle("테스트");
        b.setContents("테스트");
        b.setIpaddr("127.0.0.1");

        boolean result = bsrv.saveBoard(b);

        //System.out.println(results);
        assertEquals(result, true);
    }

    @Test
    @DisplayName("BoardService read Test")
    void readBoard(){
        int cpg=1;
        List<Board> results = bsrv.readBoard(cpg);

        //System.out.println(results);
        assertNotNull(results);
    }

    @Test
    @DisplayName("BoardService readOne Test")
    void readOneBoard(){
        String bno ="2659";

        Board result = bsrv.readOneBoard(bno);
        assertNotNull(result);
    }

    @Test
    @DisplayName("BoardService count Test")
    void countBoard(){
        int result = bsrv.countBoard();

        assertNotNull(result);
    }
}
