package com.niit.graduation.web.customer;

import com.niit.graduation.entity.Notice;
import com.niit.graduation.entity.mapper.Receiver;
import com.niit.graduation.entity.mapper.Sender;
import com.niit.graduation.service.MessageService;
import com.niit.graduation.util.ResultJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/10
 * explain:
 */
@Controller
@RequestMapping("/message")
@CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "*",methods = {})
public class MessageController {

    @Autowired
    private MessageService messageService;


    /**
     * 获取"回复我的"的相关信息
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/replyMeMessages")
    public ResultJsonUtils getReplyMessages(@RequestParam Long id){
        //
        List<Sender> senders = messageService.searchReplyMessages(id);

        return ResultJsonUtils.ok(senders);
    }

    /**
     * 获取"我的消息"的相关信息
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/myMessages")
    public ResultJsonUtils getMyMessages(@RequestParam Long id){
        //
        List<Receiver> receivers = messageService.searchMyMessages(id);

        return ResultJsonUtils.ok(receivers);
    }

    /**
     * 获取"系统公告"的相关信息
     * @return
     */
    @ResponseBody
    @GetMapping("/systemNotices")
    public ResultJsonUtils getSystemNotices(){
        //
        List<Notice> notices = messageService.searchNotices();

        return ResultJsonUtils.ok(notices);
    }

}
