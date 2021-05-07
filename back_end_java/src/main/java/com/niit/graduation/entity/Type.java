package com.niit.graduation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2020/12/2
 * explain:
 */
@Entity
@Table(name = "t_type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "type")
    @JsonIgnore
    private List<Article> articles;

    public Type() {
    }

    public Type(Long id, String name, List<Article> articles) {
        this.id = id;
        this.name = name;
        this.articles = articles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
