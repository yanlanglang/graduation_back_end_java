package com.niit.graduation.repository;

import com.niit.graduation.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @Author Yan Lang
 * @Date 2020/12/2
 * explain:
 */
public interface ArticleRepository extends JpaRepository<Article,Long> {


    @Transactional
    @Modifying
    @Query("update Article a set a.views = a.views+1 where a.id = ?1")
    int updateViews(Long id);


    /**
     * 查找customer的文章
     * @param pageable
     * @return
     */
    Page<Article> findArticlesByCustomerNotNull(Pageable pageable);


    /**
     * 查找admin的文章
     * @param pageable
     * @return
     */
    Page<Article> findArticlesByCustomerNull(Pageable pageable);

}
