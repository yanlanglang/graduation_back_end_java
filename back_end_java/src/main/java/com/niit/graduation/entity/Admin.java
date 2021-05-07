package com.niit.graduation.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2020/11/12
 * explain: 管理员实体类
 */
@Entity
@Table(name = "t_admin")
public class Admin {

    /**
     * 主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 用户名(账号)
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 电子邮箱
     */
    private String mail;

    /**
     * 文章
     */
    @OneToMany(mappedBy = "admin")
    private List<Article> articles;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public Admin() {
    }

    public Admin(Long id, String avatar, String username, String nickname, String password, String mail, List<Article> articles, Date createTime, Date updateTime) {
        this.id = id;
        this.avatar = avatar;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.mail = mail;
        this.articles = articles;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
