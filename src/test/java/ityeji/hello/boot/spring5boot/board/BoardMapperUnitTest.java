package ityeji.hello.boot.spring5boot.board;

import ityeji.hello.boot.spring5boot.model.Board;
import ityeji.hello.boot.spring5boot.mybatis.BoardMapper;
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
public class BoardMapperUnitTest {

    @Autowired
    private BoardMapper boardMapper;

    /*@Test
    @DisplayName("BoardMapper insert Test")   *//*명시될 test의 이름*//*
    void insertBoard(){
        Board b = new Board(null, "", "abc123",null, "", "","","");
        int result = boardMapper.insertBoard(b);
        System.out.println(result);
        assertEquals(result, 1);
    }*/

    @Test
    @DisplayName("BoardMapper select Test")
    void selectBoard(){
        int cpg=1;
        int stnum=(cpg-1)*25;
        List<Board> results = boardMapper.selectBoard(stnum);
        System.out.println(results);
        assertNotNull(results);

    }
    @Test
    @DisplayName("BoardMapper selectOne Test")
    void selectOneBoard(){
        String bno ="2659";
        Board result = boardMapper.selectOneBoard(bno);

        System.out.println(result);
        assertNotNull(result);
        }


}
