package com.ubp.doo.slotmachine.coin_related;

public class PayoutTray {
    Coin totalCoins;

    public PayoutTray(Coin coin){
        totalCoins = coin;
    }

    public Coin getTotalCoins() {
        return totalCoins;
    }

    public void setTotalCoins(Coin totalCoins) {
        this.totalCoins = totalCoins;
    }
}
