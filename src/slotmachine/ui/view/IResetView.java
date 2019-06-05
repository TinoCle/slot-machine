package slotmachine.ui.view;

import slotmachine.ui.handler.IResetHandler;

public interface IResetView extends IView {
    void setResetHandler(IResetHandler handler);
}
