package com.rocketMq;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 消费消息监听类处理
 */
public class MessageListenerImpl implements MessageListenerConcurrently {
    private static final Logger logger = LoggerFactory.getLogger(MessageListenerImpl.class);

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        logger.info(Thread.currentThread().getName()+"receive message : "+list.size()+"; msg: "+list);
        for (MessageExt messageExt : list){
            try {
                System.out.println("msg content: "+new String(messageExt.getBody(),"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
