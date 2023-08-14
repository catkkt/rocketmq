package com.example.demoproducer.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@RestController
@Slf4j
public class ProducerController {

    @Resource
    private DefaultMQProducer producer;



    @RequestMapping("/testBatchSend")
    public  String testBatchSend() {

        ArrayList<Message> messages = new ArrayList<>();
        for(int i=0;i<5;i++){
            messages.add(new Message(ProducerConfiguration.topic,("message" + i).getBytes(StandardCharsets.UTF_8)));
        }

        try {
            producer.send(messages);
            log.info("success!!");
            return "success.";
        } catch (Exception e) {
            log.error("fail " + e);
        }

        return "fail.";
    }
}
