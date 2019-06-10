package com.ubp.doo.slotmachine.SlotMachine;

import slotmachine.ui.view.SlotMachineViewFacade;

public class Main {
    public static void main(String[] args) {
        SlotMachine slotMachine = SlotMachine.getInstance();
        slotMachine.setDisplayHander(SlotMachineViewFacade.getDisplayHandler());
        slotMachine.setiPrizeHandler(SlotMachineViewFacade.getPrizeHandler());

        SlotMachineViewFacade.setPlayHandler(slotMachine);
        SlotMachineViewFacade.setCreditHandler(slotMachine);
        SlotMachineViewFacade.setGameModeHandler(slotMachine);

        //to activate lever
        SlotMachineViewFacade.setInputEnabled(true);


        SlotMachineViewFacade.show();
    }
}