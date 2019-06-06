package com.ubp.doo.slotmachine.SlotMachine;

public class Main {
    public static void main(String[] args) {
        SlotMachine slotMachine = SlotMachine.getInstance();
        slotMachine.play();
        slotMachine.showResult();
        slotMachine.play();
        slotMachine.showResult();
    }
}