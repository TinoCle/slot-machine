package com.ubp.doo.slotmachine.reel;

import com.ubp.doo.slotmachine.gamemode.GameMode;

import java.util.ArrayList;
import java.util.List;

public class ReelManager implements IReelListener{
    private List<Reel> reels;
    private List<Reel> spinningReels;
    private List<Integer> reelSize;
    private List<Integer> results;
    private IReelManagerListener reelManagerListener;

    public List<Integer> getResults() {
        return results;
    }

    public ReelManager(GameMode gameMode, int qty){
        reels = new ArrayList<>();
        spinningReels = new ArrayList<>();
        results = new ArrayList<>();
        for(int i=0;i<qty;i++) {
            Reel r = new Reel(gameMode, i);
            r.setListener(this);
            reels.add(r);
        }
    }

    public void spinReels(){
        System.out.println("Spining Reels\n");
        results.clear();
        for (int i = 0; i < reels.size(); i++) {
            reels.get(i).spin(10);
            spinningReels.add(reels.get(i));
        }
    }

    @Override
    public void onReelFinished(Reel reel){
        results.add(reel.getLastResult());
        spinningReels.remove(reel);
        if(spinningReels.size()==0){
            reelManagerListener.onReelsFinished();
        }
    }

    public void setListener(IReelManagerListener reelManagerListener){
        this.reelManagerListener = reelManagerListener;
    }
}
