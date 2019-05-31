package com.ubp.doo.slotmachine.coin_related;

public class DropBox{
    private int totalCoin;

    public DropBox(int storedCoin){
        totalCoin = storedCoin;
    }

    public void setTotalCoin(int totalCoin) {
        this.totalCoin = totalCoin;
    }
}
