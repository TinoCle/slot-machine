package com.ubp.doo.slotmachine.coin_related;

public class CoinSlot {
    private Coin totalCoins;

    public CoinSlot(){
        totalCoins = new Coin();
    }

    public void AddCoinSlot(Coin coin){
        totalCoins.AddCoin(coin.getCoin());
    }

    public Coin getTotalCoins() {
        return totalCoins;
    }

    public void setTotalCoins(Coin totalCoins) {
        this.totalCoins = totalCoins;
    }
}
