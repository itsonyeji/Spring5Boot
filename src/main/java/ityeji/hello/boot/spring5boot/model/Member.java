package ityeji.hello.boot.spring5boot.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    private String mno;
    private String userid;
    private String passwd;
    private String name;
    private String jumin;
    private String email;
    private String zipcode;
    private String addr1;
    private String addr2;
    private String phone;
    private String regdate;
/*zipcode, addr 같은 경우 중복으로 데이터가 들어갈수 있으므로
정규화를 위해 다른 테이블에 만들어야한다(실무에서 3정규화까지 씀)
하나의 테이블에 만들기보다 나눠서*/
}
