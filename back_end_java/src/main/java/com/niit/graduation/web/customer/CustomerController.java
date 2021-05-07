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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Author Yan Lang
 * @Date 2021/4/26
 * explain:
 */
@Controller
@RequestMapping("/customer")
@CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "*",methods = {})
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/editInfo")
    @ResponseBody
    public ResultJsonUtils editInfo(MultipartFile file,
                                    Customer customer){

        //判断是否上传图片
        if (file.isEmpty()) {
            //即没有修改头像
            return ResultJsonUtils.error("文件为空");

        } else {
            //文件名
            String fileName = customer.getId()+"_"+ MathRandomUtils.getRandom(0)+".jpg";

            //图片路径(映射后的)
            String mapAvatar = PathUtils.getMapAvatarPath(fileName);


            //生成文件(实际路径)
            File dest = new File(PathUtils.getAvatarPath(fileName));
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //设置映射路径
            customer.setAvatar(mapAvatar);
            customer.setUpdateTime(new Date());

            Customer c = customerService.editCustomer(customer);

            return ResultJsonUtils.ok("修改个人信息", c);
        }


    }


}
