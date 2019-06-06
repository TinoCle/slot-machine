package com.ubp.doo.slotmachine.SlotMachine;

import com.ubp.doo.slotmachine.gamemode.*;
import com.ubp.doo.slotmachine.reel.IReelManagerListener;
import com.ubp.doo.slotmachine.reel.ReelManager;
import com.ubp.doo.slotmachine.record.RecordManager;
import com.ubp.doo.slotmachine.coin_related.CoinSlot;
import com.ubp.doo.slotmachine.coin_related.PayoutTray;
import com.ubp.doo.slotmachine.coin_related.DropBox;
import com.ubp.doo.slotmachine.display.Display;
import com.ubp.doo.slotmachine.settings.Settings;

import java.util.ArrayList;
import java.util.List;

public class SlotMachine implements IReelManagerListener {
    private ReelManager reelManager;
    private RecordManager recordManager;
    private CoinSlot coinSlot;
    private PayoutTray payoutTray;
    private DropBox dropBox;
    private GameMode gameMode;
    private Display display;
    private Settings settings;
    
    private static SlotMachine instance;
    
    private SlotMachine(){
        loadConfiguration();
    }

    public static SlotMachine getInstance(){
        if(instance==null){
            instance = new SlotMachine();
        }
        return instance;    
    }
    
    public void loadConfiguration(){
        Settings settings = Settings.getInstance();

        //TODO comprobar que las settings esten
        /*System.out.println("GameMode: " + settings.getGameMode());
        System.out.println("ReelSize: " + settings.getReelSize());
        System.out.println("DropBox: " + settings.getDropBox());
        System.out.println("ReelQuantity: " + settings.getReelsQuantity());
        System.out.println("SequenceQuantity: " + settings.getSequencesQuantity());*/

        IRandomize randomize = new Randomize();
        List<Integer> reelSize = new ArrayList<>();

        int reelQuantity = settings.getReelsQuantity();

        for(int i=0;i<reelQuantity;i++){
            String valor = settings.getReelSize().split(",")[i];
            reelSize.add(Integer.parseInt(valor));
        }

        if(settings.getGameMode() == "random"){
            gameMode = GameModeFactory.getGameMode(new RandomFactory(reelSize, randomize));
        }
        else{
            gameMode = GameModeFactory.getGameMode(new SequenceFactory(reelSize, settings.getSequencesQuantity(), randomize));
        }

        reelManager = new ReelManager(reelSize);
        reelManager.setListener(this);

        dropBox = new DropBox(settings.getDropBox());
    }

    @Override
    public void onReelsFinished(){
        System.out.println("Los reels han terminado de girar");
    }
    
    public void play(){
        reelManager.spinReels(gameMode.getNextValues());
    }
    
    public void showResult(){
        System.out.println("Resultado de reels: "+reelManager.getResults());
    }
    
    private void setGameMode(){
        
    }
}
