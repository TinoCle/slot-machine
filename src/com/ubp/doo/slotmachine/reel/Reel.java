package com.ubp.doo.slotmachine.reel;

import com.ubp.doo.slotmachine.settings.Settings;

import java.util.ArrayList;
import java.util.List;

public class Reel {
    private List<String> values;
    private String result;
    private IReelListener reelListener;
    private Settings settings;

    public String getResult() {
        return result;
    }

    public Reel(int reelSize){
        settings = Settings.getInstance();
        values = new ArrayList<>();
        for(int i=0;i<reelSize;i++){
            String v = settings.getValues().split(",")[i];
            values.add(v);
        }
    }

    public void spin(int endPosition){
        result = values.get(endPosition);
        reelListener.onReelFinished(this);
    }

    public void setListener (IReelListener reelListener){
        this.reelListener = reelListener;
    }
}

