package com.ubp.doo.slotmachine.reel;

import java.util.ArrayList;
import java.util.List;

public class ReelManager {
    List<Reel> reels;
    List<Integer> reelSize;

    public ReelManager(List<Integer> reelSize, int qty){
        //TODO:
        //Acá ReelManager "hace girar" los reels y les da su valor random
        reels = new ArrayList<>();
        for(int i=0;i<qty;i++) {
            //Acá llamar al otro constructor y darle el valor a guardar.
            Reel r = new Reel();
            reels.add(r);
        }
    }

    public void spinReels(){
        System.out.println("Spining Reels\n");
        for (int i = 0; i < reels.size(); i++) {
            reels.get(i).spin(10);
        }
    }

    //metodo de testing, borrar
    public void tellMeTheTruth() {
        System.out.println("Reel results:\n");
        for (int i = 0; i < reels.size(); i++) {
            System.out.println("Reel " + i + ": " + reels.get(i).getValue() + "\n");
        }
    }

}
