package com.niit.graduation.service.serviceImpl;

import com.niit.graduation.entity.Article;
import com.niit.graduation.entity.Comment;
import com.niit.graduation.entity.Customer;
import com.niit.graduation.entity.Type;
import com.niit.graduation.repository.ArticleRepository;
import com.niit.graduation.repository.CommentRepository;
import com.niit.graduation.repository.CustomerRepository;
import com.niit.graduation.repository.TypeRepository;
import com.niit.graduation.service.ArticleService;
import com.niit.graduation.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2020/12/2
 * explain:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository blogRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public boolean addBlog(Article article, int typeId, Long customerId) {

        Article a = setSomeProperties(article, typeId);

        //通过customerId查找customer
        Customer customer = customerRepository.getOne(customerId);
        a.setCustomer(customer);

        try {
            blogRepository.save(a);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean addBlog(Article article, int typeId) {
        Article a = setSomeProperties(article, typeId);

        //保存管理员的信息，这时前端没有传管理员的相关信息
        a.setAdmin(null);

        try {
            blogRepository.save(a);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 初始化相关属性
     * @param article
     * @return
     */
    public Article setSomeProperties(Article article, int typeId){
        article.setContent(MarkdownUtils.markdownToHtmlExtensions(article.getContent()));

        //通过typeId查找type
        Type type = typeRepository.getOne((long) typeId);
        article.setType(type);

        article.setViews(0);
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        return article;
    }



    @Override
    public Page<Article> listBlog(Pageable pageable) {

        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Article> listBlogWithAdmin(Pageable pageable) {
        return blogRepository.findArticlesByCustomerNull(pageable);
    }

    @Override
    public List<Article> listBlogWithAdmin() {
        Sort sort = Sort.by(Sort.Direction.DESC,"createTime");

        /*
            param1:当前查询的页数
            param2:每页查询的数量
            param3:Sort实例
         */
        Pageable pageable = PageRequest.of(0, 5, sort);
        return blogRepository.findTopByCustomerNull(pageable);
    }

    @Override
    public Page<Article> listBlogWithCustomer(Pageable pageable) {
        return blogRepository.findArticlesByCustomerNotNull(pageable);
    }

    @Override
    public List<Article> listBlogWithCustomer() {
        Sort sort = Sort.by(Sort.Direction.DESC,"createTime");

        /*
            param1:当前查询的页数
            param2:每页查询的数量
            param3:Sort实例
         */
        Pageable pageable = PageRequest.of(0, 5, sort);
        return blogRepository.findTopByCustomerNotNull(pageable);
    }

    @Override
    public Article searchBlog(Long id) {
        Article blog = blogRepository.getOne(id);

        //修改该篇文章的查看数
        blogRepository.updateViews(id);

        return blog;

    }

    @Override
    public void updateAppreciation(int flag, Long customerId, Long blogId) {
        //获取当前博客实例
        Article blog = blogRepository.getOne(blogId);
        //存储点赞人的id集合
        List<Long> appreciationNumber = blog.getAppreciationNumber();

        //判断flag为0还是1, 即是向点赞数组中添加还是删除
        if (flag == 0) {
            //取消点赞
            if (appreciationNumber != null) {
                //遍历点赞集合，将当前用户的id从集合中去除
                for (int i = 0; i < appreciationNumber.size(); i++) {
                    if (appreciationNumber.get(i).equals(customerId)) {
                        appreciationNumber.remove(i);
                        break;
                    }
                }

            }
        } else {
            //添加点赞
            appreciationNumber.add(customerId);
        }

        //重新设置点赞人集合
        blog.setAppreciationNumber(appreciationNumber);

    }


    @Override
    public void deleteArticle(Long articleId) {
        // 删除该篇文章下的评论
        //子评论
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        List<Comment> parentCommentNotNull = commentRepository.findCommentsByArticleIdAndParentCommentNotNull(articleId,sort);
        for (Comment comment : parentCommentNotNull) {
            commentRepository.deleteById(comment.getId());
        }

        //父评论
        List<Comment> parentCommentNull = commentRepository.findCommentsByArticleIdAndParentCommentNull(articleId);
        for (Comment comment : parentCommentNull) {
            commentRepository.deleteById(comment.getId());
        }


        blogRepository.deleteById(articleId);
    }

}
