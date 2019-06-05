package com.ubp.doo.slotmachine.reel;

import com.ubp.doo.slotmachine.gamemode.GameMode;

import java.util.ArrayList;
import java.util.List;

public class ReelManager implements IReelListener{
    List<Reel> reels;
    List<Integer> reelSize;
    String mensaje;

    public ReelManager(GameMode gameMode, int qty){
        reels = new ArrayList<>();
        for(int i=0;i<qty;i++) {
            Reel r = new Reel(gameMode, i);
            r.setListener(this);
            reels.add(r);
        }
    }

    @Override
    public void spinReels(){
        System.out.println("Spining Reels\n");
        for (int i = 0; i < reels.size(); i++) {
            reels.get(i).spin(10);
            System.out.println(mensaje);
        }
    }

    @Override
    public void onReelFinished(String mensaje){
        this.mensaje = mensaje;
    }


    /*
    //metodo de testing, borrar
    public void tellMeTheTruth() {
        System.out.println("Reel results:\n");
        for (int i = 0; i < reels.size(); i++) {
            System.out.println("Reel " + i + ": " + reels.get(i).getValue() + "\n");
        }
    }*/

}
