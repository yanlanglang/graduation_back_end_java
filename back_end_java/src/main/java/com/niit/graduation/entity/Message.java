package com.niit.graduation.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Yan Lang
 * @Date 2021/5/10
 * explain:
 */
@Entity
@Table(name = "t_message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long receiverId;

    private Long senderId;

    private String content;

    /**
     * 创建时间
     * Timestamp:数据库中的存在方式
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public Message() {
    }

    public Message(Long id, Long receiverId, Long senderId, String content, Date createTime) {
        this.id = id;
        this.receiverId = receiverId;
        this.senderId = senderId;
        this.content = content;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
