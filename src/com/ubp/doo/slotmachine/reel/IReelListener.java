package com.ubp.doo.slotmachine.reel;

public interface IReelListener {
    void onReelFinished(Reel reel);
    void reelUpdate(Reel reel);
}
