package com.pubsub.publisher.driver;

import com.pubsub.publisher.Models.ScoreCard;
import com.pubsub.publisher.service.PublisherService;
import com.pubsub.publisher.utils.ScoreBoardUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DriverCode implements CommandLineRunner {

    @Autowired
    private ScoreBoardUtil scoreBoardUtil;
    @Autowired
    private PublisherService service;
    private ScoreCard scoreCard;

    @Override
    public void run(String... args) {
        System.out.println("Publisher Running......");
        scoreCard = new ScoreCard(100, 0, 0, 0, 0);
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void sendToConsumer() {

        scoreCard = scoreBoardUtil.generateScore(scoreCard);
        boolean sent = service.publishScore(scoreCard);

        if (sent) {
            System.out.println("Score Published ID : " + scoreCard.getId());
        } else {
            System.out.println("Score Published ID : " + scoreCard.getId());
        }
    }
}
