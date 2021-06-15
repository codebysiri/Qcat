package com.Qcat.Qcat.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberLoginController {

    private final MemberService memberService;

    @Autowired
    public MemberLoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    // login page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(@ModelAttribute("memberDTO")MemberDTO memberDTO) {
        return "/member/login";
    }


    // login session
    @PostMapping("/user/login")
    public String loginPOST(MemberDTO memberDTO, HttpServletRequest request) {

        HttpSession session = request.getSession();

        Map<String,String> memberInform = memberService.login(memberDTO);
        System.out.println(memberDTO);
        System.out.println(memberInform);
        if(memberInform.get("login_id").equals(memberDTO.getLogin_id()) && memberInform.get("password").equals(memberDTO.getPassword())){
            session.setAttribute("name", memberInform.get("name"));
            System.out.println("세션 생성");
            return "/member/myPage";
        }else{
            System.out.println("로그인 실패");
            return "redirect:./";
        }
    }

    // logout
//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logout(HttpSession session) throws Exception {
//        if (session.getAttribute("id") != null) {
//            session.invalidate();
//            return "/member/logout";
//        } else {
//            return "/member/denied";
//        }
//    }

}