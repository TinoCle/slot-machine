package com.ubp.doo.slotmachine.reel;

public class Reel {
    int value;

    public Reel(){}

    public Reel(int v) {
        this.value = v;
    }

    public void spin(int spins){
        this.value = spins;
    }

    //metodo de testing, borrar
    public int getValue(){
        return this.value;
    }

}