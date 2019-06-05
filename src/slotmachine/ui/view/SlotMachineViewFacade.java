package slotmachine.ui.view;

import slotmachine.ui.handler.*;

public class SlotMachineViewFacade {
    private static SlotMachineView slotMachine;

    private static SlotMachineView getInstance() {
        if (slotMachine == null) {
            slotMachine = new SlotMachineView();
        }

        return slotMachine;
    }

    public static void show() {
        getInstance().show();
    }

    public static void setCreditHandler(ICreditHandler handler) {
        getInstance().setCreditHandler(handler);
    }

    public static void setPlayHandler(IPlayHandler handler) {
        getInstance().setPlayHandler(handler);
    }

    public static void setGameModeHandler(IGameModeHandler handler) {
        getInstance().setGameModeHandler(handler);
    }

    public static IDisplayHandler getDisplayHandler() {
        return getInstance().getDisplayHandler();
    }

    public static IPrizeHandler getPrizeHandler() {
        return getInstance().getPrizeHandler();
    }

    public static void setInputEnabled(boolean enabled) {
        getInstance().setInputEnabled(enabled);
    }

    public static void setCreditInputEnabled(boolean enabled) {
        getInstance().setCreditInputEnabled(enabled);
    }
}
