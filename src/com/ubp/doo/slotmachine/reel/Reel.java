package com.ubp.doo.slotmachine.reel;

import com.ubp.doo.slotmachine.settings.Settings;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Reel {
    private List<String> values;
    private String result;
    private IReelListener reelListener;
    private Settings settings;
    private int currentValue;

    public String getResult() {
        return values.get(currentValue);
    }

    public Reel(int reelSize) {
        settings = Settings.getInstance();
        values = new ArrayList<>();
        for (int i = 0; i < reelSize; i++) {
            String v = settings.getValues().split(",")[i];
            values.add(v);
        }
    }

    public void spin(int spins, int endPosition) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.execute(() -> {
            try {
                boolean lastSpin = false;
                for (int i = 0; i <= spins; i++) {
                    if (i == spins) {
                        lastSpin = true;
                    }
                    for (int k = currentValue; k < values.size(); k++) {
                        currentValue = ++currentValue % values.size();
                        Thread.sleep(100);
                        reelListener.reelUpdate(this);

                        if (lastSpin && currentValue == endPosition)
                            break;
                    }
                }
                reelListener.onReelFinished(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //result = values.get(endPosition);
        //reelListener.onReelFinished(this);
    }

    public void setListener(IReelListener reelListener) {
        this.reelListener = reelListener;
    }

    public int getCurrentValue() {
        return this.currentValue;
    }

    public List<String> getValues(){
        return this.values;
    }
}

