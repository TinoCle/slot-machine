package com.ubp.doo.slotmachine.reel;

import com.ubp.doo.slotmachine.gamemode.GameMode;

import java.util.ArrayList;
import java.util.List;

public class ReelManager implements IReelListener{
    private List<Reel> reels;
    private List<Reel> spinningReels;
    private List<Integer> reelSize;
    private IReelManagerListener reelManagerListener;

    public ReelManager(GameMode gameMode, int qty){
        reels = new ArrayList<>();
        spinningReels = new ArrayList<>();
        for(int i=0;i<qty;i++) {
            Reel r = new Reel(gameMode, i);
            r.setListener(this);
            reels.add(r);
        }
    }

    public void spinReels(){
        System.out.println("Spining Reels\n");
        for (int i = 0; i < reels.size(); i++) {
            reels.get(i).spin(10);
        }
        spinningReels.addAll(reels);
    }

    @Override
    public void onReelFinished(Reel reel){
        spinningReels.remove(reel);
        if(spinningReels.size()==0){
            reelManagerListener.onReelsFinished();
        }
    }

    public void setListener(IReelManagerListener reelManagerListener){
        this.reelManagerListener = reelManagerListener;
    }
}
