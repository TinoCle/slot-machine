package com.ubp.doo.slotmachine.record;

import java.io.Serializable;
import java.util.List;


public class Record implements Serializable{
    private int betAmount;
    private List<Integer> reelResults;
    private String gameResult;

    public Record (int bet, List<Integer> reels, String game) {
        betAmount = bet;
        reelResults = reels;
        gameResult = game;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public List<Integer> getReelResults() {
        return reelResults;
    }

    public String getGameResult() {
        return gameResult;
    }

}
