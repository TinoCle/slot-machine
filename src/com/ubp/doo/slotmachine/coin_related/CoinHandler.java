package com.ubp.doo.slotmachine.coin_related;

public class CoinHandler {
    private int totalCoin;
    private CoinSlot coinSlot;
    private PayoutTray payoutTray;

    public CoinHandler(CoinSlot coinSlot, PayoutTray payoutTray){
        totalCoin = 0;
        this.coinSlot = coinSlot;
        this.payoutTray = payoutTray;
    }

    public void ControlCoin(){

    }
}
