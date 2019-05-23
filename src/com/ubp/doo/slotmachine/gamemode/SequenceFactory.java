package com.ubp.doo.slotmachine.gamemode;

import java.util.List;

public class SequenceFactory implements IGameModeAbstractFactory {
    private List<Integer> reelsize;
    private int quantity;
    private IRandomize randomize;

    public SequenceFactory(List<Integer> reelsize, int quantity, IRandomize r) {
        this.reelsize = reelsize;
        this.quantity = quantity;
        this.randomize = r;
    }

    @Override
    public GameMode createGameMode() {
        return new Sequence(reelsize, quantity, randomize);
    }
}
