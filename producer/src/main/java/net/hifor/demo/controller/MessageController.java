package net.hifor.demo.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author IKin <br/>
 * @description 发布消息  <br/>
 * @date 2023/11/17 <br/>
 */
@RestController
public class MessageController {

    @Value("${var.mq.topic}")
    private String topic;

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发布消息
     * @param message
     * @return
     */
    @PostMapping("/publish")
    public String publishMessage(@RequestBody String message) {
        System.out.println("HTTP RequestBody: " + message);
        // 发布消息到名为 topicTest 的主题
        // 这里仅做演示用，生产环境避免直接把用户端接收的不安全数据发布到消息队列
        rocketMQTemplate.convertAndSend(topic, message);
        return "Message published";
    }
}
