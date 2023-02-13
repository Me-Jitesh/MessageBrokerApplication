package com.pubsub.subscribertwo.services;

import com.pubsub.subscribertwo.models.ScoreCard;
import com.pubsub.subscribertwo.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class SubscriberService {

    @Autowired
    private JacksonUtil jacksonUtil;

    @JmsListener(destination = "${my.jms.destination-name}")
    public void subscribeScore(String score) {

        ScoreCard scoreCard = jacksonUtil.fromJson(score);

        System.out.println("********** Live Cricket Score ************" + "\n"
                + "Score ID : " + scoreCard.getId() + "\n"
                + "Run/Wicket : " + scoreCard.getRuns() + "/" + scoreCard.getWickets() + "\n"
                + "Over : " + scoreCard.getOvers() + "." + scoreCard.getBalls() + "\n"
        );

        if (scoreCard.getWickets() == 10) {
            System.err.println("Innings Over With Score : "
                    + scoreCard.getRuns() + "/" + scoreCard.getWickets()
                    + " Overs : " + scoreCard.getOvers() + "." + scoreCard.getBalls()
            );
        }
    }

}
