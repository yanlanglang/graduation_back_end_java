package com.niit.graduation.repository;

import com.niit.graduation.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Yan Lang
 * @Date 2021/5/9
 * explain:
 */
public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
