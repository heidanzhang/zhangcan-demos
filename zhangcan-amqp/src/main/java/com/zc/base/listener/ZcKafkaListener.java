package com.zc.base.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

/**
 * @Auther: zhangcan
 * @Date: 2019/2/21 18:27
 * @Description:
 */
@Component
@EnableScheduling
public class ZcKafkaListener {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = "efence_warning_topics")
    public void processMessage(String content) {
        System.out.println("收到消息======"+content);
    }

    /**
     * 定时任务
     */
    //@Scheduled(cron = "00/1 * * * * ?")
    public void send() throws InterruptedException {
        System.out.println("开始定时任务");
        Thread.sleep(2000L);
        String message =UUID.randomUUID().toString();
        ListenableFuture future = kafkaTemplate.send("efence_warning_topics", message);
        future.addCallback(o -> System.out.println("send-消息发送成功：" + message), throwable -> System.out.println("消息发送失败：" + message));
    }

}
