package com.ubp.doo.slotmachine.SlotMachine;

import slotmachine.ui.view.SlotMachineViewFacade;

public class Main {
    public static void main(String[] args) {
        SlotMachine slotMachine = SlotMachine.getInstance();

        SlotMachineViewFacade.setPlayHandler(slotMachine);
        SlotMachineViewFacade.setCreditHandler(slotMachine);

        slotMachine.setDisplayHander(SlotMachineViewFacade.getDisplayHandler());
        slotMachine.setiPrizeHandler(SlotMachineViewFacade.getPrizeHandler());

        SlotMachineViewFacade.show();
    }
}