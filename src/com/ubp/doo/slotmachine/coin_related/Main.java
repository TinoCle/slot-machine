package com.ubp.doo.slotmachine.coin_related;

public class Main {
    public static void main(String[] args){
        int coin = 0;
        CoinSlot coinSlot = new CoinSlot();
        DropBox dropBox = new DropBox(coin);
        System.out.println("La cantidad de fichas insertadas es: " + coinSlot.getCoinsInserted());
    }
}
