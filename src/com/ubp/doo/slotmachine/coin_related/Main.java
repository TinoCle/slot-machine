package com.ubp.doo.slotmachine.coin_related;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        int coin = 0;
        PayoutTray payoutTray = new PayoutTray();
        CoinSlot coinSlot = new CoinSlot();
        DropBox dropBox = new DropBox(coin);

        coinSlot.AddCoin();
        coinSlot.AddCoin();
        coinSlot.AddCoin();

        System.out.println("La cantidad de fichas insertadas es: " + coinSlot.getCoinInserted());
    }
}
