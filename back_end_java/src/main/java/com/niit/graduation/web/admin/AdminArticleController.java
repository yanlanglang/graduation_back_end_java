package com.niit.graduation.web.admin;

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
 * @Date 2021/5/4
 * explain:
 */
@Controller
@RequestMapping("/admin")
@CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "*",methods = {})
public class AdminArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/allCustomerArticles")
    @ResponseBody
    public ResultJsonUtils getAllConsumerArticles(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable){
        Page<Article> articles = articleService.listBlogWithCustomer(pageable);

        return ResultJsonUtils.ok("管理员获取分页",articles);
    }

    @GetMapping("/allAdminArticles")
    @ResponseBody
    public ResultJsonUtils getAllAdminArticles(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable){
        Page<Article> articles = articleService.listBlogWithAdmin(pageable);

        return ResultJsonUtils.ok("管理员获取分页",articles);
    }

    @DeleteMapping("/article")
    @ResponseBody
    public ResultJsonUtils delArticle(@RequestParam Long id){

        articleService.deleteArticle(id);

        return ResultJsonUtils.ok("删除成功");
    }

    /**
     * 保存提交的博客内容
     * @param article
     * @param value 分类的id
     * @return
     */
    @PostMapping("/publishArticle")
    public @ResponseBody ResultJsonUtils saveBlog(Article article, @RequestParam int value){

        //blog中有title，description，content

        //调用service层
        boolean b = articleService.addBlog(article, value);
        return ResultJsonUtils.ok("是否保存成功："+b);

    }

    /**
     * 获取博客分类的集合
     */
    @GetMapping("/types")
    public @ResponseBody ResultJsonUtils getTypes(){
        //调用service层并返回
        List<Map<String, Object>> list = typeService.searchAllType();

        return ResultJsonUtils.ok(list);
    }

}
