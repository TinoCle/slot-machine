package com.ubp.doo.slotmachine.coin_related;

public class CoinSlot {
    private int coinInserted;

    public int getCoinInserted() {
        return coinInserted;
    }

    public void setCoinInserted(int coinInserted) {
        this.coinInserted = coinInserted;
    }

    public CoinSlot(){
        coinInserted = 0;
    }

    public void AddCoin(){
         coinInserted++;
    }
}
