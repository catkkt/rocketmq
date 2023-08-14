package com.example.demoproducer.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProducerConfig {

    @Bean
    public DefaultMQProducer defaultMQProducer() throws MQClientException {

        log.info("DefaultMQProducer start tp create.");
        DefaultMQProducer producer = new DefaultMQProducer(ProducerConfiguration.groupName);
        producer.setCreateTopicKey(ProducerConfiguration.topic);
        producer.setNamesrvAddr(ProducerConfiguration.namersrvAddr);
        producer.setVipChannelEnabled(false);
        producer.setSendMsgTimeout(ProducerConfiguration.sendMessageTimeout);
        producer.setRetryTimesWhenSendFailed(ProducerConfiguration.retryTimesWhenSendFailed);
        producer.start();
        log.info("success.");
        return producer;
    }
}
