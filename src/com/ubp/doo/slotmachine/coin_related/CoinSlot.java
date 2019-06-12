package com.ubp.doo.slotmachine.coin_related;

import slotmachine.ui.data.ICredit;

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

    public void SetCoins(int amount){
        this.coinsInserted=amount;
    }
}
