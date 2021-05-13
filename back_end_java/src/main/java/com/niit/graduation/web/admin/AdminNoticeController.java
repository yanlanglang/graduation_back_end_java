package com.niit.graduation.web.admin;

import com.niit.graduation.entity.Notice;
import com.niit.graduation.service.NoticeService;
import com.niit.graduation.util.ResultJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/4
 * explain:
 */
@Controller
@RequestMapping("/admin")
@CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "*",methods = {})
public class AdminNoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 保存公示
     * @param content
     * @return
     */
    @PostMapping("/publishNotice")
    @ResponseBody
    public ResultJsonUtils saveNotice(@RequestParam String content){
        noticeService.addNotice(content);

        System.out.println(content);

        return ResultJsonUtils.ok("保存公示成功！");
    }

    /**
     * 获取公示的集合
     * @return
     */
    @GetMapping("/notices")
    @ResponseBody
    public ResultJsonUtils getNotices(){

        List<Notice> notices = noticeService.searchNotices();

        return ResultJsonUtils.ok("获取案例集合", notices);
    }

    /**
     * 删除公示
     * @param id
     * @return
     */
    @DeleteMapping("/notice")
    @ResponseBody
    public ResultJsonUtils delNotice(@RequestParam Long id){

        noticeService.deleteNotice(id);

        return ResultJsonUtils.ok("删除公告成功！");
    }


}
