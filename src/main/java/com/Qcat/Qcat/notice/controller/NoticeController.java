package com.Qcat.Qcat.notice.controller;

import com.Qcat.Qcat.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    // PAGING
    @GetMapping(value = {"/notice/{notice_page", "/notice"})
    public String getNotices(@PathVariable(required = false) Integer notice_page, Model model) {

        Double total = noticeService.getTotal();
        System.out.println(total);
        int totalPage = (int) Math.ceil(total / 20);

        if (notice_page != null) {
            model.addAttribute("notices", noticeService.getNotices((notice_page - 1) * 10 * 2));
            model.addAttribute("totalPage", totalPage);
        } else {
            notice_page = 1;
            model.addAttribute("notices", noticeService.getNotices((notice_page - 1) * 10 * 2));
            model.addAttribute("totalPage", totalPage);
        }
        return "/notice/notice";
    }

    // CRUD
    @GetMapping("/notice/detail/{notice_id}")
    public String getDetail(@PathVariable("notice_id") int notice_id, Model model) {

        model.addAttribute("notice", noticeService.getNotice(notice_id));
        return "/notice/noticeDetail";
    }

    @GetMapping("/notice/insert")
    public String insertGET(HttpServletRequest request) {

        HttpSession httpsession = request.getSession();

        if ((int) httpsession.getAttribute("role") != 0) {
            String referer = request.getHeader("Referer");
            return "redirect: " + referer;
        }
        return "/notice/insert";
    }

    @PostMapping("/notice/insert")
    public String insertPOST(@RequestParam Map<String, String> insertValue) {

        noticeService.insertNotice(insertValue);
        return "redirect:/notice";
    }

    @GetMapping("/notice/update/{notice_id}")
    public String updateGET(@PathVariable("notice_id") int notice_id, Model model) {

        model.addAttribute("notice", noticeService.getNotice(notice_id));
        return "/notice/noticeUpdate";
    }

    @PostMapping("/notice/update")
    public String updatePOST(@RequestParam Map<String, String> updateValue) {

        noticeService.updateNotice(updateValue);
        return "redirect:/notice";
    }

}
