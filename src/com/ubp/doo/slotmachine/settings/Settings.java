package com.ubp.doo.slotmachine.settings;

import java.util.Properties;
import com.ubp.doo.slotmachine.gamemode.GameMode;
import com.ubp.doo.slotmachine.coin_related.DropBox;

// Se aplica el patrón singleton
public class Settings {
    private static Settings instance;
    private SettingsLoader loader;
    private String gameMode;
    private int dropBox;

    public String getGameMode() {
        return gameMode;
    }

    public int getDropBox() {
        return dropBox;
    }

    private Settings(){
        Properties properties = loader.LoadSettings();
        if(properties!=null) {
            gameMode = properties.getProperty("GameMode");
            dropBox = Integer.parseInt(properties.getProperty("DropBox"));
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
