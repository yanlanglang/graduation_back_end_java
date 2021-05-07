package com.niit.graduation.web.customer;

import com.niit.graduation.entity.Comment;
import com.niit.graduation.service.CommentService;
import com.niit.graduation.util.ResultJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/5
 * explain:
 */
@Controller
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/saveParentReply")
    @ResponseBody
    public ResultJsonUtils saveParentComment(Comment comment, @RequestParam Long articleId) {

        //保存
        commentService.saveComment(comment, articleId);

        return ResultJsonUtils.ok("保存父节点评论");
    }

    @GetMapping("/saveChildrenReply")
    @ResponseBody
    public ResultJsonUtils saveParentComment(Comment comment, @RequestParam Long articleId, @RequestParam Long commentId) {

        //保存
        commentService.saveComment(comment, articleId, commentId);

        return ResultJsonUtils.ok(comment);
    }


    @GetMapping("/search")
    @ResponseBody
    public ResultJsonUtils search(@RequestParam Long articleId) {
        //所有父节点的评论
        List<Comment> comments = commentService.searchComment(articleId);


        return ResultJsonUtils.ok(comments);
    }


}
