package com.ubp.doo.slotmachine.settings;

import java.util.Properties;

// Se aplica el patrón singleton
public class Settings {
    private static Settings instance;
    private SettingsLoader loader;

    //Faltan las opciones de configuracion

    //en el constructor deberiamos definir las opciones por defecto
    private Settings(){
        //this.GameMode="random";
    }

    public static Settings getInstance() {
        if (instance == null) {
            Properties properties = loader.LoadSettings();
            instance = new Settings();
            if(properties!=null) {
                this.GameMode = properties.getProperty("GameMode");
                this.DropBoxAmount = properties.getProperty("DropBoxAmount");
            }
        }
        return instance;
    }

    public void SaveSettings(){
        loader.SaveSettings(this);
    }
}
