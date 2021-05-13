package com.niit.graduation.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Yan Lang
 * @Date 2021/5/8
 * explain:
 */
@Entity
@Table(name = "t_notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;


    public Notice() {
    }

    public Notice(Long id, String content, Date createTime) {
        this.id = id;
        this.content = content;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
