package com.ubp.doo.slotmachine.reel;

public interface IReelListener {
    void spinReels();
    void onReelFinished(String mensaje);
}
