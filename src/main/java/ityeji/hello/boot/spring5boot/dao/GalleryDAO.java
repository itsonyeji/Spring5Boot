package ityeji.hello.boot.spring5boot.dao;

import ityeji.hello.boot.spring5boot.model.Gallery;

import java.util.List;

public interface GalleryDAO {
    List<Gallery> selectGallery(int stnum);
}
