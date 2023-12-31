package ityeji.hello.boot.spring5boot.gallery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class GalControllerUnitTest {

    @Autowired private MockMvc mvc;

    @Test
    @DisplayName("GalleryController upload Test")
    @Transactional
    void writeok() throws Exception {
        String fpath = "C:/Java/hipo.jpg";
        FileInputStream fis = new FileInputStream(fpath);   /* 파일을 그대로 읽어서 변수에 저장. buffer를 쓰면 입출력 속도가 빠름 */

        // MockMultipartFile(폼이름, 파일명, MIME, 파일객체)  - 첨부
        MockMultipartFile attach = new MockMultipartFile(       /* 어떤 종류의 파일을 불러올지 지정 */
          "attachs", "hipo.jpg", "image/png", fis);
        mvc.perform(multipart("/gallery/write").file(attach)    /* 지정한 폼이름 정확히 */
                        .param("title","aaa")
                        .param("userid","abc123")
                        .param("contents","bbb")
                        .param("ipaddr","127.0.0.1"))
                .andExpect(status().is3xxRedirection())
                .andDo(print());
    }

}

