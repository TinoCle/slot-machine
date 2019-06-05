package slotmachine.ui.view;


import slotmachine.ui.handler.IGameModeHandler;

public interface IGameModeView extends IView {
    void setGameModeHandler(IGameModeHandler handler);
}
