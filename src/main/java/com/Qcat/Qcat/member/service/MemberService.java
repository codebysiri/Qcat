package com.Qcat.Qcat.member.service;

import com.Qcat.Qcat.member.dto.MemberDTO;

import java.util.Map;

public interface MemberService {

    // join
    void register(MemberDTO memberDTO) throws Exception;
    int idCheck(String login_id) throws Exception;
    int phoneCheck(String phone) throws Exception;

    // login
    Map<String, String> login(MemberDTO memberDTO);

    // myPage


}
