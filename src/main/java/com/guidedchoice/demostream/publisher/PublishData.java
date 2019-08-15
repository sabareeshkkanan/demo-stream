package com.guidedchoice.demostream.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@EnableBinding(Source.class)
public class PublishData {

    private Random random = new Random(10000);

    @Autowired
    private Source source;

    //  @Scheduled(fixedRate = ONE_SECOND)
    public void send() {
        int r = random.nextInt(1000);

        Message<Integer> message = MessageBuilder

                .withPayload(r)
                .setHeader(KafkaHeaders.MESSAGE_KEY, findType(r).getBytes())
                .build();
        this.source.output().send(message);
    }

    private String findType(int r) {
        if (r % 2 == 0)
            return "even";
        return "odd";
    }
}
