package com.pubsub.subscribertwo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pubsub.subscribertwo.models.ScoreCard;
import org.springframework.stereotype.Component;

@Component
public class JacksonUtil {

    public String toJson(ScoreCard scoreCard) {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(scoreCard);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public ScoreCard fromJson(String json) {
        ScoreCard scoreCard = null;
        try {
            scoreCard = new ObjectMapper().readValue(json, ScoreCard.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return scoreCard;
    }
}
