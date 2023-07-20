package ityeji.hello.boot.spring5boot.mybatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GalleryMapper {
    int insertGallery(Gallery g);

    int insertGalAttach(GalAttach ga);

    List<Gallery> selectGallery(int stnum);
    Gallery selectOneGallery(String gno);

    int selectCountGallery();

    GalAttach selectOneGalAttach(String gno);

    /*int insertGalleryComment(GalleryComment pc);

    List<GalleryComment> selectGalleryComment(String pno);

    int insertGalleryReply(GalleryComment pc);*/

   /*  int updateViewGallery(String bno);

    List<Gallery> selectFindGallery(Map<String, Object> params);
    int countFindGallery(Map<String, Object> params);*/

}
