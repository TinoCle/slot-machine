package com.ubp.doo.slotmachine.gamemode;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class RandomTest {

    @Test
    void testGetNextValues3Reels() {
        List<Integer> reelSize = new ArrayList<>();
        reelSize.add(4);
        reelSize.add(2);
        reelSize.add(1);

        IRandomize randomize = new RandomizeMock();

        GameMode random = GameModeFactory.getGameMode(new RandomFactory(reelSize,randomize));

        List<Integer> result = random.getNextValues();

        List<Integer> expResult = new ArrayList<>();
        expResult.add(3);
        expResult.add(1);
        expResult.add(0);

        assertEquals(expResult,result);
    }

    @Test
    void testGetNextValuesError3Reels() {
        List<Integer> reelSize = new ArrayList<>();
        reelSize.add(6);
        reelSize.add(7);
        reelSize.add(8);

        IRandomize randomize = new RandomizeMock();

        GameMode random = GameModeFactory.getGameMode(new RandomFactory(reelSize,randomize));

        List<Integer> result = random.getNextValues();

        List<Integer> expResult = new ArrayList<>();
        expResult.add(1);
        expResult.add(2);
        expResult.add(3);

        assertNotEquals(expResult,result);
    }

    @Test
    void testGetNextValues5Reels(){
        List<Integer> reelsize = new ArrayList<>();
        reelsize.add(1);
        reelsize.add(2);
        reelsize.add(3);
        reelsize.add(4);
        reelsize.add(5);

        IRandomize randomize = new RandomizeMock();

        GameMode random = GameModeFactory.getGameMode(new RandomFactory(reelsize,randomize));

        List<Integer> result = random.getNextValues();

        List<Integer> expResult = new ArrayList<>();
        expResult.add(0);
        expResult.add(1);
        expResult.add(0);
        expResult.add(3);
        expResult.add(3);

        assertEquals(expResult,result);
    }

    @Test
    void testGetNextValuesError5Reels(){
        List<Integer> reelsize = new ArrayList<>();
        reelsize.add(1);
        reelsize.add(2);
        reelsize.add(3);
        reelsize.add(4);
        reelsize.add(5);

        IRandomize randomize = new RandomizeMock();

        GameMode random = GameModeFactory.getGameMode(new RandomFactory(reelsize,randomize));

        List<Integer> result = random.getNextValues();

        List<Integer> expResult = new ArrayList<>();
        expResult.add(1);
        expResult.add(3);
        expResult.add(4);
        expResult.add(8);
        expResult.add(1);

        assertNotEquals(expResult,result);
    }
}