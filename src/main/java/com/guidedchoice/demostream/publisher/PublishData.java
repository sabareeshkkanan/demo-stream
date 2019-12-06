package com.guidedchoice.demostream.publisher;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.function.Supplier;

@Service
public class PublishData {

    private Random random = new Random(10000);


    @Bean
    public Supplier<Message<Integer>> send() {

        return () -> {
            Integer r = random.nextInt(1000);

            Message<Integer> message = MessageBuilder

                    .withPayload(r)

                    .build();
            return message;
        };

    }


}
