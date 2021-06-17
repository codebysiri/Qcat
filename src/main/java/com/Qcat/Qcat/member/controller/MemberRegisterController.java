package com.Qcat.Qcat.member.controller;

import com.Qcat.Qcat.member.service.MemberService;
import com.Qcat.Qcat.member.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberRegisterController {

    private MemberService memberService;

    // Join page
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public void registerGET() throws Exception {

    }

    @ResponseBody
    @RequestMapping(value = "/idCheck", method = RequestMethod.POST)
    public int idCheck(String login_id) throws Exception {
        int result = memberService.phoneCheck(login_id);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/phoneCheck", method = RequestMethod.POST)
    public int phoneCheck(String phone) throws Exception {
        int result = memberService.phoneCheck(phone);
        return result;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String registerPOST(MemberDTO memberDTO, String login_id, String phone) throws Exception {
        int phoneResult = memberService.phoneCheck(phone);
        int idResult = memberService.idCheck(login_id);

        if (idResult == 1 && phoneResult == 1) {
                return "/member/signup";
            } else if (idResult == 0 && phoneResult == 0) {
                memberService.register(memberDTO);
                return "redirect:/member/login";
            }

        return "redirect:/";
    }
}