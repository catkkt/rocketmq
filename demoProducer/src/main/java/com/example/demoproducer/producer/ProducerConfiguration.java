package com.example.demoproducer.producer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rocketmq.producer")
public class ProducerConfiguration {

    public static String topic;
    public static String namersrvAddr;
    public static String groupName;
    public static int sendMessageTimeout;
    public static int retryTimesWhenSendFailed;

    public void setTopic(String topic) {
        ProducerConfiguration.topic = topic;
    }

    public void setNamersrvAddr(String namersrvAddr) {
        ProducerConfiguration.namersrvAddr = namersrvAddr;
    }

    public void setGroupName(String groupName) {
        ProducerConfiguration.groupName = groupName;
    }

    public void setSendMessageTimeout(int sendMessageTimeout) {
        ProducerConfiguration.sendMessageTimeout = sendMessageTimeout;
    }

    public void setRetryTimesWhenSendFailed(int retryTimesWhenSendFailed) {
        ProducerConfiguration.retryTimesWhenSendFailed = retryTimesWhenSendFailed;
    }


}
