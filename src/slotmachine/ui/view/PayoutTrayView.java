package slotmachine.ui.view;

import slotmachine.ui.handler.IPrizeHandler;

import javax.swing.*;
import java.awt.*;

class PayoutTrayView implements IPayoutTrayView, IPrizeHandler {
    private JLabel label;

    public PayoutTrayView() {
        label = new JLabel();
        label.setText("");
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setBackground(Color.BLUE);
        label.setForeground(Color.WHITE);
        label.setSize(100, 100);
    }

    @Override
    public Component getComponent() {
        return label;
    }

    @Override
    public void retrieve(int prize) {
        label.setText("Your prize: " + prize);
    }
}
