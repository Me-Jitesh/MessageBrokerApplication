package com.pubsub.publisher.utils;

import com.pubsub.publisher.Models.ScoreCard;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ScoreBoardUtil {

    Random random = new Random();
    Integer[] searchSpace = {0, 2, 0, 2, 0, 6, 1, 0, 4, 5, 0, 2, 1, 0, 6, 0, 3, 1, 0, 0, 1, 0, 4, 3, 0, 1, 4, 0};

    public ScoreCard generateScore(ScoreCard score) {

        int id = score.getId() + 1;
        score.setId(id);

        int temp = random.nextInt(30);
        int wicket = temp == 9 || temp == 5 || temp == 15 ? score.getWickets() + 1 : score.getWickets();

        if (score.getWickets() == wicket) {// Wicket not fallen
            int run = score.getRuns() + searchSpace[random.nextInt(0, searchSpace.length)];
            score.setRuns(run);
        }
        score.setWickets(wicket);

        if (score.getBalls() == 5) {
            int over = score.getOvers() + 1;
            score.setOvers(over);
            score.setBalls(0);
        } else {
            int ball = score.getBalls() + 1;
            score.setBalls(ball);
        }

        return score;
    }
}
