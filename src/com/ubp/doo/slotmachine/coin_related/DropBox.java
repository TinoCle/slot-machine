package com.ubp.doo.slotmachine.coin_related;

public class DropBox{
    private int totalCoin;

    public DropBox(int storedCoin){
        totalCoin = storedCoin;
    }

    public void setBet(int coin){
        totalCoin += coin;
    }

    public int getTotalCoin() {
        return totalCoin;
    }

    public void setTotalCoin(int totalCoin) {
        this.totalCoin = totalCoin;
    }
}
