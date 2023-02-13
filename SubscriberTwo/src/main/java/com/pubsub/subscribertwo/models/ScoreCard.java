package com.pubsub.subscribertwo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreCard {
    private Integer id;
    private Integer runs;
    private Integer wickets;
    private Integer overs;
    private Integer balls;
}
