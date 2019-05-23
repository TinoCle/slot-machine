package com.ubp.doo.slotmachine.gamemode;

import java.util.List;

public class RandomFactory implements IGameModeAbstractFactory {
    private List<Integer> reelSize;
    private IRandomize randomize;

    public RandomFactory(List<Integer> reelSize, IRandomize randomize) {
        this.reelSize = reelSize;
        this.randomize = randomize;
    }

    @Override
    public GameMode createGameMode() {
        return new Random(reelSize, randomize);
    }
}
