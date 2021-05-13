package com.niit.graduation.service.serviceImpl;

import com.niit.graduation.entity.Customer;
import com.niit.graduation.entity.Message;
import com.niit.graduation.entity.Notice;
import com.niit.graduation.entity.mapper.Receiver;
import com.niit.graduation.entity.mapper.Sender;
import com.niit.graduation.repository.CustomerRepository;
import com.niit.graduation.repository.MessageRepository;
import com.niit.graduation.repository.NoticeRepository;
import com.niit.graduation.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/10
 * explain:
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public List<Sender> searchReplyMessages(Long id) {
        List<Sender> senders = new ArrayList<>();

        //id作为接收人的id
        List<Message> messages = messageRepository.findMessagesByReceiverId(id);

        //遍历
        for (Message message : messages) {
            Customer one = customerRepository.getOne(message.getSenderId());

            //senders集合添加实例
            senders.add(new Sender(one.getId(), one.getAvatar(), one.getNickname(), message.getContent(), message.getCreateTime()));
        }

        return senders;
    }

    @Override
    public List<Receiver> searchMyMessages(Long id) {
        List<Receiver> receivers = new ArrayList<>();

        //id作为发送人的id
        List<Message> messages = messageRepository.findMessagesBySenderId(id);

        //遍历
        for (Message message : messages) {
            Customer one = customerRepository.getOne(message.getSenderId());

            //senders集合添加实例
            receivers.add(new Receiver(one.getId(), one.getAvatar(), one.getNickname(), message.getContent(), message.getCreateTime()));
        }

        return receivers;
    }

    @Override
    public List<Notice> searchNotices() {
        //按照创建时间排序，由早到晚
        Sort sort = Sort.by(Sort.Direction.ASC, "createTime");

        return noticeRepository.findAll(sort);
    }
}
