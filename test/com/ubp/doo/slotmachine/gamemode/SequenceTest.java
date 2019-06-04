package com.ubp.doo.slotmachine.gamemode;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SequenceTest {

    @Test
    void testGetNextValues3Reels() {
        List<Integer> reelSize = new ArrayList<>();
        reelSize.add(1);
        reelSize.add(2);
        reelSize.add(3);

        IRandomize randomize = new RandomizeMock();

        GameMode sequence = GameModeFactory.getGameMode(new SequenceFactory(reelSize,10,randomize));

        List<Integer> result = sequence.getNextValues();

        List<Integer> expResult = new ArrayList<>();
        expResult.add(0);
        expResult.add(1);
        expResult.add(0);

        assertEquals(expResult,result);
    }

    @Test
    void testGetNextValuesError3Reels() {
        List<Integer> reelSize = new ArrayList<>();
        reelSize.add(1);
        reelSize.add(2);
        reelSize.add(3);

        IRandomize randomize = new RandomizeMock();

        GameMode sequence = GameModeFactory.getGameMode(new SequenceFactory(reelSize,10,randomize));

        List<Integer> result = sequence.getNextValues();

        List<Integer> expResult = new ArrayList<>();
        expResult.add(1);
        expResult.add(2);
        expResult.add(3);

        assertNotEquals(expResult,result);
    }

    @Test
    void testGetNextValues5Reels() {
        List<Integer> reelSize = new ArrayList<>();
        reelSize.add(1);
        reelSize.add(2);
        reelSize.add(3);
        reelSize.add(4);
        reelSize.add(5);

        IRandomize randomize = new RandomizeMock();

        GameMode sequence = GameModeFactory.getGameMode(new SequenceFactory(reelSize,10,randomize));

        List<Integer> result = sequence.getNextValues();

        List<Integer> expResult = new ArrayList<>();
        expResult.add(0);
        expResult.add(1);
        expResult.add(0);
        expResult.add(3);
        expResult.add(3);

        assertEquals(expResult,result);
    }

    @Test
    void testGetNextValuesError5Reels() {
        List<Integer> reelSize = new ArrayList<>();
        reelSize.add(1);
        reelSize.add(2);
        reelSize.add(3);
        reelSize.add(4);
        reelSize.add(5);

        IRandomize randomize = new RandomizeMock();

        GameMode sequence = GameModeFactory.getGameMode(new SequenceFactory(reelSize,10,randomize));

        List<Integer> result = sequence.getNextValues();

        List<Integer> expResult = new ArrayList<>();
        expResult.add(1);
        expResult.add(2);
        expResult.add(4);
        expResult.add(5);
        expResult.add(6);

        assertNotEquals(expResult,result);
    }
}