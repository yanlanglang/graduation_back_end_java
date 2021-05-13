package com.niit.graduation.service;

import com.niit.graduation.entity.Notice;
import com.niit.graduation.entity.mapper.Receiver;
import com.niit.graduation.entity.mapper.Sender;

import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/10
 * explain:
 */
public interface MessageService {

    /**
     * id对应的customer为收件人
     * @param id
     * @return
     */
    List<Sender> searchReplyMessages(Long id);

    /**
     * id对应的customer为发送人
     * @param id "我"的id
     * @return
     */
    List<Receiver> searchMyMessages(Long id);

    /**
     * 获取系统公告
     * @return
     */
    List<Notice> searchNotices();

}
