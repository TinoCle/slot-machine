package com.ubp.doo.slotmachine.coin_related;

import java.io.IOException;

public class ExceptionCoin extends IOException {
    public ExceptionCoin(){
    }
    public ExceptionCoin(String str){
        super("ExceptionCoin: " + str);
    }
}
