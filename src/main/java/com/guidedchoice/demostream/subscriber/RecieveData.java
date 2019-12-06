package com.guidedchoice.demostream.subscriber;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class RecieveData {

    @Bean
    public Consumer<Integer> odd() {
        return (number) -> System.out.println("This is odd " + number);
    }

    @Bean
    public Consumer<Integer> even() {

        return (number) -> System.out.println("This is even " + number);
    }


}
