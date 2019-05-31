package com.ubp.doo.slotmachine.SlotMachine;

import com.ubp.doo.slotmachine.gamemode.GameMode;
import com.ubp.doo.slotmachine.gamemode.GameModeFactory;
import com.ubp.doo.slotmachine.gamemode.RandomFactory;
import com.ubp.doo.slotmachine.gamemode.SequenceFactory;
import com.ubp.doo.slotmachine.reel.ReelManager;
import com.ubp.doo.slotmachine.record.RecordManager;
import com.ubp.doo.slotmachine.coin_related.CoinSlot;
import com.ubp.doo.slotmachine.coin_related.PayoutTray;
import com.ubp.doo.slotmachine.coin_related.DropBox;
import com.ubp.doo.slotmachine.display.Display;
import com.ubp.doo.slotmachine.settings.Settings;

public class SlotMachine {
    private ReelManager reelManager;
    private RecordManager recordManager;
    private CoinSlot coinSlot;
    private PayoutTray payoutTray;
    private DropBox dropBox;
    private GameMode gameMode;
    private Display display;
    
    private static SlotMachine instance;
    
    private SlotMachine(){
        
    }
    
    public static SlotMachine getInstance(){
        if(instance==null){
            instance = new SlotMachine();
        }
        return instance;    
    }
    
    private void loadConfiguration(){
        Settings settings = Settings.getInstance();
        if(settings.getGameMode() == "random"){
            //GameMode random = GameModeFactory.getGameMode(new RandomFactory(reelSize, randomize));
        }
        else{
            //GameMode sequence = GameModeFactory.getGameMode(new SequenceFactory(reelSize, 10, randomize));
        }
        dropBox.setTotalCoin(settings.getDropBox());
    }
    
    public void initComponents(){
        
    }
    
    public void play(){

    }
    
    public void showResult(){
        
    }
    
    private void setGameMode(){
        
    }
    
    
    
    
    
    
}
