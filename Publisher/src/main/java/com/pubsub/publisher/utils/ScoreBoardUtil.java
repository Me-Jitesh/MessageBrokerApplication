package com.pubsub.publisher.utils;

import com.pubsub.publisher.Models.ScoreCard;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ScoreBoardUtil {

    Random random = new Random();

    public ScoreCard generateScore(ScoreCard score) {

        int id = score.getId() + 1;
        score.setId(id);

        int run = score.getRuns() + random.nextInt(0, 7);
        score.setRuns(run);

        int temp = random.nextInt(20);
        int wicket = temp == 9 || temp == 5 || temp == 15 ? score.getWickets() + 1 : score.getWickets();
        score.setWickets(wicket);

        if (score.getBalls() == 6) {
            int over = score.getOvers() + 1;
            score.setOvers(over);
            score.setBalls(1);
        } else {
            int ball = score.getBalls() + 1;
            score.setBalls(ball);
        }

        return score;
    }
}
