package com.ubp.doo.slotmachine.coin_related;

import slotmachine.ui.data.ICredit;

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

    public void AddCoin(ICredit amount){
         coinsInserted+=amount.getValue();
    }

    public void SetCoins(int amount){
        this.coinsInserted=amount;
    }
}
