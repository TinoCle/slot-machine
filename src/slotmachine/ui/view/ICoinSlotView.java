package slotmachine.ui.view;

import slotmachine.ui.handler.ICreditHandler;

public interface ICoinSlotView extends IView {
    void setCreditHandler(ICreditHandler handler);
}
