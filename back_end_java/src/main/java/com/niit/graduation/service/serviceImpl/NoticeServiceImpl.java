package com.niit.graduation.service.serviceImpl;

import com.niit.graduation.entity.Notice;
import com.niit.graduation.repository.NoticeRepository;
import com.niit.graduation.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/9
 * explain:
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public void addNotice(String content) {
        Notice notice = new Notice(null, content, new Date());
        noticeRepository.save(notice);
    }

    @Override
    public List<Notice> searchNotices() {
        Sort sort = Sort.by(Sort.Direction.DESC,"createTime");
        return noticeRepository.findAll(sort);
    }

    @Override
    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }
}
