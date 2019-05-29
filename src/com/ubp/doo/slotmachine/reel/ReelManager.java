package com.ubp.doo.slotmachine.reel;

import com.ubp.doo.slotmachine.coin_related.IReceiveCoin;

import java.util.List;

public class ReelManager implements IReelListener {
    List<Reel> reels;

    public void start(){

    }

    public void spinReels(){
        System.out.println("Spining Reels\n");
        for (int i = 0; i < reels.size(); i++) {
            reels.get(i).spin(10);
        }
    }

    @Override
    public void onReelFinished (Reel reel){

    }

}
