package com.ubp.doo.slotmachine.coin_related;

public class PayoutTray {
    private int coinToDeliver;

    public PayoutTray(){
        coinToDeliver = 0;
    }

    public int DeliverPrize(int prize){
        coinToDeliver = prize;
        System.out.println("El premio a entregar es: " + coinToDeliver);
        return coinToDeliver;
    }
}
