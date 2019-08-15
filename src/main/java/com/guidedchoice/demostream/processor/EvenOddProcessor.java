package com.guidedchoice.demostream.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface EvenOddProcessor {
    String OUTPUT = "processor-out";
    String INPUT = "processor-in";
    String OUTPUT1 = "processor-out-1";
    String INPUT1 = "processor-in-1";

    @Input(INPUT)
    SubscribableChannel input();

    @Output(OUTPUT)
    MessageChannel output();

    @Input(INPUT1)
    SubscribableChannel input1();

    @Output(OUTPUT1)
    MessageChannel output1();
}
