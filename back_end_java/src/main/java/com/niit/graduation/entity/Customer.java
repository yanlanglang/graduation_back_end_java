package com.niit.graduation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2020/11/12
 * explain: 用户实体类
 */
@Entity
@Table(name = "t_customer")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Customer {

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
     * 性别
     */
    private String gender;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 电子邮箱
     */
    private String mail;

    /**
     * 文章
     */
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Article> articles;

    /**
     * 收藏的文章(保存文章的id)
     */
    @Transient
    @JsonIgnore
    private List<Long> articleIds;

    /**
     * 创建时间
     */
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public Customer() {
    }


    public List<Long> getBlogIds() {
        return articleIds;
    }

    public void setBlogIds(List<Long> articleIds) {
        this.articleIds = articleIds;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", nickname='" + nickname + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
