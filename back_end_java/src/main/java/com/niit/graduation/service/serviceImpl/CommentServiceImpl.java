package com.niit.graduation.service.serviceImpl;

import com.niit.graduation.entity.Article;
import com.niit.graduation.entity.Comment;
import com.niit.graduation.entity.Customer;
import com.niit.graduation.repository.ArticleRepository;
import com.niit.graduation.repository.CommentRepository;
import com.niit.graduation.repository.CustomerRepository;
import com.niit.graduation.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/5
 * explain:
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void saveComment(Comment comment , Long articleId) {

        //通过comment中的consumerId获取avatar、nickname
        Customer c = customerRepository.getOne(comment.getCustomerId());


        Article article = articleRepository.getOne(articleId);

        comment.setAvatar(c.getAvatar());
        comment.setNickname(c.getNickname());
        comment.setArticle(article);
        comment.setParentComment(null);
        comment.setCreateTime(new Date());

        commentRepository.save(comment);
    }

    @Override
    public void saveComment(Comment comment, Long articleId, Long commentId) {

        //通过comment中的consumerId获取avatar、nickname
        Customer c = customerRepository.getOne(comment.getCustomerId());

        Comment parentComment = commentRepository.getOne(commentId);
        Article article = articleRepository.getOne(articleId);

        comment.setAvatar(c.getAvatar());
        comment.setNickname(c.getNickname());
        comment.setArticle(article);
        comment.setCreateTime(new Date());
        comment.setParentComment(parentComment);
        commentRepository.save(comment);

    }

    @Override
    public List<Comment> searchComment(Long articleId) {

        //一篇文章中所有处于根节点的父评论
        List<Comment> parentComments = commentRepository.findCommentsByArticleIdAndParentCommentNull(articleId);

        //父评论及其子评论
        return parentComments;
    }

}
