package com.ubp.doo.slotmachine.coin_related;

public class CoinSlot {
    private int coinsInserted;

    public int getCoinInserted() {
        return coinsInserted;
    }

    public void setCoinInserted(int coinInserted) {
        this.coinsInserted = coinInserted;
    }

    public CoinSlot(){
        coinsInserted = 0;
    }

    public void AddCoin(int amount){
         coinsInserted+=amount;
    }

    public void SetCoins(int amount){
        this.coinsInserted=amount;
    }
}
