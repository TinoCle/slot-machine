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
        SlotMachineViewFacade.setResetHandler(slotMachine);
        SlotMachineViewFacade.setInputEnabled(true);

        SlotMachineViewFacade.show();
    }
}