package com.zc.base.listener;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhangcan
 * @Date: 2019/5/30 14:39
 * @Description:
 */
@Slf4j
@Component
@RabbitListener(queues = "terminal_file_queue")
public class TerminalFileQueue {


/*    @RabbitHandler
    public void receive(Map<String,Object> terminalFileDTO, Message message, Channel channel) throws IOException {
        try {
            log.info("netty上传文件开始");
            log.info("netty上传文件="+ JSON.toJSON(terminalFileDTO).toString());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }catch (Exception e){
            e.printStackTrace();
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
        }
    }*/
    @RabbitHandler
    public void receive(Message message, Channel channel) throws IOException {
        try {
            log.info("netty上传文件开始");
            HashMap<String,Object> maps =(HashMap<String, Object>) SerializationUtils.deserialize(message.getBody());
            log.info("netty上传文件="+ JSON.toJSON(maps).toString());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }catch (Exception e){
            e.printStackTrace();
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
        }
    }

}
