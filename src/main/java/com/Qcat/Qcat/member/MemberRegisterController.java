package com.Qcat.Qcat.member;

import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping(value = "/phoneCheck", method = RequestMethod.POST)
    public int phoneCheck(String phone_number) throws Exception {
        int result = memberService.phoneCheck(phone_number);
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