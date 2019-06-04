package com.ubp.doo.slotmachine.record;

import java.util.List;

public class Record {
    private int betAmount;
    private List<String> reelResults;
    private String gameResult;

    public Record (int bet, List<String> reels, String game) {
        betAmount = bet;
        reelResults = reels;
        gameResult = game;
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

}
