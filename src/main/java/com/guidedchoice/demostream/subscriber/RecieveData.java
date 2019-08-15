package com.guidedchoice.demostream.subscriber;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class)
public class RecieveData {

    @StreamListener(value = Sink.INPUT, condition = "headers['type']=='odd'")
    public void process(Integer number) {
        System.out.println("This is odd " + number);
    }

    @StreamListener(value = Sink.INPUT, condition = "headers['type']=='even'")
    public void processEven(Integer number) {
        System.out.println("This is even " + number);
    }


}
