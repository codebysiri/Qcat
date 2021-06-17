package com.Qcat.Qcat.member.controller;

import com.Qcat.Qcat.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MyPageController {

    private final MemberService memberService;

    @Autowired
    public MyPageController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/myPage")
    public String myPage(HttpSession httpSession, Model model) throws Exception {

        if (httpSession.getAttribute("member_id") != null) {
            int member_id = (int) httpSession.getAttribute("member_id");
            List<Map<String, Object>> storeList = memberService.storeList(member_id);
            model.addAttribute("storeList", storeList);
            return "/member/myPage";
        } else {
            return "redirect:/member/login";
        }

    }


}
