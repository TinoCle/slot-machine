package com.ubp.doo.slotmachine.coin_related;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        int coin = 0;
        PayoutTray payoutTray = new PayoutTray();
        CoinSlot coinSlot = new CoinSlot();
        DropBox dropBox = new DropBox(coin);

        coin = 1;
        try{
            coinSlot.AddCoin(coin);
            coinSlot.AddCoin(coin);
            coinSlot.AddCoin(coin);
        }
        catch (IOException io){
            System.out.println(io.getMessage());
        }

        System.out.println("La cantidad de fichas insertadas es: " + coinSlot.getCoinInserted());
    }
}
