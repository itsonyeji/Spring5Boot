package ityeji.hello.boot.spring5boot.controller;

import ityeji.hello.boot.spring5boot.model.Board;
import ityeji.hello.boot.spring5boot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    final BoardService bsrv;

    Logger logger= LogManager.getLogger(BoardController.class);

    @GetMapping("/list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg){
        logger.info("board/list 호출!");
        m.addAttribute("bds", bsrv.readBoard(cpg));
        m.addAttribute("cpg", cpg);
        m.addAttribute("cntpg", bsrv.countBoard());   /* countpage 총페이지수 */

        return "board/list";
    }

    @GetMapping("/view/{bno}")
    public String view(Model m, @PathVariable String bno){
        logger.info("board/view 호출!");
        m.addAttribute("bd", bsrv.readOneBoard(bno));

        return "board/view";
    }

    @GetMapping("/write")
    public String write(){
        logger.info("board/write 호출!");

        return "board/write";
    }

    @PostMapping("/write")
    public String writeok(Board b){
        logger.info("board/writeok 호출!");
        String returnPage="redirect:/board/fail";
        if(bsrv.saveBoard(b))
            returnPage="redirect:/board/list/1";
        return returnPage;
    }

}
