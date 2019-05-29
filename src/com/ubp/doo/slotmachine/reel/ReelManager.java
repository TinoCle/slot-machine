package com.ubp.doo.slotmachine.reel;

import java.util.List;

public class ReelManager {
    List<Reel> reels;

    //no se si este metodo iria
    public void start(){

    }

    public void spinReels(){
        System.out.println("Spining Reels\n");
        for (int i = 0; i < reels.size(); i++) {
            reels.get(i).spin(10);
        }
    }

    public void onReelFinished (Reel reel){

    }

}
