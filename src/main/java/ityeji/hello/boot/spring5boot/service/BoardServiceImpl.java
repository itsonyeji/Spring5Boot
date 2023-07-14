package ityeji.hello.boot.spring5boot.service;

import ityeji.hello.boot.spring5boot.dao.BoardDAO;
import ityeji.hello.boot.spring5boot.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("bsrv")
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    final BoardDAO bdao;
    @Override
    public boolean saveBoard(Board b) {
        boolean isSaved=false;
        if(bdao.insertBoard(b)>0)
            isSaved=true;

        return isSaved;
    }

    @Override
    public List<Board> readBoard(Integer cpg) {
        int stnum = (cpg -1) * 25;
        return bdao.selectBoard(stnum);
    }

    @Override
    public Board readOneBoard(String bno) {

        return bdao.selectOneBoard(bno);
    }

    @Override
    public int countBoard() {
        return bdao.selectCountBoard();
    }

    @Override
    public List<Board> readFindBoard(Integer cpg, String ftype, String fkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("findtype", ftype);
        params.put("findkey", fkey);
        params.put("stnum", (cpg-1)*25);

        return bdao.selectFindBoard(params);
    }

    @Override
    public int countFindBoard(String ftype, String fkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("findtype", ftype);
        params.put("findkey", fkey);

        return bdao.countFindBoard(params);
    }
}
