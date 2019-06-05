package slotmachine.ui.view;

import slotmachine.ui.handler.IDisplayHandler;

import javax.swing.*;
import java.awt.*;

class DisplayView implements IDisplayView, IDisplayHandler {
    private JLabel label;

    public DisplayView() {
        label = new JLabel();
        label.setText("Insert Credit");
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setBackground(Color.BLACK);
        label.setForeground(Color.GREEN);
        label.setSize(200, 200);
    }

    @Override
    public Component getComponent() {
        return label;
    }

    @Override
    public void setText(String text) {
        label.setText(text);
    }
}
