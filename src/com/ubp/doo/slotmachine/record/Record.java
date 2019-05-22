package com.ubp.doo.slotmachine.record;

import java.util.List;

//chequear el Builder

public class Record {
    int betAmount;
    List<String> reelResults;
    String gameResult;

    public Record (int bet, List<String> reels, String game) {
        betAmount = bet;
        reelResults = reels;
        gameResult = game;
    }
}
