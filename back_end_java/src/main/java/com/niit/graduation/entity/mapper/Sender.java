package com.niit.graduation.entity.mapper;

import java.util.Date;

/**
 * @Author Yan Lang
 * @Date 2021/5/10
 * explain: 映射类 - 消息中心 - 回复我的 - 发送者
 */
public class Sender {

    private Long id;

    private String avatar;

    private String nickname;

    private String content;

    private Date createTime;

    public Sender() {
    }

    public Sender(Long id, String avatar, String nickname, String content, Date createTime) {
        this.id = id;
        this.avatar = avatar;
        this.nickname = nickname;
        this.content = content;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
