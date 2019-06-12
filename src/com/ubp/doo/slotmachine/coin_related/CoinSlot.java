package com.ubp.doo.slotmachine.coin_related;

public class CoinSlot {
    private int coinsInserted;

    public int getCoinsInserted() {
        return coinsInserted;
    }

    public void setCoinsInserted(int coinInserted) {
        this.coinsInserted = coinInserted;
    }

    public CoinSlot(){
        coinsInserted = 0;
    }

    public void AddCoin(int amount){
         coinsInserted+=amount;
    }
}
