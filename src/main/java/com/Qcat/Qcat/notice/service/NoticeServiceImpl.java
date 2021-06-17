package com.Qcat.Qcat.notice.service;

import com.Qcat.Qcat.notice.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeRepository noticeRepository;

    // PAGING
    @Override
    public Double getTotal() {
        return noticeRepository.getTotal();
    }
    @Override
    public List<Map<String, Object>> getNotices(Integer notice_page) {
        return noticeRepository.getNotices(notice_page);
    }

    // SEARCHING
    @Override
    public List<Map<String, Object>> searchNotices(Map<String, String> searchValue) {
        return noticeRepository.searchNotices(searchValue);
    }

    // NOTICE CRUD
    @Override
    public Map<String, Object> getNotice(int notice_id) {
        return noticeRepository.getNotice(notice_id);
    }
    @Override
    public int insertNotice(Map<String, String> insertValue) {
        return noticeRepository.insertNotice(insertValue);
    }
    @Override
    public int updateNotice(Map<String, String> updateValue) {
        return noticeRepository.updateNotice(updateValue);
    }
    @Override
    public int deleteNotice(int notice_id) {
        return noticeRepository.deleteNotice(notice_id);
    }

    // REPLY CRUD
    @Override
    public List<Map<String, Object>> getReply(int reply_id) {
        return noticeRepository.getReply(reply_id);
    }
    @Override
    public int insertReply(Map<String, String> json) {
        return noticeRepository.insertReply(json);
    }
    @Override
    public int updateReply(Map<String, String> json) {
        return noticeRepository.updateReply(json);
    }
    @Override
    public int deleteReply(int reply_id) {
        return noticeRepository.deleteReply(reply_id);
    }

}
