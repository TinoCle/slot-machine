package com.ubp.doo.slotmachine.coin_related;

public class Main {
    public static void main(String[] args){
        int coin = 0;
        PayoutTray payoutTray = new PayoutTray();
        CoinSlot coinSlot = new CoinSlot();
        DropBox dropBox = new DropBox(coin);

        coin = 1;
        coinSlot.AddCoin(coin);

    }
}
