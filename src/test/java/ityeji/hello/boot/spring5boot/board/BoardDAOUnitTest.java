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

import java.util.List;

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
        List<Board> results = bdao.selectBoard();

        //System.out.println(results);
        assertNotNull(results);
    }


}
