package com.ubp.doo.slotmachine.gamemode;

import java.util.ArrayList;
import java.util.List;

public class Sequence extends GameMode{
    private List<Integer> reelsize;
    private List<List<Integer>> sequence;
    private int index;

    public Sequence(List<Integer> reelsize, int quantity, IRandomize r){
        super(r);
        this.reelsize = reelsize;
        sequence = new ArrayList<>();
        index = 0;
        for (int i = 0; i < quantity; i++) {
            sequence.add(getRandoms(reelsize));
        }
    }

    @Override
    public List<Integer> getNextValues() {
        List<Integer> result;
        result = sequence.get(index);
        index  = ++index%sequence.size();

        return result;
    }
}
