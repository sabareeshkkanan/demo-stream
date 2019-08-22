package com.guidedchoice.demostream.subscriber;

import com.guidedchoice.demostream.processor.EvenOddProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(EvenOddProcessor.class)
public class RecieveData {

    @StreamListener(value = EvenOddProcessor.INPUT, condition = "headers['type']=='odd'")
    public void process(Integer number) {
        System.out.println("This is odd " + number);
    }

    @StreamListener(value = EvenOddProcessor.INPUT, condition = "headers['type']=='even'")
    public void processEven(Integer number) {
        System.out.println("This is even " + number);
    }


}
