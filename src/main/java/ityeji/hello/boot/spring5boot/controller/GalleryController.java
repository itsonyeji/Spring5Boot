package ityeji.hello.boot.spring5boot.controller;

import ityeji.hello.boot.spring5boot.model.Gallery;
import ityeji.hello.boot.spring5boot.model.Pds;
import ityeji.hello.boot.spring5boot.service.GalleryService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/gallery")
@RequiredArgsConstructor
public class GalleryController {

    final GalleryService gsrv;

    Logger logger= LogManager.getLogger(GalleryController.class);

    @GetMapping("/list/{cpg}")
    public String list(Model m , @PathVariable Integer cpg){
        logger.info("gallery/list 호출!");

        m.addAttribute("gals", gsrv.readGallery(cpg));
        m.addAttribute("cpg", cpg);
        m.addAttribute("cntpg", gsrv.countGallery());   /* countpage 총페이지수 */
        m.addAttribute("stpg", ((cpg-1)/10)*10+1);

        /*if(cpg > (int)m.getAttribute("cntpg"))  {
            return "redirect:/gallery/list/1";
        }*/

        return "gallery/list";
    }

    @GetMapping("/write")
    public String write(){
        logger.info("gallery/write 호출!");

        return "gallery/write";
    }

    @PostMapping("/write")
    public String writeok(Gallery g, List<MultipartFile> attachs){ /* attach는 multipartfile 형태(binary)로 가져옴 */
        logger.info("gallery/writeok 호출!");
        String returnPage="redirect:/gallery/fail";

        // 작성한 게시글을 먼저 디비에 저장하고 글번호를 알아냄
        int gno = gsrv.newGallery(g);

        // 알아낸 글번호를 이용해서 첨부파일 처리 (DB 저장, 업로드)
        if(!attachs.isEmpty()) {  // 첨부파일 존재한다면 지정한 위치에 파일 저장.
            gsrv.newGalAttach(attachs, gno);

            returnPage = "redirect:/gallery/list/1";
        }


        return returnPage;
    }

    @GetMapping("/view/{gno}")
    public String view(Model m, @PathVariable String gno){
        logger.info("gallery/view 호출!");

        m.addAttribute("g", gsrv.readOneGallery(gno));  // 본문글

        return "gallery/view";
    }


}
