package com.ubp.doo.slotmachine.reel;
import com.ubp.doo.slotmachine.gamemode.GameMode;

import java.util.List;

public class Reel {
    int spins;
    int reelNumber;
    GameMode gameMode;
    IReelListener reelListener;

    public Reel(GameMode gameMode, int reelNumber){
        this.gameMode = gameMode;
        this.reelNumber = reelNumber;
    }

    public void spin(int spins){
        this.spins = spins;
        for(int i=0;i<spins;i++){
            System.out.println(" " + gameMode.getNextValues().get(reelNumber));
            mostrarMensaje();
        }
    }

    public void mostrarMensaje(){
        reelListener.onReelFinished("Termine de girar");
    }

    public void setListener (IReelListener reelListener){
        this.reelListener = reelListener;
    }
}