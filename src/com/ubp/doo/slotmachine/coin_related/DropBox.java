package com.ubp.doo.slotmachine.coin_related;

public class DropBox{
    private Coin pit;
    private PayoutTray payoutTray;
    private CoinSlot coinSlot;

    public DropBox(CoinSlot c, PayoutTray p){
        pit = new Coin();
        payoutTray = p;
        coinSlot = c;
    }

    public Coin giveCoins(){
        pit = payoutTray.getTotalCoins();
        return pit;
    }

    public void setCoins(){
        pit = coinSlot.getTotalCoins();
    }
}
