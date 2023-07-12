package ityeji.hello.boot.spring5boot.dao;

import ityeji.hello.boot.spring5boot.model.Board;

import java.util.List;

public interface BoardDAO {
    int insertBoard(Board b);
    List<Board> selectBoard();
    Board selectOneBoard(String bno);
}
