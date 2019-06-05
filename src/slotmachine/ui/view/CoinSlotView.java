package slotmachine.ui.view;

import slotmachine.ui.data.ICredit;
import slotmachine.ui.handler.ICreditHandler;
import slotmachine.ui.handler.IInputHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class CoinSlotView implements ICoinSlotView, IInputHandler {
    private JPanel panel;
    private ICreditHandler creditHandler;

    public CoinSlotView(List<Integer> coinValues) {
        int rows = coinValues.size() / 2;
        panel = new JPanel(new GridLayout(rows, 0));
        for (Integer coinValue : coinValues) {
            JButton button = new JButton();
            button.setText("+"+coinValue);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (creditHandler != null) {
                        creditHandler.addCredit(new ICredit() {
                            @Override
                            public int getValue() {
                                return coinValue;
                            }
                        });
                    }
                }
            });
            panel.add(button);
        }
    }

    @Override
    public Component getComponent() {
        return panel;
    }

    @Override
    public void setCreditHandler(ICreditHandler handler) {
        creditHandler = handler;
    }

    @Override
    public void setEnabled(boolean enabled) {
        for (Component component : panel.getComponents()) {
            component.setEnabled(enabled);
        }
    }
}
