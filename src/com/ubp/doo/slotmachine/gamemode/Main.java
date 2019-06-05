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

<<<<<<< HEAD
        /*for (int i = 0; i < 10; i++) {
=======
        for (int i = 0; i < 20; i++) {
>>>>>>> b9f8ec9540ad4e3ab1bad554f1097f34aa2d0eaf
            System.out.println(i+" "+random.getNextValues());
        }
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < 20; i++) {
            System.out.println(i+" "+sequence.getNextValues());
        }*/
    }
}
