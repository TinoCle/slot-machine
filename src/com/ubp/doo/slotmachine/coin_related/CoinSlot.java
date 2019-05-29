package com.ubp.doo.slotmachine.coin_related;

public class CoinSlot {
    private int coinInserted;

    public CoinSlot(){
        coinInserted = 0;
    }

    public void CoinInserted(int coin){
        coinInserted += coin;
    }
}
