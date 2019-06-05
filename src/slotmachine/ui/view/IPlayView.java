package slotmachine.ui.view;

import slotmachine.ui.handler.IPlayHandler;

public interface IPlayView extends IView {
    void setPlayHandler(IPlayHandler handler);
}
