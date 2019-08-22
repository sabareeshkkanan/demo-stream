package com.guidedchoice.demostream.publisher;

import com.guidedchoice.demostream.processor.EvenOddProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

import static javax.management.timer.Timer.ONE_SECOND;

@Service
@EnableBinding(EvenOddProcessor.class)
public class PublishData {

    private Random random = new Random(10000);

    @Autowired
    private EvenOddProcessor source;

    @Scheduled(fixedRate = ONE_SECOND)
    public void send() {
        Integer r = random.nextInt(1000);

        Message<Integer> message = MessageBuilder

                .withPayload(r)

                .build();
        this.source.output().send(message);
    }


}
