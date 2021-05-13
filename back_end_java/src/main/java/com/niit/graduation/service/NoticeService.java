package com.niit.graduation.service;

import com.niit.graduation.entity.Notice;

import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/9
 * explain:
 */
public interface NoticeService {

    /**
     * 添加一条公示
     * @param content
     */
    void addNotice(String content);

    /**
     * 获取所有公示
     * @return
     */
    List<Notice> searchNotices();

    /**
     * 删除指定公示
     * @param id
     */
    void deleteNotice(Long id);

}
