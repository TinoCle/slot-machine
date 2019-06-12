package com.ubp.doo.slotmachine.record;

import java.io.Serializable;
import java.util.List;

public class Record implements Serializable{
    private int betAmount;
    private List<String> reelResults;
    private String gameResult;
    private int prize;

    public Record (int betAmount, int prize, List<String> reelResults, String gameResult) {
        this.betAmount = betAmount;
        this.prize = prize;
        this.reelResults = reelResults;
        this.gameResult = gameResult;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public List<String> getReelResults() {
        return reelResults;
    }

    public String getGameResult() {
        return gameResult;
    }

    public int getPrize() {
        return prize;
    }
}
