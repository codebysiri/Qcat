package com.Qcat.Qcat.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Login
    @Override
    public Map<String, String> login(MemberDTO memberDTO) {
        return memberRepository.login(memberDTO);
    }

    // JOIN
    @Override
    public void register(MemberDTO memberDTO) throws Exception {
        memberRepository.register(memberDTO);
    }

    @Override
    public int idCheck(String login_id) throws Exception {
        int result = memberRepository.idCheck(login_id);
        return result;
    }
    @Override
    public int phoneCheck(String phone) throws Exception {
        int result = memberRepository.phoneCheck(phone);
        return result;
    }

    // MyPage


}
