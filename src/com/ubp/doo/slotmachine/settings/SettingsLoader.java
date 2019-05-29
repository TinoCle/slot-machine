package com.ubp.doo.slotmachine.settings;

import java.io.*;
import java.util.Properties;

public class SettingsLoader {

    public void SaveSettings(Settings settings){
        try {
            // System.getProperty("user.dir") me trae el path de donde esta el proyecto
            OutputStream output = new FileOutputStream(System.getProperty("user.dir") + "config.properties");
            Properties prop;

            //a modo de ejemplo:
            //prop.setProperty("GameMode",settings.GameMode);
            //prop.setProperty("DropBoxAmount",settings.DropBoxAmount);

            //aca lo guardo en el path
            //prop.store(output,null);
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
