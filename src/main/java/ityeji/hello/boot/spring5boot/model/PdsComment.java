package ityeji.hello.boot.spring5boot.model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PdsComment {
    private String cno;
    private String comments;
    private String userid;
    private String regdate;
    private String pno;
    private String ref;

}
