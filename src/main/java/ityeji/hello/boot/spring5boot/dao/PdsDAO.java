package ityeji.hello.boot.spring5boot.dao;

import ityeji.hello.boot.spring5boot.model.Pds;
import ityeji.hello.boot.spring5boot.model.PdsAttach;

public interface PdsDAO {
    int insertPds(Pds p);

    int insertPdsdAttach(PdsAttach pa);
}
