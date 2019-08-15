package com.guidedchoice.demostream.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(EvenOddProcessor.class)
public class FindEvenOrOD {

    @Autowired
    private EvenOddProcessor processor;

    @StreamListener(value = EvenOddProcessor.INPUT)
    public void processEven(Integer r) {
        Message<Integer> message = MessageBuilder

                .withPayload(r)
                .setHeader("type", findType(r))
                .setHeader(KafkaHeaders.MESSAGE_KEY, findType(r).getBytes())
                .build();
        this.processor.output().send(message);
    }


    @StreamListener(value = EvenOddProcessor.INPUT1)
    public void process(Integer r) {
        Message<Integer> message = MessageBuilder

                .withPayload(r)
                .setHeader("type", findType(r))
                .setHeader(KafkaHeaders.MESSAGE_KEY, findType(r).getBytes())
                .build();
        processor.output().send(message);
        processor.output1().send(message);
    }


    private String findType(int r) {
        if (r % 2 == 0)
            return "even";
        return "odd";
    }
}
