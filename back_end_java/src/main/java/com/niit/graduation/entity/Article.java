package com.niit.graduation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2020/11/12
 * explain: 文章实体类
 */
@Entity
@Table(name = "t_article")
public class Article {

    /**
     * 主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 简介
     */
    private String description;

    /**
     * 分类
     */
    @ManyToOne
    private Type type;

    /**
     * 内容
     * FetchType.LAZY:懒加载，实例化对象时不加载该属性，只有当调用该属性时才加载
     * Lob:大字段，使数据库中该字段的限长变大
     */
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String content;

    /**
     * 浏览次数
     */
    private Integer views;

    /**
     * 收藏次数(List<long> 存储用户的id)
     * 不会进入数据库
     */
    @Transient
    private List<Long> focusNumber;

    /**
     * 点赞次数(List<long> 存储用户的id)
     * 不会进入数据库
     */
    @Transient
    private List<Long> appreciationNumber;

    /**
     * 评论
     * 多的一端是维护端,一的一端是被维护端
     */
    @OneToMany(mappedBy = "article")
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();

    /**
     * 用户
     */
    @ManyToOne
    private Customer customer;

    /**
     * 管理员
     */
    @ManyToOne
    private Admin admin;

    /**
     * 创建时间
     * Timestamp:数据库中的存在方式
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;


    public Article() {
    }

    public Article(Long id, String title, String description, Type type, String content, Integer views, List<Long> focusNumber, List<Long> appreciationNumber, List<Comment> comments, Customer customer, Admin admin, Date createTime, Date updateTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.content = content;
        this.views = views;
        this.focusNumber = focusNumber;
        this.appreciationNumber = appreciationNumber;
        this.comments = comments;
        this.customer = customer;
        this.admin = admin;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public List<Long> getFocusNumber() {
        return focusNumber;
    }

    public void setFocusNumber(List<Long> focusNumber) {
        this.focusNumber = focusNumber;
    }

    public List<Long> getAppreciationNumber() {
        return appreciationNumber;
    }

    public void setAppreciationNumber(List<Long> appreciationNumber) {
        this.appreciationNumber = appreciationNumber;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
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
