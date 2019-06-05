package slotmachine.ui.view;

import slotmachine.ui.handler.*;

import java.util.ArrayList;
import java.util.List;

class SlotMachineView {
    private MachineView machineView;
    private ICoinSlotView coinSlotView;
    private ILeverView leverView;
    private IPlayView playView;
    private IGameModeView gameModeView;
    private IDisplayHandler displayHandler;
    private IPrizeHandler prizeHandler;
    private IInputHandler playInputHandler;
    private IInputHandler leverInputHandler;
    private IInputHandler creditInputHandler;

    protected SlotMachineView() {
        machineView = new MachineView();

        DisplayView displayView = new DisplayView();
        displayHandler = displayView;

        PayoutTrayView payoutTrayView = new PayoutTrayView();
        prizeHandler = payoutTrayView;

        List<Integer> coinValues = new ArrayList<>();
        coinValues.add(1);
        coinValues.add(5);
        coinValues.add(10);
        coinValues.add(20);
        coinValues.add(50);
        coinValues.add(100);

        coinSlotView = new CoinSlotView(coinValues);
        creditInputHandler = (IInputHandler) coinSlotView;

        leverView = new LeverView();
        leverInputHandler = (IInputHandler) leverView;
        leverInputHandler.setEnabled(false);
        playView = new PlayView();
        playInputHandler = (IInputHandler) playView;
        //playInputHandler.setEnabled(false);

        gameModeView = new GameModeView();

        machineView.addDisplayView(displayView);
        machineView.addCoinSlotView(coinSlotView);
        machineView.addLeverView(leverView);
        machineView.addPlayView(playView);
        machineView.addGameModeView(gameModeView);
        machineView.addPayoutTrayView(payoutTrayView);
    }

    public void show() {
        machineView.show();
    }

    public void setCreditHandler(ICreditHandler handler) {
        coinSlotView.setCreditHandler(handler);
    }

    public void setPlayHandler(IPlayHandler handler) {
        playView.setPlayHandler(handler);
        leverView.setPlayHandler(handler);
    }

    public void setGameModeHandler(IGameModeHandler handler) {
        gameModeView.setGameModeHandler(handler);
    }

    public IDisplayHandler getDisplayHandler() {
        return displayHandler;
    }

    public IPrizeHandler getPrizeHandler() {
        return prizeHandler;
    }

    public void setInputEnabled(boolean enabled) {
        playInputHandler.setEnabled(enabled);
        leverInputHandler.setEnabled(enabled);
        creditInputHandler.setEnabled(enabled);
    }

    public void setCreditInputEnabled(boolean enabled) {
        creditInputHandler.setEnabled(enabled);
    }
}
