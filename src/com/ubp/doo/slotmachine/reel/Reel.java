package com.ubp.doo.slotmachine.reel;
import com.ubp.doo.slotmachine.gamemode.GameMode;

import java.util.ArrayList;
import java.util.List;

public class Reel {
    int spins;
    int reelNumber;
    List<Integer> results;
    GameMode gameMode;
    IReelListener reelListener;

    public Reel(GameMode gameMode, int reelNumber){
        this.gameMode = gameMode;
        this.reelNumber = reelNumber;
        results = new ArrayList<>();
    }

    public void spin(int spins){
        this.spins = spins;
        for(int i=0;i<spins;i++){
            results.add(gameMode.getNextValues().get(reelNumber));
            // System.out.println(" " + gameMode.getNextValues().get(reelNumber));
        }
        reelListener.onReelFinished(this);
    }

    public void setListener (IReelListener reelListener){
        this.reelListener = reelListener;
    }
}