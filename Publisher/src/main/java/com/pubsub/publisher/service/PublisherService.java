package com.pubsub.publisher.service;

import com.pubsub.publisher.Models.ScoreCard;
import com.pubsub.publisher.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    @Autowired
    private JmsTemplate jt;
    @Autowired
    private JacksonUtil jacksonUtil;
    @Value("${my.jms.destination-name}")
    private String destinationName;

    public boolean publishScore(ScoreCard scoreCard) {
        String json = jacksonUtil.toJson(scoreCard);
        return publishScore(json);
    }

    public boolean publishScore(String scoreCard) {
        boolean sent = false;
        try {
            jt.send(destinationName, (session) -> session.createTextMessage(scoreCard));
            sent = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sent;
    }
}
