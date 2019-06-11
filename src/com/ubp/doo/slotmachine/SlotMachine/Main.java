package com.ubp.doo.slotmachine.SlotMachine;

import slotmachine.ui.view.SlotMachineViewFacade;

public class Main {
    public static void main(String[] args) {
        SlotMachine slotMachine = SlotMachine.getInstance();
        slotMachine.setiDisplayHandlerer(SlotMachineViewFacade.getDisplayHandler());
        slotMachine.setiPrizeHandler(SlotMachineViewFacade.getPrizeHandler());
        slotMachine.setIReelsHandler(SlotMachineViewFacade.getReelsHandler());

        SlotMachineViewFacade.setPlayHandler(slotMachine);
        SlotMachineViewFacade.setCreditHandler(slotMachine);
        SlotMachineViewFacade.setGameModeHandler(slotMachine);

        //to activate lever
        SlotMachineViewFacade.setInputEnabled(true);


        SlotMachineViewFacade.show();

        /*slotMachine.play();
        slotMachine.showResult();
        slotMachine.play();
        slotMachine.showResult();*/
    }
}