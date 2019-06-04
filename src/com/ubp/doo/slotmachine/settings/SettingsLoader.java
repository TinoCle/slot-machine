package com.ubp.doo.slotmachine.settings;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SettingsLoader {

    public void SaveSettings(Settings settings){
        try {
            OutputStream output = new FileOutputStream(System.getProperty("user.dir") + "config.properties");
            Properties prop = new Properties();
            prop.setProperty("GameMode",settings.getGameMode());
            prop.setProperty("DropBox",Integer.toString(settings.getDropBox()));
            prop.setProperty("SequencesQuantity",Integer.toString(settings.getSequencesQuantity()));
            prop.setProperty("ReelsQuantity", Integer.toString(settings.getReelsQuantity()));

            String aux = "";
            int reelsQuantity = Integer.parseInt(prop.getProperty("ReelsQuantity"));

            for(int i=0;i<reelsQuantity;i++){
                if(i==reelsQuantity-1){
                    aux += settings.getReelSize().get(i);
                }
                else {
                    aux += settings.getReelSize().get(i) + ",";
                }
            }
            prop.setProperty("ReelSize",aux);

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
