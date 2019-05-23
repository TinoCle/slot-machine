package com.ubp.doo.slotmachine.gamemode;
import java.util.List;
import java.util.ArrayList;

public abstract class GameMode {
    private IRandomize randomize;

    public GameMode(IRandomize r){
        this.randomize=r;
    }

    public abstract List<Integer> getNextValues();

    protected List<Integer> getRandoms(List<Integer> reelSize) {
        List<Integer> result = new ArrayList<>();
        for(int i : reelSize) {
            result.add(Math.abs(randomize.nextInt()%i));
        }
        return result;
    }
}
