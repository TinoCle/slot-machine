package com.ubp.doo.slotmachine.SlotMachine;

import com.ubp.doo.slotmachine.reel.ReelManager;
import com.ubp.doo.slotmachine.record.RecordManager;
import com.ubp.doo.slotmachine.coin_related.CoinSlot;
import com.ubp.doo.slotmachine.coin_related.PayoutTray;
import com.ubp.doo.slotmachine.coin_related.DropBox;
import com.ubp.doo.slotmachine.display.Display;

public class SlotMachine {
    private ReelManager reelManager;
    private RecordManager recordManager;
    private CoinSlot coinSlot;
    private PayoutTray payoutTray;
    private DropBox dropBox;
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
