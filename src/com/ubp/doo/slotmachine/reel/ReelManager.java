package com.ubp.doo.slotmachine.reel;

import java.util.ArrayList;
import java.util.List;

public class ReelManager implements IReelListener{
    private List<Reel> reels;
    private List<Reel> spinningReels;
    private List<String> results;
    private IReelManagerListener reelManagerListener;

    public List<String> getResults() {
        return results;
    }

    public ReelManager(List<Integer> reelSize){
        reels = new ArrayList<>();
        spinningReels = new ArrayList<>();
        results = new ArrayList<>();

        for(int i=0;i<reelSize.size();i++) {
            Reel r = new Reel(reelSize.get(i));
            r.setListener(this);
            reels.add(r);
        }
    }

    public void spinReels(List<Integer> endPositions){
        System.out.println("Spining Reels\n");
        results.clear();
        for (int i = 0; i < reels.size(); i++) {
            reels.get(i).spin(endPositions.get(i));
            spinningReels.add(reels.get(i));
        }
    }

    @Override
    public void onReelFinished(Reel reel){
        results.add(reel.getResult());
        spinningReels.remove(reel);
        if(spinningReels.size()==0){
            reelManagerListener.onReelsFinished();
        }
    }

    public void setListener(IReelManagerListener reelManagerListener){
        this.reelManagerListener = reelManagerListener;
    }
}
