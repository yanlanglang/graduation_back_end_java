package com.niit.graduation.service;

import com.niit.graduation.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author Yan Lang
 * @Date 2020/12/2
 * explain:
 */
public interface ArticleService {

    /**
     * (用户)添加博客
     * @param article
     * @param typeId
     * @param customerId
     * @return
     */
    boolean addBlog(Article article, int typeId, Long customerId);

    /**
     * (管理员)添加博客
     * @param article
     * @param typeId
     * @return
     */
    boolean addBlog(Article article, int typeId);


    /**
     * 关于(customerAndAdmin)blog的分页
     * @param pageable
     * @return
     */
    Page<Article> listBlog(Pageable pageable);

    /**
     * 关于(admin)blog的分页
     * @param pageable
     * @return
     */
    Page<Article> listBlogWithAdmin(Pageable pageable);

    /**
     * 关于(customer)blog的分页
     * @param pageable
     * @return
     */
    Page<Article> listBlogWithCustomer(Pageable pageable);

    /**
     * 查找博客
     * @param id
     * @return
     */
    Article searchBlog(Long id);


    /**
     * 改变点赞数
     * @param flag 0（取消点赞）/1（点赞）
     * @param customerId 用户的id
     * @param blogId 博客的id
     */
    void updateAppreciation(int flag, Long customerId, Long blogId);


    /**
     * 删除文章信息
     * @param articleId
     */
    public void deleteArticle(Long articleId);

}
