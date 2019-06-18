package slotmachine.ui.view;

import slotmachine.ui.handler.*;

import java.util.List;

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

    public static void setResetHandler(IResetHandler handler){
        getInstance().setResetHandler(handler);
    }

    public static void setRecordHandler(IRecordHandler handler){
        getInstance().setRecordHandler(handler);
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

    public static void setReelsQuantity (int reelsQuantity){
        getInstance().addReels(reelsQuantity);
    }

    public static IReelsHandler getReelsHandler(){
        return getInstance().getReelsHandler();
    }

    public static void setResult(List<String> result){

    }

}
