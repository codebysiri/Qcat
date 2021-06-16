package com.Qcat.Qcat.notice;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl {

    NoticeRepository noticeRepository;

    // PAGING
    public Double getTotal() {
        return noticeRepository.getTotal();
    }
    public List<Map<String, Object>> getNotices(Integer notice_page) {
        return noticeRepository.getNotices(notice_page);
    }

    // SEARCHING
    public List<Map<String, Object>> searchNotices(Map<String, String> searchValue) {
        return noticeRepository.searchNotices(searchValue);
    }

    // NOTICE CRUD
    public Map<String, Object> getNotice(int notice_id) {
        return noticeRepository.getNotice(notice_id);
    }
    int insertNotice(Map<String, String> insertValue) {
        return noticeRepository.insertNotice(insertValue);
    }
    int updateNotice(Map<String, String> updateValue) {
        return noticeRepository.updateNotice(updateValue);
    }
    int deleteNotice(int notice_id) {
        return noticeRepository.deleteNotice(notice_id);
    }

    // REPLY CRUD
    public List<Map<String, Object>> getReply(int reply_id) {
        return noticeRepository.getReply(reply_id);
    }
    int insertReply(Map<String, String> json) {
        return noticeRepository.insertReply(json);
    }
    int updateReply(Map<String, String> json) {
        return noticeRepository.updateReply(json);
    };
    int deleteReply(int reply_id) {
        return noticeRepository.deleteReply(reply_id);
    };

}
