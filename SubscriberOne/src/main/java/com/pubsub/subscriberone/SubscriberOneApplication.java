package com.pubsub.subscriberone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SubscriberOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubscriberOneApplication.class, args);
    }

}
