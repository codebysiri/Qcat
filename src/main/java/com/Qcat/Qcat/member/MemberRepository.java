package com.Qcat.Qcat.member;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberRepository {

    // JOIN
    void register(MemberDTO memberDTO) throws Exception;
    int idCheck(String login_id) throws Exception;
    int phoneCheck(String phone) throws Exception;

    // Login
    Map<String, String> login(MemberDTO memberDTO);

    // MyPage


}
