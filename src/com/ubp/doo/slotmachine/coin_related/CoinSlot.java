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

    public void AddCoin(int coin) throws ExceptionCoin{
         if(coin==1){
             coinInserted += coin;
             System.out.println("Has insertado una ficha");
         }
         else{
             throw new ExceptionCoin("Se debe ingresar de a un coin");
         }
    }
}
