package com.ubp.doo.slotmachine.settings;

import java.io.*;
import java.util.Properties;

public class SettingsLoader {

    public void SaveSettings(Settings settings){
        try {
            OutputStream output = new FileOutputStream(System.getProperty("user.dir") + "config.properties");
            Properties prop = new Properties();
            prop.setProperty("GameMode",settings.getGameMode());
            prop.setProperty("DropBox",settings.getGameMode());
            prop.store(output,null);
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException io){
            io.printStackTrace();
        }
    }

    public Properties LoadSettings (){
        try {
            InputStream input = new FileInputStream(System.getProperty("user.dir") + "config.properties");
            Properties prop = new Properties();
            prop.load(input);
            return prop;
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
