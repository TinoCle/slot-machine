package com.ubp.doo.slotmachine.gamemode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> reelSize = new ArrayList<>();
        reelSize.add(5);
        reelSize.add(3);
        reelSize.add(8);

        IRandomize randomize = new Randomize();

        GameMode random = GameModeFactory.getGameMode(new RandomFactory(reelSize, randomize));
        GameMode sequence = GameModeFactory.getGameMode(new SequenceFactory(reelSize, 10, randomize));

/*
        for (int i = 0; i < 20; i++) {
            System.out.println(i+" "+random.getNextValues());
        }
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < 20; i++) {
            System.out.println(i+" "+sequence.getNextValues());
        }*/
    }
}
