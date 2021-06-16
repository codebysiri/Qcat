package com.Qcat.Qcat.notice;

import java.util.List;
import java.util.Map;

public interface NoticeService {

    // PAGING
    Double getTotal();
    List<Map<String, Object>> getNotices(Integer notice_page);

    // SEARCHING
    List<Map<String, Object>> searchNotices(Map<String, String> searchValue);

    // NOTICE CRUD
    Map<String, Object> getNotice(int notice_id);
    int insertNotice(Map<String, String> insertValue);
    int updateNotice(Map<String, String> updateValue);
    int deleteNotice(int notice_id);

    // REPLY CRUD
    List<Map<String, Object>> getReply(int reply_id);
    int insertReply(Map<String, String> json);
    int updateReply(Map<String, String> json);
    int deleteReply(int reply_id);
}
