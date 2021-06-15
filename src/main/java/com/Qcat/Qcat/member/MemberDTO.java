package com.Qcat.Qcat.member;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDTO {

    private Long member_id;
    private String login_id;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String role;

}
