package com.xiaobobo.crowdfunding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobobo.crowdfunding.dao.MessageMapper;
import org.springframework.stereotype.Service;
import com.xiaobobo.crowdfunding.entity.Message;
import com.xiaobobo.crowdfunding.service.MessageService;


@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {


}