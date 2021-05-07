package com.niit.graduation.repository;

import com.niit.graduation.entity.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/5
 * explain:
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    /**
     * 找到parentCommentId为null的顶级节点
     * @param articleId
     * @return
     */
    List<Comment> findCommentsByArticleIdAndParentCommentNull(Long articleId);

    /**
     * 查找父评论
     * @param customerId
     * @return
     */
    Comment findCommentByCustomerId(Long customerId);

    /**
     * 查找一篇文章的子评论
     * @param articleId
     * @param sort
     * @return
     */
    List<Comment> findCommentsByArticleIdAndParentCommentNotNull(Long articleId, Sort sort);

}
