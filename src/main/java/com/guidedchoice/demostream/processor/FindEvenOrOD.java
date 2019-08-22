package com.guidedchoice.demostream.processor;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
@EnableBinding(Processor.class)
public class FindEvenOrOD {

/*    @Autowired
    private EvenOddProcessor processor;

    @StreamListener(value = EvenOddProcessor.INPUT)
    public void processEven(Integer r) {

        String type;

        Message<Integer> message = buildMessage(r, type);
        this.processor.output().send(message);
    }*/

    private Message<Integer> buildMessage(Integer r, String type) {
        return MessageBuilder

                .withPayload(r)
                .setHeader("type", type)
                .build();
    }


    @Bean
    public Function<Flux<Message<Integer>>, Flux<Message<Integer>>> processType() {
        return flux -> flux.map(message -> message.getPayload())
                .map(integer -> integer % 2 == 0 ?
                        buildMessage(integer, "even")
                        : buildMessage(integer, "odd"));
    }
}
