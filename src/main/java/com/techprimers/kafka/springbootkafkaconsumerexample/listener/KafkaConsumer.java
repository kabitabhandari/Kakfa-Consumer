package com.techprimers.kafka.springbootkafkaconsumerexample.listener;

import com.techprimers.kafka.springbootkafkaconsumerexample.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "Kafka_Message", group = "group_id")
    public void consumeString(String message) {
        System.out.println("Consumed message: " + message);
    }


    @KafkaListener(topics = "kafka_topic_json", group = "group_json",   // should be same in producer and consumer
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
        System.out.println(">>> department is " + user.getDept());
        System.out.println(">>> salary is " + user.getSalary());
        System.out.println(">>> name is " + user.getName());
    }
}
