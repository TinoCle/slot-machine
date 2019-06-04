package com.ubp.doo.slotmachine.settings;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

// Se aplica el patrón singleton
public class Settings {
    private static Settings instance;
    private SettingsLoader loader;
    private String gameMode;
    private int dropBox;
    private int sequencesQuantity;
    private int reelsQuantity;
    private List<Integer> reelSize;

    public String getGameMode() {
        return gameMode;
    }

    public int getDropBox() {
        return dropBox;
    }

    public int getSequencesQuantity() {
        return sequencesQuantity;
    }

    public int getReelsQuantity() {
        return reelsQuantity;
    }

    public List<Integer> getReelSize() {
        return reelSize;
    }

    private Settings(){
        try{
            Properties properties = loader.LoadSettings();
            gameMode = properties.getProperty("GameMode");
            dropBox = Integer.parseInt(properties.getProperty("DropBox"));
            sequencesQuantity = Integer.parseInt(properties.getProperty("SequencesQuantity"));
        }
        catch (NullPointerException npe){
            gameMode = "random";
            dropBox = 1000;
            reelSize = new ArrayList<>();
            reelSize.add(8);
            reelSize.add(8);
            reelSize.add(8);
            sequencesQuantity = 10;
            reelsQuantity = 3;
        }
    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    public void SaveSettings(){
        loader.SaveSettings(this);
    }
}
