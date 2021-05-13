package com.niit.graduation.repository;

import com.niit.graduation.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/10
 * explain:
 */
public interface MessageRepository extends JpaRepository<Message, Long> {

    /**
     * 通过id查找全部信息
     * @param id 收件人的id
     * @return
     */
    @Query("select m from Message m where m.receiverId = ?1")
    List<Message> findMessagesByReceiverId(Long id);

    /**
     * 通过id查找全部信息
     * @param id 发送人的id
     * @return
     */
    @Query("select m from Message m where m.senderId = ?1")
    List<Message> findMessagesBySenderId(Long id);

}
