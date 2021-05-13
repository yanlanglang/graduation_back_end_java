package com.niit.graduation.web.customer;

import com.niit.graduation.entity.Article;
import com.niit.graduation.entity.Example;
import com.niit.graduation.service.ArticleService;
import com.niit.graduation.service.ExampleService;
import com.niit.graduation.util.ResultJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/10
 * explain:
 */
@Controller
@CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "*",methods = {})
public class RouterController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ExampleService exampleService;

    @GetMapping("/blocklyExamples")
    @ResponseBody
    public ResultJsonUtils getBlocklyExamples(){
        List<Example> examples = exampleService.searchBlocklyExamples();
        return ResultJsonUtils.ok("blockly的最新案例",examples);
    }

    @GetMapping("/j5Examples")
    @ResponseBody
    public ResultJsonUtils getJ5Examples(){
        List<Example> examples = exampleService.searchJ5Examples();
        return ResultJsonUtils.ok("j5的最新案例",examples);
    }

    @GetMapping("/customerArticles")
    @ResponseBody
    public ResultJsonUtils getCustomerArticles() {
        List<Article> articles = articleService.listBlogWithCustomer();
        return ResultJsonUtils.ok(articles);
    }

    @GetMapping("/adminArticles")
    @ResponseBody
    public ResultJsonUtils getAdminArticles() {
        List<Article> articles = articleService.listBlogWithAdmin();
        return ResultJsonUtils.ok(articles);
    }

    @GetMapping("/examples")
    @ResponseBody
    public ResultJsonUtils getExamples() {
        List<Example> examples = exampleService.searchExamples();
        return ResultJsonUtils.ok(examples);
    }


}
