package com.ubp.doo.slotmachine.gamemode;
import java.util.List;

public class Random extends GameMode{
    private List<Integer> reelSize;

    public Random (List<Integer> reelSize, IRandomize r){
        super(r);
        this.reelSize = reelSize;
    }

    @Override
    public List<Integer> getNextValues() {
        return getRandoms(reelSize);
    }
}
