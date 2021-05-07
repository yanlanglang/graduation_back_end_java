package com.niit.graduation.web.customer;

import com.niit.graduation.entity.Article;
import com.niit.graduation.service.ArticleService;
import com.niit.graduation.service.TypeService;
import com.niit.graduation.util.ResultJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author Yan Lang
 * @Date 2020/12/2
 * explain:
 */
@Controller
@CrossOrigin(allowCredentials ="true")//设置是否允许客户端发送cookie信息。默认是false
@RequestMapping("/blog")
public class ArticleController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private ArticleService articleService;


    //获取博客分类的集合
    @PostMapping("/types")
    public @ResponseBody List<Map<String,Object>> getTypes(){
        //调用service层并返回
        return typeService.searchAllType();
    }


    /**
     * 保存提交的博客内容
     * @param article
     * @param value 分类的id
     * @param customerId
     * @return
     */
    @PostMapping("/save")
    public @ResponseBody boolean saveBlog(Article article, @RequestParam int value, @RequestParam Long customerId){

        //blog中有title，description，content

        //调用service层
        return articleService.addBlog(article, value, customerId);

    }

    /**
     * 获取所有博客的分页
     * @param pageable
     * @return
     */
    @RequestMapping("/blogs")
    @ResponseBody
    public ResultJsonUtils getBlogPage(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable){

        //调用service层
        Page<Article> articles = articleService.listBlog(pageable);

        return ResultJsonUtils.ok("获取分页!",articles);
    }


    /**
     * 获取指定的一篇博客内容
     * @param id
     * @return
     */
    @GetMapping("/one")
    public @ResponseBody
    Article getBlog(Long id){
        //调用service层
        return articleService.searchBlog(id);

    }


    /**
     * 改变点赞
     * @param flag
     * @param customerId 用户的id
     * @param blogId  博客的id
     */
    @GetMapping("/thumb")
    public @ResponseBody void changeAppreciation(@RequestParam int flag,
                                                 @RequestParam Long customerId,
                                                 @RequestParam Long blogId){

        //调用service层

    }




}
