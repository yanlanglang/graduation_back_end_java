package com.niit.graduation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2020/11/12
 * explain: 评论实体类
 */
@Entity
@Table(name = "t_comment")
public class Comment {

    /**
     * 主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 评论人的id
     */
    private Long customerId;

    /**
     * 内容
     */
    private String content;


    /**
     * 头像(图片)的地址
     */
    private String avatar;

    /**
     * 生成时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * 是否是作者的评论
     */
    private boolean isAuthorComment;


    /**
     * 多的一端是维护端,一的一端是被维护端
     */
    @ManyToOne
    @JsonIgnore
    private Article article;

    /**
     * 子级评论
     * 以下两个是内部关联关系
     */

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();

    /**
     * 父级评论
     */
    @JsonIgnore
    @ManyToOne
    private Comment parentComment;

    /**
     * 是否是管理员
     */
    private boolean adminComment;

    public Comment() {
    }

    public Comment(Long id, String nickname, Long customerId, String content, String avatar, Date createTime, boolean isAuthorComment, Article article, List<Comment> replyComments, Comment parentComment, boolean adminComment) {
        this.id = id;
        this.nickname = nickname;
        this.customerId = customerId;
        this.content = content;
        this.avatar = avatar;
        this.createTime = createTime;
        this.isAuthorComment = isAuthorComment;
        this.article = article;
        this.replyComments = replyComments;
        this.parentComment = parentComment;
        this.adminComment = adminComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public boolean isAuthorComment() {
        return isAuthorComment;
    }

    public void setAuthorComment(boolean authorComment) {
        isAuthorComment = authorComment;
    }

    public boolean isAdminComment() {
        return adminComment;
    }

    public void setAdminComment(boolean adminComment) {
        this.adminComment = adminComment;
    }
}
