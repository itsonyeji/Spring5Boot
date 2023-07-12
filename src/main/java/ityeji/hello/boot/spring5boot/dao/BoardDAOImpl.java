package ityeji.hello.boot.spring5boot.dao;

import ityeji.hello.boot.spring5boot.model.Board;
import ityeji.hello.boot.spring5boot.mybatis.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bdao") /*MemberDAOImpl의 줄임*/
@RequiredArgsConstructor    /*생성자를 자동으로 만들어줌*/
public class BoardDAOImpl implements BoardDAO{

    //@Autowired 없이 DI 구현 - 하나일땐 필요없음
    final BoardMapper boardMapper;

    @Override
    public int insertBoard(Board b) {
        return boardMapper.insertBoard(b);
    }

    @Override
    public List<Board> selectBoard(int stnum) {

        return boardMapper.selectBoard(stnum);
    }

    @Override
    public Board selectOneBoard(String bno) {

        return boardMapper.selectOneBoard(bno);
    }
}
