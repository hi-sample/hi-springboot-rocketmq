package net.hifor.demo.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * <p> 消息消费者 </p>
 *
 * @author IKin <br/>
 * @date 2023/12/4 <br/>
 */
@Component
@RocketMQMessageListener(topic = "${var.mq.topic}", consumerGroup = "${var.mq.group}")
public class MessageConsumer implements RocketMQListener<String> {
    /**
     * 监听消息
     * @param message
     */
    @Override
    public void onMessage(String message) {
        System.out.println("Received message: " + message);
        // 处理接收到的消息逻辑......
    }
}
