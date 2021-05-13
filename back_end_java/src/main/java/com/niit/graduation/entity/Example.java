package com.niit.graduation.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Yan Lang
 * @Date 2021/5/8
 * explain:
 */
@Entity
@Table(name = "t_example")
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 内容
     */
    private String content;

    /**
     * true：blockly
     * false：johnnyFive
     */
    private Boolean isBlockly;

    /**
     * 文件的映射路径
     */
    private String fileMapPath;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public Example() {
    }

    public Example(Long id, String content, Boolean isBlockly, String fileMapPath, Date createTime) {
        this.id = id;
        this.content = content;
        this.isBlockly = isBlockly;
        this.fileMapPath = fileMapPath;
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

    public Boolean getBlockly() {
        return isBlockly;
    }

    public void setBlockly(Boolean blockly) {
        isBlockly = blockly;
    }

    public String getFileMapPath() {
        return fileMapPath;
    }

    public void setFileMapPath(String fileMapPath) {
        this.fileMapPath = fileMapPath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
