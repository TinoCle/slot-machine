package com.ubp.doo.slotmachine.coin_related;

public class Coin {
    private int value;

    public Coin(){
        value = 0;
    }

    public int getCoin(){
        return value;
    }

    public void setCoin(int value){
        this.value=value;
    }

    public void AddCoin(int value){
        this.value+=value;
    }
}
