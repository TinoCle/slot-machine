package com.ubp.doo.slotmachine.settings;

import java.io.*;
import java.util.List;
import java.util.Properties;

// Se aplica el patrón singleton
public class Settings {
    private static Settings instance;
    private String gameMode;
    private int dropBox;
    private int sequencesQuantity;
    private int reelsQuantity;
    private String reelSize;
    private String values;
    private Properties properties;

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

    public String getReelSize() {
        return reelSize;
    }

    public String getValues() {
        return values;
    }

    private Settings() {
        properties = new Properties();
        LoadSettings();
    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    public void SaveSettings() {
        try {
            OutputStream output = new FileOutputStream(System.getProperty("user.dir") + "config.properties");
<<<<<<< HEAD
=======

            gameMode = "random";
            dropBox = 1000;
            sequencesQuantity = 10;
            reelsQuantity = 3;
            reelSize = "";
            for (int i = 0; i < reelsQuantity; i++) {
                if (i == reelsQuantity - 1) {
                    reelSize += ((int) (Math.random() * 12) + 1);
                } else {
                    reelSize += ((int) (Math.random() * 12) + 1) + ",";
                }
            }

>>>>>>> e1f3c3976dc88d4f202356b6858dc914411b8b06
            properties.setProperty("GameMode", gameMode);
            properties.setProperty("DropBox", Integer.toString(dropBox));
            properties.setProperty("SequencesQuantity", Integer.toString(sequencesQuantity));
            properties.setProperty("ReelsQuantity", Integer.toString(reelsQuantity));
            properties.setProperty("ReelSize", reelSize);
            properties.setProperty("Values",values);
            properties.store(output, null);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void LoadSettings() {
        try {
            InputStream input = new FileInputStream(System.getProperty("user.dir") + "config.properties");

            //TODO ver donde se guarda las settigs
            System.out.println(System.getProperty("user.dir") + "config.properties");

            properties.load(input);
            gameMode = properties.getProperty("GameMode");
            dropBox = Integer.parseInt(properties.getProperty("DropBox"));
            sequencesQuantity = Integer.parseInt(properties.getProperty("SequencesQuantity"));
            reelsQuantity = Integer.parseInt(properties.getProperty("ReelsQuantity"));
            reelSize = properties.getProperty("ReelSize");
            values = properties.getProperty("Values");
        } catch (FileNotFoundException e) {
            gameMode = "random";
            dropBox = 1000;
            sequencesQuantity = 10;
            reelsQuantity = 3;
            reelSize = "";
            for (int i = 0; i < reelsQuantity; i++) {
                if (i == reelsQuantity - 1) {
                    reelSize += ((int) (Math.random() * 12) + 1);
                } else {
                    reelSize += ((int) (Math.random() * 12) + 1) + ",";
                }
            }
            values = "uva,cereza,manzana,banana,frutilla,durazno,naranaja,sandia,anana,pera,limon";
            SaveSettings();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
