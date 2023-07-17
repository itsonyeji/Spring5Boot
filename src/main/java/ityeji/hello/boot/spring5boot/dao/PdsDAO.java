package ityeji.hello.boot.spring5boot.dao;

import ityeji.hello.boot.spring5boot.model.Pds;
import ityeji.hello.boot.spring5boot.model.PdsAttach;

import java.util.List;

public interface PdsDAO {
    int insertPds(Pds p);

    int insertPdsdAttach(PdsAttach pa);

    List<Pds> selectPds(int stnum);

    int selectCountPds();

    Pds selectOnePds(String pno);
}
