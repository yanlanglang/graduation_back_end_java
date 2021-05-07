package com.niit.graduation.web.customer;

import com.niit.graduation.entity.Customer;
import com.niit.graduation.service.CustomerService;
import com.niit.graduation.util.MathRandomUtils;
import com.niit.graduation.util.PathUtils;
import com.niit.graduation.util.ResultJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Author Yan Lang
 * @Date 2021/4/26
 * explain:
 */
@Controller
@RequestMapping("/customer")
@CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "*",methods = {})
public class SignController {

    private final static String DEFAULT_AVATAR_FILENAME = "avatar.jpg";

    @Autowired
    private CustomerService customerService;

    /**
     * customer实例中有username，password,mail
     * @param customer
     * @return
     */
    @PostMapping("/signUp")
    @ResponseBody
    public ResultJsonUtils submitUpForm(Customer customer){
        customer.setGender("男");
        customer.setAvatar(PathUtils.getMapAvatarPath(DEFAULT_AVATAR_FILENAME));
        customer.setCreateTime(new Date());
        customer.setNickname(MathRandomUtils.getRandom(10));

        boolean b = customerService.insertCustomer(customer);
        if (b){
            return ResultJsonUtils.ok("注册账号");
        }else {
            return ResultJsonUtils.error("账号已经被注册");
        }

    }

    @PostMapping("signIn")
    @ResponseBody
    public ResultJsonUtils submitInForm(Customer customer){
        Customer c = customerService.searchCustomer(customer);
        if (c==null){
            return ResultJsonUtils.error("账号或密码错误");
        }
        return ResultJsonUtils.ok("登录账号",c);
    }

}
