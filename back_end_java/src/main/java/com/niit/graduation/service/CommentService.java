package com.niit.graduation.service;

import com.niit.graduation.entity.Comment;

import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/5
 * explain:
 */
public interface CommentService {

    /**
     * 作为父节点的评论保存
     * @param comment
     * @param articleId
     */
    void saveComment(Comment comment, Long articleId);

    /**
     * 作为子节点的评论保存
     * @param comment
     * @param articleId
     * @param commentId
     */
    void saveComment(Comment comment, Long articleId, Long commentId);

    /**
     * 指定文章的评论
     * @param articleId
     * @return
     */
    List<Comment> searchComment(Long articleId);

}
