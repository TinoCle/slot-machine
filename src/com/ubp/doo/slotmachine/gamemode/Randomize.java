package com.ubp.doo.slotmachine.gamemode;

import java.util.Random;

public class Randomize implements IRandomize{
    @Override
    public int nextInt() {
        Random random = new Random();
        return random.nextInt();
    }
}
